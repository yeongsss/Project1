package controller;

import java.util.Map;

import member.MemberService;
import selectMenu.ScanUtil;
import selectMenu.View;

public class Controller {

	public static void main(String[] args) {

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
			case View.LOGIN:
				view = memberService.login();
				break;
			case View.JOIN:
				view = memberService.join();
				break;


			}
		}
	}

	private int home() {
		System.out.println("--------------------------------");
		System.out.println("1.로그인\t2.회원가입\t0.프로그램 종료");
		System.out.println("--------------------------------");
		System.out.print("번호 입력>");

		int input = ScanUtil.nextInt();

		switch (input) {
		case 1:
			return View.LOGIN;
		case 2:
			return View.JOIN;
		case 0:
			System.out.println("프로그램이 종료되었습니다.");
			System.exit(0);
			break;
		}
		return View.HOME;
	}

}
