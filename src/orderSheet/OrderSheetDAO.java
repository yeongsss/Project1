package orderSheet;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import member.MemberDAO;
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
	public OrderSheetDTO getOrderSheetInfo(Map<String, Object> param) {
		OrderSheetDTO orderSheetInfo = new OrderSheetDTO();
		String sql = "SELECT * FROM ORDSHEET WHERE MEM_ID = ?";
		
		List<Object> list = new ArrayList<>();
		list.add(param.get("MEM_ID"));
		
		Map<String, Object> res = jdbc.selectOne(sql, list);
		orderSheetInfo.setOrderNumber(Integer.parseInt(res.get("ORD_NO").toString()));
		orderSheetInfo.setMemberId((String)res.get("MEM_ID"));
		orderSheetInfo.setOrderDate(res.get("ORD_DATE").toString().split(" ")[0]);
		orderSheetInfo.setOrderAdd1((String)res.get("ORD_ADD1"));
		orderSheetInfo.setOrderAdd2((String)res.get("ORD_ADD2"));
		orderSheetInfo.setPayPrice(Integer.parseInt(res.get("PAY_PRICE").toString()));
		orderSheetInfo.setPayState((String)res.get("PAY_STATE"));
		orderSheetInfo.setDeliveryState((String)res.get("DELIVERY_STATE"));
		
		return orderSheetInfo;
	}
	//배송지 수정
	public int updateOrderSheetinfo(Map<String, Object> param) {
		OrderSheetDTO orderSheetinfo = new OrderSheetDTO();
		String sql = "UPDATE ORDSHEET SET ORD_ADD1 = ?, ORD_ADD2 = ?"
					+ "WHERE MEM_ID = ?";
		
		List<Object> list = new ArrayList<>();
		list.add(param.get("MEM_ID"));
		
		Map<String, Object> res = jdbc.selectOne(sql, list);
		orderSheetinfo.setOrderAdd1(1, res);
		orderSheetinfo.setOrderAdd2(2, param);
		orderSheetinfo.setMemberId(3, param);
		
		return jdbc.update(sql, list);
	}
	//주문서 삭제
	public int deleteOrderSheetInfo(Map<String, Object> param){
		String sql = "DELETE FROM ORDSHEET WHERE MEM_ID = ?";
		
		List<Object> list = new ArrayList<>();
		list.add(param.get("MEM_ID"));
		
		return jdbc.update(sql, list);
		
	}
	
}
