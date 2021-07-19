package member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.Controller;
import product.ProductService;
import purchase.PurchaseService;
import selectMenu.JDBCUtil;
import selectMenu.ScanUtil;
import selectMenu.View;

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
	private static MemberDAO memberDao = MemberDAO.getInstance();
	private static PurchaseService purchaseService = PurchaseService.getInstance();
	private static ProductService productService = ProductService.getInstance();
	

	public int join() {
		System.out.println("=========== 회원가입 =============");
		System.out.print("아이디>");
		String memberId = ScanUtil.nextLine();
		System.out.print("비밀번호>");
		String memberPassword = ScanUtil.nextLine();
		System.out.print("이름>");
		String memberName = ScanUtil.nextLine();
		System.out.print("생년월일>");
		String memberBirth = ScanUtil.nextLine();
		System.out.print("전화번호>");
		String memberHp = ScanUtil.nextLine();
		System.out.print("기본주소>");
		String memberAdd1 = ScanUtil.nextLine();
		System.out.print("상세주소>");
		String memberAdd2 = ScanUtil.nextLine();
		String author = "0"; // 기본 회원가입은 모두 일반회원으로 가입 됨

		// 아이디 중복 확인 생략
		// 비밀번호 확인 생략
		// 정규표현식(유효성 검사) 생략

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

	public int login() {
		System.out.println("============== 로그인 ===============");
		System.out.print("아이디>");
		String userId = ScanUtil.nextLine();
		System.out.print("비밀번호>");
		String password = ScanUtil.nextLine();
		
		
		Map<String, Object> user = MemberDAO.memberselect(userId, password);

		if (user == null) {
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
		} else {
			System.out.println("로그인 성공");
			Controller.loginUser = user; // 접속한 유저를 확인하기 위한 변수
			System.out.println(Controller.loginUser.get("AUTHOR"));
			if (Controller.loginUser.get("AUTHOR").equals("1") == true) {
				
				
				mypageAdmin(); // 권한이 관리자면 관리자 페이지로 이동함.
				
			}
			return myPage(); // 일반회원 로그인 성공하면, 마이페이지로 이동.

		}
		return View.HOME; // 로그인 실패시, 다시 메인화면으로 이동함
	}

	// 로그인 성공 후, 마이페이지(일반회원) 접속 뷰
	private int myPage() {
		System.out.println("------------일반 회원 로그인 되었습니다---------------");
		System.out.println("1.내정보 조회\t2.내정보 수정\t3.주문내역\t0.로그아웃");
		System.out.println("---------------------------------------------");
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			System.out.println("정보를 조회 합니다.");
			System.out.println(MemberDAO.getMemberInfo(Controller.loginUser.get("MEM_ID")));
			return myPage(); // 로그인한 유저의 ID를 가져와서 일치하는 정보를 리턴함.
		case 2:
			System.out.println("수정할 정보를 선택하세요.");
			return editInfo();// 정보 수정 뷰로 이동함
		case 3:
			List<Map<String, Object>> list = MemberDAO.getOrderList(Controller.loginUser.get("MEM_ID"));
			for (Map<String, Object> map : list) {
				System.out.printf("%s\t\t%s\t%s\n", map.get("ORD_NO"), map.get("ORD_DATE").toString().split("")[0],
						map.get("PAY_PRICE"));

			}
			return myPage(); // 주문내역 결과 반환후, 마이페이지로 다시 이동함.
		case 0:
			System.out.println("로그아웃 되었습니다.");
			return View.HOME;

		}
		return myPage(); // 잘못된 명령 입력시, 다시 마이페이지로 돌아옴
	}

	private int editInfo() {
		System.out.println("--------------변경할 내용을 선택해 주세요------------");
		System.out.println("1.비밀번호\t2.전화번호\t3.일반주소\t4.상세주소\t0.이전메뉴");
		System.out.println("---------------------------------------------");
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();

		switch (input) {
		case 1:
			MemberDTO memberDTO = new MemberDTO();
			System.out.print("변경할 비밀번호를 입력하세요");
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
			memberDTO = new MemberDTO();
			System.out.print("변경할 전화번호를 입력하세요");
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
			memberDTO = new MemberDTO();
			System.out.print("변경할 일반주소를 입력하세요");
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
			memberDTO = new MemberDTO();
			System.out.print("변경할 상세주소를 입력하세요");
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
			System.out.println("프로그램이 종료되었습니다.");
			break;

		}
		return myPage();
	}

	// 관리자 로그인 화면
	public int mypageAdmin() {
		System.out.println("-------------관리자 회원 로그인 되었습니다------------");
		System.out.println("1.회원관리\t2.상품관리\t3.매입관리\t4.Q&A관리\t0.로그아웃");
		System.out.println("--------------------------------------------");
		System.out.print("번호 입력>");

		int input = ScanUtil.nextInt();

		switch (input) {
		case 1:
			System.out.println("회원관리 페이지로 이동합니다");
			return memberManagement();

		case 2:
			System.out.println("상품관리 페이지로 이동합니다");
			return productService.productManagement();

		case 3:
			System.out.println("매입관리 페이지로 이동합니다");
			return purchaseService.purchaseManagement();
		case 4:
			System.out.println("Q&A관리 페이지로 이동합니다");
			break;
		case 0:
			System.out.println("로그아웃 되었습니다.");
			return View.HOME;

		}
		return mypageAdmin();

	}

	private int memberManagement() {
		System.out.println("---------회원관리 페이지 입니다------------------");
		System.out.println("1.회원정보 보기\t2.회원정보 수정\t3.권한 수정\t0.이전페이지");
		System.out.println("------------------------------------------");
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();

		switch (input) {
		case 1:// 모든 회원들 정보 보기
			System.out.println("회원정보를 조회합니다.");
			List<Map<String, Object>> list = MemberDAO.getMemberAllInfo();

			for (Map<String, Object> map : list) {
				System.out.printf("%s\t%s\t%s\t%s\n", map.get("MEM_ID"), map.get("MEM_NAME"), map.get("MEM_BIRTH"),
						map.get("MEM_HP"));
			}
			return memberManagement();
		case 2:

			return memberManagement();

		case 3:
			// 권한 변경 (수정)
			MemberDTO memberDTO = new MemberDTO();
			System.out.print("변경할 회원의 아이디를 입력하세요");
			memberDTO.setMemberId(ScanUtil.nextLine());
			System.out.print("일반회원으로 변경은 0, 관리자로 변경은 1을 입력하세요");
			memberDTO.setAuthor(ScanUtil.nextLine());
			if (MemberDAO.MemberInfoModifyHp(memberDTO)) {
				System.out.println("권한변경 성공");
			} else {
				System.out.println("권한변경 실패");
			}

			return memberManagement();

		case 0:
			return mypageAdmin();
		}
		return memberManagement();

	}

}
