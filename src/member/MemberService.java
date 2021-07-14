package member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	
	public int search() {
		System.out.println("=========== 회원정보 조회 =============");
		
		List<Map<String,Object>> result = MemberDAO.memberSearch();
		
		
		return View.HOME;
		
	}
}
