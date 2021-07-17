package member;

import java.util.List;
import java.util.Map;


public class MebmerTest {

	public static void main(String[] args) {
		
		//회원정보 전체 조회 (관리자용)
		List<Map<String, Object>> info = MemberDAO.getMemberAllInfo();
		for (Map<String, Object> map : info) {
			System.out.printf("%s\t%s\t%s\n", map.get("MEM_ID"), map.get("MEM_NAME"), map.get("MEM_BIRTH"));
		}
			
		}
		
		
	

}
