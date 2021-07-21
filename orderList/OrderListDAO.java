package orderList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import orderSheet.OrderSheetDTO;
import product.ProductDTO;
import selectMenu.JDBCUtil;
import selectMenu.SessionUtil;

public class OrderListDAO {

   private static OrderListDAO instance;
   
   private OrderListDAO( ) {}
   
   public static OrderListDAO getInstance() {
      if(instance == null) {
         instance = new OrderListDAO();
      }return instance;
   }
   
   private static JDBCUtil jdbc = JDBCUtil.getInstance();
   
   //주문목록 등록
   public boolean insertOrderList(OrderListDTO data) {
	String sql = "INSERT INTO ORDERLIST"
			   + "    VALUES(?,?,?,ORDLIST_NO.NEXTVAL)";	//주문번호, 상품코드, 수량, 목록번호
	List<Object> list = new ArrayList<Object>();
	list.add(data.getOrderNumber());
	list.add(data.getProductId());
	list.add(data.getOrderQuantity());
	
	if (jdbc.update(sql,list)==1) {
		return true;
	} return false;
	
}
   
   
   
   
   //주문목록 조회
   public List<Map<String, Object>> getorderListinfo(int orderNo){
      OrderListDAO orderListinfo = new OrderListDAO();
      String sql = "SELECT ORD_NO, PROD_ID, ORD_QTY FROM ORDERLIST WHERE ORD_NO = ?";
      List<Object> list = new ArrayList<>();
      list.add(orderNo);
      
      return jdbc.selectList(sql, list);
   }
   //주문수량 수정
   public boolean updateOderQuantity(OrderListDTO update) {
      String sql = " UPDATE ORDERLIST "
      	     	 + "    SET ORD_QTY = ?" //변경할 수량
      	     	 + " WHERE PROD_ID = ? " //변결할 상품코드
      	     	 + " AND ORD_NO = ? "; // SessionUtil.getInstance().getOrderNO()
      
      List<Object> list = new ArrayList<>();
      list.add(update.getOrderQuantity());
      list.add(update.getProductId());
      list.add(update.getOrderNumber());
      
      if(jdbc.update(sql,list) == 1) {
         return true;
      }
      return false;
   }
   // 장바구니 수량증가
   public boolean plusQuantity(OrderListDTO data) {
	String sql = "    UPDATE ORDERLIST"
			   + "           SET ORD_QTY= ORD_QTY + 1"
			   + "     WHERE PROD_ID = ? "
			   + "         AND ORD_NO = ? ";
	List<Object> list = new ArrayList<Object>();
	list.add(data.getProductId());
	list.add(data.getOrderNumber());
	
	if (jdbc.update(sql, list)>0) {
		return true;
	}
	return false;
}
   
   
   
   
   
   //주문 삭제
   public boolean deleteOrderList(int orderSheet) {
      String sql = "DELETE FROM ORDERLIST "
               + "WHERE ORD_NO = ?";
      List<Object> list = new ArrayList<>();
      list.add(orderSheet);
      
      int result = jdbc.update(sql, list);
      
      if (result > 0) {
      return true;
   }
      return false;
   }
//   ----------------------------------------------------------------------------------------
   // 장바구니 목록조회
   public List<Map<String, Object>> selectCart(){
	   String sql = "SELECT A.ORD_NO,"
	   			  + "          A.PROD_ID,"
	   			  + "          B.PROD_NAME,"
	   			  + "          A.ORD_QTY"
	   			  + " FROM ORDERLIST A , PROD B "
	   			  + " WHERE A.PROD_ID = B.PROD_ID "
	   			  + "   AND A.ORD_NO = "+ SessionUtil.getInstance().getOrderNO()+ "";
	   return jdbc.selectList(sql);
	   
   }
   // 주문수량 가져오기
   public void selectQty(){
	   String sql = " SELECT ORD_QTY "
	   		      + " FROM ORDERLIST "
	   		      + " WHERE ORD_NO = "+ SessionUtil.getInstance().getOrderNO();
	   List<Map<String, Object>> list = new ArrayList<>();
	   list=jdbc.selectList(sql);
	   SessionUtil.getInstance().setOrderQty(Integer.parseInt(list.get(0).get("ORD_QTY")+""));
	   
	   // SessionUtil.getInstance().getOrderQty()
			   
	   
   }
   
   
   
}
