package selectMenu;

import java.util.List;
import java.util.Scanner;


public class Menu {
	// 회원 메뉴
	public void member() throws Exception {
		Scanner scanner = new Scanner(System.in);
		menu: while (true) {
			System.out.println(Util.LOGIN + " :로그인");
			System.out.println(Util.JOIN_MEMBERSHIP + " :회원가입");
			System.out.println(Util.EXIT_PROGRAM + " :이전메뉴");

			int choice = Util.nextInt();

			switch (choice) {
			case Util.LOGIN:
				break;

			case Util.JOIN_MEMBERSHIP:
				
				break;

			case Util.EXIT_PROGRAM:

				break menu;

			default:
				System.out.println("잘못된 메뉴를 입력했습니다. 다시 선택해 주세요.");
				break;
			}
		}
	}

	// 관리자 메뉴
	public void manager() throws Exception {
		menu: while (true) {
			System.out.println(Util.PRODUCT_MANAGEMENT + " :상품관리");
			System.out.println(Util.SALES_MANAGEMENT + " :매출관리");
			System.out.println(Util.CUSTOMER_INFORMATION_MANAGEMENT + " :고객정보관리");
			System.out.println(Util.EXIT_PROGRAM + " :이전메뉴");

			int choice = Util.nextInt();

			switch (choice) {
			case Util.PRODUCT_MANAGEMENT:
				// 관리자 상품관리 서브메뉴 메소드로 이동
				new Menu().productManagement();

				break;

			case Util.SALES_MANAGEMENT:
				// 관리자 상품관리 서브메뉴 메소드로 이동
				new Menu().salesManagement();

				break;
			case Util.CUSTOMER_INFORMATION_MANAGEMENT:
				// 관리자 고객정보 관리 서브메뉴 메소드로 이동 (구현 필요)

				break;
			case Util.EXIT_PROGRAM:

				break menu;

			default:
				System.out.println("잘못된 메뉴를 입력했습니다. 다시 선택해 주세요.");
				break;
			}
		}
	}

	// 관리자 상품관리 서브메뉴
	public void productManagement() throws Exception {
		menu: while (true) {
			System.out.println(Util.REGISTER_PRODUCT + " :상품등록");
			System.out.println(Util.PRODUCT_MODIFICATION + " :상품수정");
			System.out.println(Util.PRODUCT_DELETE + " :상품삭제");
			System.out.println(Util.EXIT_PROGRAM + " :이전메뉴");

			int choice = Util.nextInt();

			switch (choice) {
			case Util.REGISTER_PRODUCT:
				// 상품 등록, DAO, DTO 구현 후, 메소드 넣을 것 (구현 필요)

				break;

			case Util.PRODUCT_MODIFICATION:
				// 상품 수정, DAO, DTO 구현 후, 메소드 넣을 것 (구현 필요)

				break;
			case Util.PRODUCT_DELETE:
				// 상품 삭제, DAO, DTO 구현 후, 메소드 넣을 것 (구현 필요)

				break;
			case Util.EXIT_PROGRAM:

				break menu;

			default:
				System.out.println("잘못된 메뉴를 입력했습니다. 다시 선택해 주세요.");
				break;
			}
		}
	}

	// 관리자 매출관리 서브메뉴
	public void salesManagement() throws Exception {
		menu: while (true) {
			System.out.println(Util.CHECK_SALES_PERIOD + " :기간별 매출 조회");
			System.out.println(Util.CHECK_SALES_PRODUCT + " :상품별 매출 조회");
			System.out.println(Util.CHECK_GENDER_SALES + " :성별 매출 조회");
			System.out.println(Util.EXIT_PROGRAM + " :이전메뉴");

			int choice = Util.nextInt();

			switch (choice) {
			case Util.CHECK_SALES_PERIOD:
				// 기간별 매출조회 서브메뉴 메소드로 이동 (구현 필요)
				break;

			case Util.CHECK_SALES_PRODUCT:
				// 상품별 매출조회 서브메뉴 메소드로 이동 (구현 필요)

				break;
			case Util.CHECK_GENDER_SALES:
				// 성별 매출조회 서브메뉴 메소드로 이동 (구현 필요)

				break;
			case Util.EXIT_PROGRAM:

				break menu;

			default:
				System.out.println("잘못된 메뉴를 입력했습니다. 다시 선택해 주세요.");
				break;
			}
		}
	}
	// 관리자 고객정보 관리 서브메뉴 (구현 필요)
}
