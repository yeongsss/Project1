package member;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import orderSheet.OrderSheetDTO;
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
		String sql = "SELECT * " + " FROM MEMBER" + " WHERE MEM_ID = ?" + " AND MEM_PW = ?";
		List<Object> param = new ArrayList<>();
		param.add(memberId);
		param.add(memberPassword);
		return jdbcUtil.selectOne(sql, param);

	}
	// 아이디 중복검사
	
	public static Map<String, Object> idCheck(String memberId) {
		String sql = "SELECT COUNT(*) FROM MEMBER" + " WHERE MEM_ID = ?";
		List<Object> param = new ArrayList<>();
		param.add(memberId);
		return jdbcUtil.selectOne(sql, param);
	}	
	
	
	// 내정보 조회 메소드

	
	
	public static List<Map<String, Object>> getMemberInfo(String memberId) {
		MemberDTO memberInfo = new MemberDTO();
		String sql = "SELECT * FROM MEMBER" + " WHERE" + " MEM_ID= ?";
		List<Object> param = new ArrayList<>();
		param.add(memberId);
			
		
		return jdbcUtil.selectList(sql, param);

	}
	
	
	
	//회원비밀번호 수정 메소드
	
	public static boolean MemberInfoModifyPw(MemberDTO update) {
		String sql = "UPDATE MEMBER SET" + " MEM_PW = ?" 
				     + " WHERE MEM_ID = ?";
				
		List<Object> list = new ArrayList<>();
		list.add(update.getMemberPassword());
		list.add(update.getMemberId());
		
		if (jdbcUtil.update(sql, list) == 1) {
			return true;
		}
		return false;
		
	}	
	
	//회원 전화번호 수정 메소드
	public static boolean MemberInfoModifyHp(MemberDTO update) {
		String sql = "UPDATE MEMBER SET" + " MEM_HP = ?" 
				     + " WHERE MEM_ID = ?";
				
		List<Object> list = new ArrayList<>();
		list.add(update.getMemberHp());
		list.add(update.getMemberId());
		
		if (jdbcUtil.update(sql, list) == 1) {
			return true;
		}
		return false;
		
	}	
	
	//회원 기본주소 수정 메소드
		public static boolean MemberInfoModifyAdd1(MemberDTO update) {
			String sql = "UPDATE MEMBER SET" + " MEM_ADD1 = ?" 
					     + " WHERE MEM_ID = ?";
					
			List<Object> list = new ArrayList<>();
			list.add(update.getMemberAdd1());
			list.add(update.getMemberId());
			
			if (jdbcUtil.update(sql, list) == 1) {
				return true;
			}
			return false;
			
		}	
		
		//회원 상세주소 수정 메소드
				public static boolean MemberInfoModifyAdd2(MemberDTO update) {
					String sql = "UPDATE MEMBER"
										+ " 		SET MEM_ADD2 = ?" 
										+ " WHERE MEM_ID = ?";
							
					List<Object> list = new ArrayList<>();
					list.add(update.getMemberAdd2());
					list.add(update.getMemberId());
					
					if (jdbcUtil.update(sql, list) == 1) {
						return true;
					}
					return false;
					
				}	
	
	//주문목록,배송현황 조회 메소드
	
	public static List<Map<String, Object>> getOrderList(Object object) {
		OrderSheetDTO orderInfo = new OrderSheetDTO();
		String sql = "SELECT * FROM ORDSHEET" + " WHERE" + " MEM_ID= ?";
		List<Object> param = new ArrayList<>();
		param.add(object);
		return jdbcUtil.selectList(sql, param);
	}
	
	//전체 회원정보 조회 메소드 -관리자만 가능
	
	public static List<Map<String, Object>> getMemberAllInfo() {
		String sql = "SELECT * FROM MEMBER";
		List<Map<String,Object>> resMap = jdbcUtil.selectList(sql);
		
		
		return resMap;
	}
	
	//권한 수정 메소드
	public static boolean ChangeMemberAuthor(MemberDTO update) {
		String sql = "UPDATE MEMBER SET" + " AUTHOR = ?" 
				     + " WHERE MEM_ID = ?";
				
		List<Object> list = new ArrayList<>();
		list.add(update.getAuthor());
		list.add(update.getMemberId());
		
		if (jdbcUtil.update(sql, list) == 1) {
			return true;
		}
		return false;
	}	
}