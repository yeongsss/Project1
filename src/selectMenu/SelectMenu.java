package project;



public class SelectMenu {

	public void Start() throws Exception {
		menu: while (true) {
			System.out.println(Select.MEMBER_MENU + " :회원 메뉴");
			System.out.println(Select.MANAGER_MENU + " :관리자 메뉴");
			System.out.println(Select.EXIT_PROGRAM + " :프로그램종료");
			int choice = Select.SCANNER.nextInt();

			switch (choice) {
			case Select.MEMBER_MENU:
				new Menu().member();
				

				break;
			case Select.MANAGER_MENU:
				new Menu().manager();

				break;
			case Select.EXIT_PROGRAM:
				System.out.println("프로그램이 종료되었습니다.");

				break menu;

			default:
				System.out.println("잘못된 메뉴를 입력했습니다. 다시 선택해 주세요.");
				break;
			}
		}

	}
}
