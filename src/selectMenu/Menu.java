package selectMenu;

public class Menu {
	//회원 메뉴
	public void member() throws Exception {
		menu: while (true) {
			System.out.println(Select.LOGIN + " :로그인");
			System.out.println(Select.JOIN_MEMBERSHIP + " :회원가입");
			System.out.println(Select.EXIT_PROGRAM + " :이전메뉴");

			int choice = Select.SCANNER.nextInt();

			switch (choice) {
			case Select.LOGIN:
				break;
				//로그인 후, 결제 등 서브메뉴로 이동 메소드 (구현 필요),
			case Select.JOIN_MEMBERSHIP:
				//회원가입 메소드 구현, 정규식으로 가입 제약조건 설정 필요
				break;
			
			case Select.EXIT_PROGRAM:

				break menu;

			default:
				System.out.println("잘못된 메뉴를 입력했습니다. 다시 선택해 주세요.");
				break;
			}
		}
	}
	//관리자 메뉴
	public void manager() throws Exception {
		menu: while (true) {
			System.out.println(Select.PRODUCT_MANAGEMENT + " :상품관리");
			System.out.println(Select.SALES_MANAGEMENT + " :매출관리");
			System.out.println(Select.CUSTOMER_INFORMATION_MANAGEMENT + " :고객정보관리");
			System.out.println(Select.EXIT_PROGRAM + " :이전메뉴");

			int choice = Select.SCANNER.nextInt();

			switch (choice) {
			case Select.PRODUCT_MANAGEMENT:
				//관리자 상품관리 서브메뉴 메소드로 이동
				new Menu().productManagement();

				break;

			case Select.SALES_MANAGEMENT:
				//관리자 상품관리 서브메뉴 메소드로 이동
				new Menu().salesManagement();

				break;
			case Select.CUSTOMER_INFORMATION_MANAGEMENT:
				//관리자 고객정보 관리 서브메뉴 메소드로 이동 (구현 필요)
				

				break;
			case Select.EXIT_PROGRAM:

				break menu;

			default:
				System.out.println("잘못된 메뉴를 입력했습니다. 다시 선택해 주세요.");
				break;
			}
		}
	}
	//관리자 상품관리 서브메뉴
	public void productManagement() throws Exception {
		menu: while (true) {
			System.out.println(Select.REGISTER_PRODUCT + " :상품등록");
			System.out.println(Select.PRODUCT_MODIFICATION + " :상품수정");
			System.out.println(Select.PRODUCT_DELETE + " :상품삭제");
			System.out.println(Select.EXIT_PROGRAM + " :이전메뉴");

			int choice = Select.SCANNER.nextInt();

			switch (choice) {
			case Select.REGISTER_PRODUCT:
				//상품 등록, DAO, DTO 구현 후, 메소드 넣을 것 (구현 필요)
				
				break;

			case Select.PRODUCT_MODIFICATION:
				//상품 수정, DAO, DTO 구현 후, 메소드 넣을 것 (구현 필요)

				break;
			case Select.PRODUCT_DELETE:
				//상품 삭제, DAO, DTO 구현 후, 메소드 넣을 것 (구현 필요)

				break;
			case Select.EXIT_PROGRAM:

				break menu;

			default:
				System.out.println("잘못된 메뉴를 입력했습니다. 다시 선택해 주세요.");
				break;
			}
		}
	}
	//관리자 매출관리 서브메뉴
	public void salesManagement() throws Exception {
		menu: while (true) {
			System.out.println(Select.CHECK_SALES_PERIOD + " :기간별 매출 조회");
			System.out.println(Select.CHECK_SALES_PRODUCT + " :상품별 매출 조회");
			System.out.println(Select.CHECK_GENDER_SALES + " :성별 매출 조회");
			System.out.println(Select.EXIT_PROGRAM + " :이전메뉴");

			int choice = Select.SCANNER.nextInt();

			switch (choice) {
			case Select.CHECK_SALES_PERIOD:
				//기간별 매출조회 서브메뉴 메소드로 이동 (구현 필요)
				break;

			case Select.CHECK_SALES_PRODUCT:
				//상품별 매출조회 서브메뉴 메소드로 이동 (구현 필요)

				break;
			case Select.CHECK_GENDER_SALES:
				//성별 매출조회 서브메뉴 메소드로 이동 (구현 필요)

				break;
			case Select.EXIT_PROGRAM:

				break menu;

			default:
				System.out.println("잘못된 메뉴를 입력했습니다. 다시 선택해 주세요.");
				break;
			}
		}
	}
	//관리자 고객정보 관리 서브메뉴 (구현 필요)
}
