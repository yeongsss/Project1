package member;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import selectMenu.JDBCUtil;
import selectMenu.ScanUtil;

public class MemberDAO {
	// 싱글톤 패턴
	private MemberDAO() {
	}

	private static MemberDAO instance;

	public static MemberDAO getInstance() {
		if (instance == null) {
			instance = new MemberDAO();

		}
		return instance;
	}

	private static JDBCUtil jdbcUtil = JDBCUtil.getInstance();

	// 회원가입 메소드
	public static int insertMember(Map<String, Object> p) {
		String sql = "INSERT INTO MEMBER VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		List<Object> param = new ArrayList<>();
		param.add(p.get("MEM_ID"));
		param.add(p.get("MEM_PW"));
		param.add(p.get("MEM_NAME"));
		param.add(p.get("MEM_BIRTH"));
		param.add(p.get("MEM_HP"));
		param.add(p.get("MEM_ADD1"));
		param.add(p.get("MEM_ADD2"));
		param.add(p.get("AUTHOR"));

		return jdbcUtil.update(sql, param);

	}

	// 로그인 메소드
	public static Map<String, Object> memberselect(String memberId, String memberPassword) {
		String sql = "SELECT MEM_ID, MEM_PW" + " FROM MEMBER" + " WHERE MEM_ID = ?" + " AND MEM_PW = ?";
		List<Object> param = new ArrayList<>();
		param.add(memberId);
		param.add(memberPassword);

		return jdbcUtil.selectOne(sql, param);

	}
	// 회원정보 조회 메소드

	public static MemberDTO getMemberInfo(Object object) {
		MemberDTO memberInfo = new MemberDTO();
		String sql = "SELECT * FROM MEMBER" + " WHERE" + " MEM_ID= ?";
		List<Object> param = new ArrayList<>();
		param.add(object);
		Map<String, Object> resMap = jdbcUtil.selectOne(sql, param);
		memberInfo.setMemberId((String) resMap.get("MEM_ID"));
		memberInfo.setMemberName((String) resMap.get("MEM_NAME"));
		memberInfo.setMemberBirth((String) resMap.get("MEM_BIRTH"));
		memberInfo.setMemberHp((String) resMap.get("MEM_HP"));

		return memberInfo;
	}
	
	
	
	

}
