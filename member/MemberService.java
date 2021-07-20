package member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.Controller;
import orderList.OrderListService;
import product.ProductService;
import purchase.PurchaseService;
import qnaBoard.QnABoardService;
import selectMenu.JDBCUtil;
import selectMenu.ScanUtil;
import selectMenu.View;
import wishList.WishListService;

public class MemberService {

	private static MemberService instance;

	private MemberService() {
	}

	public static MemberService getInstance() {
		if (instance == null) {
			instance = new MemberService();
		}
		return instance;
	}

	private static JDBCUtil jdbcUtil = JDBCUtil.getInstance();
	private static PurchaseService purchaseService = PurchaseService.getInstance();
	private static ProductService productService = ProductService.getInstance();
	private static QnABoardService qnaBoardService = QnABoardService.getInstance();
//	private static WishListService WishListService = WishListService.getInstance();
	

	public int join() {
		
			System.out.println("==================================== 회원가입 ===================================");
			System.out.print("아이디 : ");
			String memberId = ScanUtil.nextLine();
			if (memberId.length() >= 12) {
				System.out.println("아이디는 12글자까지만 입력 가능합니다");
				return join();
			
			}
			Map<String, Object> user = MemberDAO.idCheck(memberId);
			if (user.get("COUNT(*)").toString().equals("0")) {
				
			}
			else {
				System.out.println("이미 가입된 아이디 입니다 다른 아이디를 입력하세요");
				return join();
			}
			System.out.print("비밀번호: ");
			String memberPassword = ScanUtil.nextLine();
			System.out.print("이름: ");
			String memberName = ScanUtil.nextLine();
			System.out.print("생년월일: ");
			String memberBirth = ScanUtil.nextLine();
			if (memberBirth.length() >= 8) {
				System.out.println("생년월일은 990801-1 과 같은 형식으로 입력해 주세요");
				System.out.print("생년월일을 재입력: ");
				memberBirth = ScanUtil.nextLine();

			}
			System.out.print("전화번호: ");
			String memberHp = ScanUtil.nextLine();
			System.out.print("기본주소: ");
			String memberAdd1 = ScanUtil.nextLine();
			System.out.print("상세주소: ");
			String memberAdd2 = ScanUtil.nextLine();
			String author = "0"; // 기본 회원가입은 모두 일반회원으로 가입 됨
			Map<String, Object> param = new HashMap<>();
			param.put("MEM_ID", memberId);
			param.put("MEM_PW", memberPassword);
			param.put("MEM_NAME", memberName);
			param.put("MEM_BIRTH", memberBirth);
			param.put("MEM_HP", memberHp);
			param.put("MEM_ADD1", memberAdd1);
			param.put("MEM_ADD2", memberAdd2);
			param.put("AUTHOR", author);

			int result = MemberDAO.insertMember(param);

			if (0 < result) {
				System.out.println("회원가입에 성공했습니다.");
			} else {
				System.out.println("회원가입에 실패했습니다.");
			
			}
			
			return View.HOME;
			
		}

// 로그인실패시  다시 입력받기 OR 메인화면 이동 선택가능하게 수정
	public int login() throws IOException {
		try {
			System.out.println("==================================== 로그인 =====================================");
			while (true) {
				System.out.print("아이디 :  ");
				String userId = ScanUtil.nextLine();
				System.out.print("비밀번호 :  ");
				String password = ScanUtil.nextLine();
				Map<String, Object> user = MemberDAO.memberselect(userId, password);

				if (user == null) {
					System.out.println(">>아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
					System.out.println("-------------------------------------------------------");
					System.out.println("[ 1.다시입력 \t 2.메인화면 ]");
					int input = ScanUtil.nextInt();
					switch (input) {
					case 1:
						break;
					case 2:
						return View.HOME;
					}

				} else {
					Controller.loginUser = user; // 접속한 유저를 확인하기 위한 변수
					System.out.println(Controller.loginUser.get("MEM_NAME") + "님 어서오세요!");
					if (Controller.loginUser == null) {
						return View.HOME;
					}
					if (Controller.loginUser.get("AUTHOR").equals("1") == true) {

						mypageAdmin(); // 권한이 관리자면 관리자 페이지로 이동함.

					}
					return memberLoginMenu(); // 일반회원 로그인 성공하면, 마이페이지로 이동.

				}
			}
		} catch (NumberFormatException e) {
			System.out.println("※ 메뉴 선택은 숫자로만 입력해 주세요 ※");
		}
		return login();
	}
//		return View.HOME; // 로그인 실패시, 다시 메인화면으로 이동함
	
	public int memberLoginMenu() throws IOException {

		if (Controller.loginUser == null) {
			return View.HOME;
		}
		
		System.out.println();
		System.out.println("=================================== 일반 회원 ===================================");
		System.out.println("1.마이페이지 \t 2.상품메뉴 \t 3. 장바구니\t 4.위시리스트 \t 0. 로그아웃 ");
		System.out.println("=================================================================================");
		System.out.print("번호 입력: ");
		
		switch (ScanUtil.nextInt()) {
		case 1: 
			System.out.println();
			System.out.println(">> 마이페이지로 이동합니다.");
			return myPage();
			
		case 2:
			System.out.println();
			System.out.println(">> 상품메뉴로 이동합니다.");
			return productService.productList();
		
		case 3:
			System.out.println();
			System.out.println(">> 장바구니로 이동합니다.");
			return OrderListService.getInstance().orderList();
		case 4: 
			System.out.println();
			System.out.println(">> 위시리스트로 이동합니다.");
			return WishListService.getInstance().Wishlist();
		case 0:
			Controller.loginUser = null;
			System.out.println();
			System.out.println(">> 로그아웃 되었습니다"); 
			return View.HOME;
			
			
		}
		return memberLoginMenu();
		
		
		
	}
	
	
	
	
	
	//  마이페이지(일반회원) 접속 뷰
	private int myPage() throws IOException {
		try {
			System.out.println();
			System.out.println("---------------------------------- 마이페이지 -----------------------------------");
			System.out.println("1.내정보 조회 \t 2.내정보 수정 \t 3.주문내역 \t 0.이전메뉴");
			System.out.println("---------------------------------------------------------------------------------");
			System.out.print("번호 입력 :  ");

			switch (ScanUtil.nextInt()) {
			case 1:
				System.out.println();
				System.out.println(">> 내정보를 조회합니다.");
				List<Map<String, Object>> memberInfo = MemberDAO.getMemberInfo((String) Controller.loginUser.get("MEM_ID"));
				for (Map<String, Object> map : memberInfo) {
					System.out.printf("아이디: %s\n이름: %s\n생년월일: %s\n전화번호: %s\n기본주소: %s\n상세주소: %s\n", map.get("MEM_ID"),
							map.get("MEM_NAME"), map.get("MEM_BIRTH"), map.get("MEM_HP"), map.get("MEM_ADD1"),
							map.get("MEM_ADD2"));
				}

				return myPage();

			case 2:
				System.out.println();
				System.out.println(">> 수정할 정보를 선택하세요.");
				return editInfo();// 정보 수정 뷰로 이동함
			case 3:
				System.out.println();
				System.out.println(">> 주문내역을 조회합니다.");
				List<Map<String, Object>> list = MemberDAO.getOrderList(Controller.loginUser.get("MEM_ID"));
				for (Map<String, Object> map : list) {
					System.out.printf("주문번호: %s\t주문일자: %s\t주문가격: %s\n", map.get("ORD_NO"),
							map.get("ORD_DATE").toString().split("")[0], map.get("PAY_PRICE"));

				}
				return myPage(); // 주문내역 결과 반환후, 마이페이지로 다시 이동함.
			case 0:
				
				return memberLoginMenu();

			}
			return myPage(); // 주문내역 결과 반환후, 마이페이지로 다시 이동함.
		} catch (NumberFormatException e) {
			System.out.println("메뉴 선택은 숫자로만 입력해 주세요");
		}
		return myPage();

	}

	private int editInfo() throws IOException {
		try {
			System.out.println("------------------------------변경할 내용을 선택해 주세요------------------------");
			System.out.println("1.비밀번호\t2.전화번호\t3.일반주소\t4.상세주소\t0.이전메뉴");
			System.out.println("---------------------------------------------------------------------------------");
			System.out.print("번호 입력: ");
			int input = ScanUtil.nextInt();

			switch (input) {
			case 1:
				System.out.println();
				MemberDTO memberDTO = new MemberDTO();
				System.out.print("변경할 비밀번호를 입력하세요: ");
				memberDTO.setMemberPassword(ScanUtil.nextLine());
				memberDTO.setMemberId((String) Controller.loginUser.get("MEM_ID"));
				// 아이디는 로그인한 아이디의 값을 그대로 적용함.
				if (MemberDAO.MemberInfoModifyPw(memberDTO)) {
					System.out.println("변경 성공");
				} else {
					System.out.println("변경 실패");
				}
				break;

			case 2:
				System.out.println();
				memberDTO = new MemberDTO();
				System.out.print("변경할 전화번호를 입력하세요: ");
				memberDTO.setMemberHp(ScanUtil.nextLine());
				memberDTO.setMemberId((String) Controller.loginUser.get("MEM_ID"));
				// 아이디는 로그인한 아이디의 값을 그대로 적용함.
				if (MemberDAO.MemberInfoModifyHp(memberDTO)) {
					System.out.println("변경 성공");
				} else {
					System.out.println("변경 실패");
				}
				break;

			case 3:
				System.out.println();
				memberDTO = new MemberDTO();
				System.out.print("변경할 일반주소를 입력하세요: ");
				memberDTO.setMemberAdd1(ScanUtil.nextLine());
				memberDTO.setMemberId((String) Controller.loginUser.get("MEM_ID"));
				// 아이디는 로그인한 아이디의 값을 그대로 적용함.
				if (MemberDAO.MemberInfoModifyAdd1(memberDTO)) {
					System.out.println("변경 성공");
				} else {
					System.out.println("변경 실패");
				}
				break;
			case 4:
				System.out.println();
				memberDTO = new MemberDTO();
				System.out.print("변경할 상세주소를 입력하세요: ");
				memberDTO.setMemberAdd2(ScanUtil.nextLine());
				memberDTO.setMemberId((String) Controller.loginUser.get("MEM_ID"));
				// 아이디는 로그인한 아이디의 값을 그대로 적용함.
				if (MemberDAO.MemberInfoModifyAdd2(memberDTO)) {
					System.out.println("변경 성공");
				} else {
					System.out.println("변경 실패");
				}
				break;
			case 0:
				return myPage();
			}
			return editInfo();
		} catch (NumberFormatException e) {
			System.out.println("메뉴 선택은 숫자로만 입력해 주세요");
		}
		return editInfo();
	}
	// 관리자 로그인 화면
	public int mypageAdmin() throws IOException {
		try {
			System.out.println();
			System.out.println("======================================== 관리자 =========================================");
			System.out.println(" 1.회원관리 \t 2.상품관리 \t 3.매입관리 \t 4.Q&A관리 \t 0.로그아웃  ");
			System.out.println("=========================================================================================");
			System.out.print("번호 입력 :  ");
			int input = ScanUtil.nextInt();
			System.out.println();

			switch (input) {
			case 1:
				System.out.println(">>  회원관리 페이지로 이동합니다");
				return memberManagement();

			case 2:
				System.out.println(">>  상품관리 페이지로 이동합니다");
				return productService.productManagement();

			case 3:
				System.out.println(">>  매입관리 페이지로 이동합니다");
				return purchaseService.purchaseManagement();
			case 4:
				System.out.println(">>  Q&A관리 페이지로 이동합니다");
				return qnaBoardService.boardManagement();
			case 0:
				Controller.loginUser = null;
				System.out.println("로그아웃 되었습니다.");
				return View.HOME;

			}
		} catch (NumberFormatException e) {
			System.out.println("메뉴 선택은 숫자로만 입력해 주세요");
		}
		return mypageAdmin();

	}

	private int memberManagement() throws IOException {
		try {
			System.out.println();
			System.out.println("----------------------------------- 회원관리 ------------------------------------");
			System.out.println("1.회원정보 보기 \t 2.회원정보 수정 \t 3.권한 수정 \t 0.이전페이지");
			System.out.println("---------------------------------------------------------------------------------");
			System.out.print("번호 입력 :  ");
			int input = ScanUtil.nextInt();

			switch (input) {
			case 1:// 모든 회원들 정보 보기
				System.out.println();
				System.out.println(">> 회원정보를 조회합니다.");
				System.out.println();
				System.out.println("[  \t아이디  | \t이름  |   \t생년월일  | \t전화번호  | \t주소 ]  ");
				System.out.println();
				List<Map<String, Object>> list = MemberDAO.getMemberAllInfo();
				int cnt = 1;
				for (Map<String, Object> map : list) {
					System.out.printf("%s\t%s\t\t%s\t\t%s\t\t %s  \t %s  %s\t [%s]\n", cnt++, map.get("MEM_ID"),
							map.get("MEM_NAME"), map.get("MEM_BIRTH"), map.get("MEM_HP"), map.get("MEM_ADD1"),
							map.get("MEM_ADD2"), map.get("AUTHOR"));
				}

				return memberManagement();
			case 2:
				System.out.println();
				System.out.println(">> 회언정보를 수정합니다.");
				return editInfoAdmin();

			case 3:
				// 권한 변경 (수정)
				System.out.println();
				MemberDTO memberDTO = new MemberDTO();
				System.out.print("변경할 회원의 아이디를 입력하세요\n아이디: ");
				memberDTO.setMemberId(ScanUtil.nextLine());
				System.out.print("일반회원 : 0 / 관리자 : 1 \n 선택: ");
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
				String author = bufferedReader.readLine();
				memberDTO.setAuthor(author);

				if (memberDTO.getAuthor() != "0" && memberDTO.getAuthor() != "1") {
					System.out.println("권한은 0 또는 1만 입력 가능합니다.");
					System.out.print("일반회원으로 변경은 0, 관리자로 변경은 1을 입력하세요");
					memberDTO.setAuthor(ScanUtil.nextLine());
				}

				if (MemberDAO.ChangeMemberAuthor(memberDTO)) {
					System.out.println("권한변경 성공");
				} else {
					System.out.println("권한변경 실패");
				}

				return memberManagement();

			case 0:
				return mypageAdmin();
			}
			return memberManagement();
		} catch (NumberFormatException e) {
			System.out.println("메뉴 선택은 숫자로만 입력해 주세요");
			return memberManagement();
		}

	}

	private int editInfoAdmin() throws IOException {
		try {
			System.out.println("--------------변경할 내용을 선택해 주세요------------");
			System.out.println("1.전화번호\t2.일반주소\t3.상세주소\t0.이전메뉴");
			System.out.println("---------------------------------------------");
			System.out.print("번호 입력>");
			int input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				MemberDTO memberDTO = new MemberDTO();
				System.out.print("변경할 아이디를 입력하세요");
				memberDTO.setMemberId(ScanUtil.nextLine());
				System.out.println("변경할 전화번호를 입력하세요");
				memberDTO.setMemberHp(ScanUtil.nextLine());

				if (MemberDAO.MemberInfoModifyHp(memberDTO)) {
					System.out.println("변경 성공");
				} else {
					System.out.println("변경 실패");
				}
				return editInfoAdmin();

			case 2:
				memberDTO = new MemberDTO();
				System.out.print("변경할 아이디를 입력하세요");
				memberDTO.setMemberId(ScanUtil.nextLine());
				System.out.print("변경할 일반주소를 입력하세요");
				memberDTO.setMemberAdd1(ScanUtil.nextLine());
				
				if (MemberDAO.MemberInfoModifyAdd1(memberDTO)) {
					System.out.println("변경 성공");
				} else {
					System.out.println("변경 실패");
				}
				return editInfoAdmin();

			case 3:
				memberDTO = new MemberDTO();
				System.out.print("변경할 아이디를 입력하세요");
				memberDTO.setMemberId(ScanUtil.nextLine());
				System.out.print("변경할 상세주소를 입력하세요");
				memberDTO.setMemberAdd2(ScanUtil.nextLine());
				
				if (MemberDAO.MemberInfoModifyAdd2(memberDTO)) {
					System.out.println("변경 성공");
				} else {
					System.out.println("변경 실패");
				}
				return editInfoAdmin();

			case 0:
				return memberManagement();

			}
			return myPage();
		} catch (NumberFormatException e) {
			System.out.println("메뉴 선택은 숫자로만 입력해 주세요");
		}
		return editInfoAdmin();

	}
}