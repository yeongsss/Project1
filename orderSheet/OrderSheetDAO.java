  
package orderSheet;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.omg.CORBA.PUBLIC_MEMBER;

import controller.Controller;
import orderList.OrderListDAO;
import selectMenu.JDBCUtil;
import selectMenu.SessionUtil;

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
	public List<Map<String, Object>> getOrderSheetInfo() {
		String sql = " SELECT ORD_NO, MEM_ID, ORD_DATE, ORD_ADD1 || ' ' || ORD_ADD2 AS ADRESS,"
				   + "        NVL(PAY_PRICE,'0') AS PRICE,"
				   + "        NVL(PAY_STATE,'결제대기')AS PAY_ST ,"
				   + "        NVL(DELIVERY_STATE,'배송준비중') AS DEL_ST"
				   + " FROM ORDSHEET"
				   + " WHERE ORD_NO ="+ SessionUtil.getInstance().getOrderNO()+"";
		
		List<Object> list = new ArrayList<>();
	
		return jdbc.selectList(sql);
		
	}
	
	//주문서등록(주문번호,아이디,날짜)
	//주문번호 가져오기
	public void OrderSheetNo(){
		String sql = "INSERT INTO ORDSHEET( ORD_NO, MEM_ID, ORD_DATE) "
				   + "    VALUES(SEQ_ORD_NO.NEXTVAL, '"+ Controller.loginUser.get("MEM_ID") +"',SYSDATE)";
		jdbc.update(sql);
		
//		System.out.println(Controller.loginUser.get("MEM_ID"));
		
		String no = "    SELECT ORD_NO"
				  + "    FROM ORDSHEET"
				  + "    WHERE MEM_ID='" + Controller.loginUser.get("MEM_ID").toString() + "'"
				  + "    ORDER BY ORD_NO DESC";
		
		List<Map<String , Object>> list = jdbc.selectList(no);
		
		
//		System.out.println(Integer.parseInt(list.get(0).get("ORD_NO")+""));
		SessionUtil.getInstance().setOrderNO(Integer.parseInt(list.get(0).get("ORD_NO")+""));	
//		System.out.println(Integer.parseInt(list.get(0).get("ORD_NO").toString()));
//		System.out.println( SessionUtil.getInstance().getOrderNO());
		
	}
	
	// =>  SessionUtil.getInstance().getOrderNO()
	
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

//	결제금액 
	public void paymentPrice() {
		String sql = " SELECT SUM(B.PRICE * A.ORD_QTY) AS PRICE "
				   + " FROM ORDERLIST A, PROD B"
				   + " WHERE A.PROD_ID(+) = B.PROD_ID"
				   + " AND A.ORD_NO= "+ SessionUtil.getInstance().getOrderNO()+"";
		
		List<Map<String, Object>> list = new ArrayList<>();
		list = jdbc.selectList(sql);
		
		SessionUtil.getInstance().setPrice(Integer.parseInt(list.get(0).get("PRICE").toString()));
	}
	// SessionUtil.getInstance().getPrice()	
	
	
	
}






