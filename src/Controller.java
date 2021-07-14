import java.util.Map;

import member.MemberService;
import selectMenu.Util;
import selectMenu.View;

public class Controller {

	public static void main(String[] args) {
		/*
		 * 발표순서 : 조 소개 > 주제 소개 > 주제 선정 배경 > 메뉴 구조 > 시연 발표인원 : 발표자 1명, ppt 및 시연 도우미 1명
		 * 
		 * Controller : 화면 이동 Service : 화면 기능 Dao : 쿼리작성
		 */

		new Controller().start();
	}

	public static Map<String, Object> loginUser;
	
	private MemberService memberService = MemberService.getInstance();

	private void start() {
		int view = View.HOME;

		while (true) {
			switch (view) {
			case View.HOME:
				view = home();
				break;
					case View.JOIN: view = memberService.join(); break;
//					case View.purchase: view = purchaseService.purchase(); break;
//					case View.BOARD_LIST: view = boardService.boardList(); break;
					
					//조회, 등록, 수정, 삭제를 구현해주세요.
//					case View.BOARD_INSERT_FORM: view = boardService.boardInsertForm(); break;
//					case View.BOARD_VIEW: view = boardService.boardView(); break;
			}
		}
	}

	private int home() {
		System.out.println("--------------------------------");
		System.out.println("1.회원가입\t2.조회\t0.프로그램 종료");
		System.out.println("--------------------------------");
		System.out.print("번호 입력>");

		int input = Util.nextInt();

		switch (input) {
		case 1: return View.JOIN;
		case 2:
			return View.Search;
		case 0:
			System.out.println("프로그램이 종료되었습니다.");
			System.exit(0);
			break;
		}
		return View.HOME;
	}

}
