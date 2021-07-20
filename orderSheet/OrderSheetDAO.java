package orderSheet;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.omg.CORBA.PUBLIC_MEMBER;

import selectMenu.JDBCUtil;

public class OrderSheetDAO {
	
	private static OrderSheetDAO instance;
	
	
	private OrderSheetDAO() {}
	
	public static OrderSheetDAO getInstance() {
		if (instance == null) {
			instance = new OrderSheetDAO();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	
	// 로그인된 아이디의 주문서 조회
	public List<Map<String, Object>> getOrderSheetInfo(String member) {
		OrderSheetDTO orderSheetInfo = new OrderSheetDTO();
		String sql = "SELECT * FROM ORDSHEET WHERE MEM_ID = ?";
		
		List<Object> list = new ArrayList<>();
		list.add(member);
		return jdbc.selectList(sql, list);
		
	}
	
	//주문서등록
	public boolean insertOrderSheet(Object data){
		String sql = "INSERT INTO ORDSHEET"
				   + "    VALUES(SEQ_ORD_NO.NEXTVAL,'hyunsoo88',SYSDATE, '대전','대덕인재개발원',50000,'5',NULL);";
		                  
	}
	
	
	
	//배송지 수정
	public boolean updateOrderSheetinfo(OrderSheetDTO update) {
		String sql = "UPDATE ORDSHEET SET ORD_ADD1 = ?, ORD_ADD2 = ?"
					+ "WHERE MEM_ID = ?";
		
		List<Object> list = new ArrayList<>();
		list.add(update.getOrderAdd1());
		list.add(update.getOrderAdd2());
		list.add(update.getMemberId());
		
		if (jdbc.update(sql, list) == 1) {
			return true;
		} return false;
	}
	
	//가격변경
	public boolean updatOrderSheet (OrderSheetDTO update) {
	String sql = "UPDATE ORDSHEET SET PAY_PRICE = ?"
				+ "WHERE MEM_ID = ?";
	
		List<Object> list = new ArrayList<>();
		list.add(update.getPayPrice());
		list.add(update.getMemberId());
		
		if (jdbc.update(sql, list) == 1) {
			return true;
		}
		return false;
	}
	
	//주문서 삭제
	public int deleteOrderSheetInfo(Map<String, Object> param){
		String sql = "DELETE FROM ORDSHEET WHERE MEM_ID = ?";
		
		List<Object> list = new ArrayList<>();
		list.add(param.get("MEM_ID"));
		
		return jdbc.update(sql, list);
		
	}
	
}
