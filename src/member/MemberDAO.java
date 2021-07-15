package member;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import selectMenu.JDBCUtil;

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

	private static JDBCUtil jdbc = JDBCUtil.getInstance();

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

		return jdbc.update(sql, param);

	}
	// 로그인 메소드
	public static Map<String, Object> memberselect(String memberId, String memberPassword) {
		String sql = "SELECT MEM_ID, MEM_PW, MEM_NAME"
				+ " FROM MEMBER"
				+ " WHERE MEM_ID = ?"
				+ " AND MEM_PW = ?";
		List<Object> param = new ArrayList<>();
		param.add(memberId);
		param.add(memberPassword);
		
		return jdbc.selectOne(sql, param);
		
	}
	//회원정보 조회 메소드
	
	public static List<Map<String,Object>> memberInformation(String user) {
		String sql = "SELECT * FROM MEMBER"
				+ "WHERE MEM_ID = ?";
		List<Object> param = new ArrayList<>();
		param.add(user);
		
		
		return jdbc.selectList(sql);
	}
	
}
