package project;

public class Menu {

	public void manager() throws Exception {
		menu: while (true) {
			System.out.println(Select.PRODUCT_MANAGEMENT + " :상품관리");
			System.out.println(Select.SALES_MANAGEMENT + " :매출관리");
			System.out.println(Select.CUSTOMER_INFORMATION_MANAGEMENT + " :고객정보관리");
			System.out.println(Select.EXIT_PROGRAM + " :이전메뉴");

			int choice = Select.SCANNER.nextInt();

			switch (choice) {
			case Select.PRODUCT_MANAGEMENT:

				break;

			case Select.SALES_MANAGEMENT:

				break;
			case Select.CUSTOMER_INFORMATION_MANAGEMENT:

				break;
			case Select.EXIT_PROGRAM:

				break menu;

			default:
				System.out.println("잘못된 메뉴를 입력했습니다. 다시 선택해 주세요.");
				break;
			}
		}
	}

	public void member() throws Exception {
		menu: while (true) {
			System.out.println(Select.LOGIN + " :로그인");
			System.out.println(Select.JOIN_MEMBERSHIP + " :회원가입");
			System.out.println(Select.PAYMENT + " :결제");
			System.out.println(Select.EXIT_PROGRAM + " :이전메뉴");

			int choice = Select.SCANNER.nextInt();

			switch (choice) {
			case Select.LOGIN:

				break;

			case Select.JOIN_MEMBERSHIP:

				break;
			case Select.PAYMENT:

				break;
			case Select.EXIT_PROGRAM:

				break menu;

			default:
				System.out.println("잘못된 메뉴를 입력했습니다. 다시 선택해 주세요.");
				break;
			}
		}
	}
}
