package controller;

import java.io.IOException;
import java.util.Map;

import member.MemberService;
import selectMenu.ScanUtil;
import selectMenu.View;

public class Controller {

	public static void main(String[] args) throws IOException{
		System.out.println("** 하이마트에 오신것을 환영합니다. **");

		new Controller().start();
	}

	public static Map<String, Object> loginUser;

	private MemberService memberService = MemberService.getInstance();

	private void start() throws IOException {
		int view = View.HOME;

		while (true) {
			switch (view) {
			case View.HOME:	view = home();break;
			case View.LOGIN:	view = memberService.login();	break;
			case View.JOIN:	view = memberService.join();	break;
//			case View.PURCHASE: view = 
			}
		}
	}

	private int home() {
		try {
			System.out.println("[ 1.로그인\t2.회원가입\t0.프로그램 종료 ]");
//		System.out.println("--------------------------------");
			System.out.print("번호를 입력해주세요 ->  ");			
			
			int input = ScanUtil.nextInt();

			switch (input) {
			case 1:
				return View.LOGIN;
			case 2:
				return View.JOIN;
			case 0:
				System.out.println("이용해주셔서 감사합니다.");
				System.exit(0);
			default:
				System.out.println("다시 입력해주세요.");
				break;
			}
			return View.HOME;
		} catch (NumberFormatException e) {
			System.out.println("메뉴 선택은 숫자로만 입력해 주세요");
			
		}
		return View.HOME;
	}
	
	
	
}







