package member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.Controller;
import selectMenu.Util;
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

	private MemberDAO memberDao = MemberDAO.getInstance();

	public int join() {
		System.out.println("=========== 회원가입 =============");
		System.out.print("아이디>");
		String memberId = Util.nextLine();
		System.out.print("비밀번호>");
		String memberPassword = Util.nextLine();
		System.out.print("이름>");
		String memberName = Util.nextLine();
		System.out.print("생년월일>");
		String memberBirth = Util.nextLine();
		System.out.print("전화번호>");
		String memberHp = Util.nextLine();
		System.out.print("기본주소>");
		String memberAdd1 = Util.nextLine();
		System.out.print("상세주소>");
		String memberAdd2 = Util.nextLine();
		String author = "0";

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
		String userId = Util.nextLine();
		System.out.print("비밀번호>");
		String password = Util.nextLine();
		
		Map<String, Object> user = MemberDAO.memberselect(userId, password);
		
		if(user == null){
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
		}else{
			System.out.println("로그인 성공");
			Controller.loginUser = user; //접속한 유저를 확인하기 위한 변수
			
			
			
		
		
		return myPage(); //로그인 성공하면, 마이페이지로 이동.
		
	}
		return View.HOME; //로그인 실패시, 다시 메인화면으로 이동함
}
	//로그인 성공 후, 마이페이지 접속 뷰
	private int myPage() {
		System.out.println("--------------------------------------------");
		System.out.println("1.내정보 조회\t2.내정보 수정\t3.주문내역\t0.로그아웃");
		System.out.println("---------------------------------------------");
		System.out.print("번호 입력>");
		
		int input = Util.nextInt();

		switch (input) {
		case 1: return myPage();
		case 2: return myPage();
		case 3: return myPage();
		case 0:
			System.out.println("프로그램이 종료되었습니다.");
			System.exit(0);
			break;
			
		
			
	
		
		
		
		
	}
		return myPage(); //잘못된 명령 입력시, 다시 마이페이지로 돌아옴
}
}
