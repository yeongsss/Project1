package selectMenu;



public class SelectMenu {

	public void Start() throws Exception {
		menu: while (true) {
			System.out.println(Util.MEMBER_MENU + " :회원 메뉴");
			System.out.println(Util.MANAGER_MENU + " :관리자 메뉴");
			System.out.println(Util.EXIT_PROGRAM + " :프로그램종료");
			int choice = Util.scanner.nextInt();
			//메인 메뉴선택 분기
			switch (choice) {
			case Util.MEMBER_MENU:
				//회원 메뉴
				new Menu().member();
				

				break;
			case Util.MANAGER_MENU:
				//관리자 메뉴
				new Menu().manager();

				break;
			case Util.EXIT_PROGRAM:
				System.out.println("프로그램이 종료되었습니다.");

				break menu;

			default:
				System.out.println("잘못된 메뉴를 입력했습니다. 다시 선택해 주세요.");
				break;
			}
		}

	}
}
