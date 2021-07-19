package orderList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import orderSheet.OrderSheetDTO;
import selectMenu.JDBCUtil;

public class OrderListDAO {

   private static OrderListDAO instance;
   
   private OrderListDAO( ) {}
   
   public static OrderListDAO getInstance() {
      if(instance == null) {
         instance = new OrderListDAO();
      }return instance;
   }
   
   private static JDBCUtil jdbc = JDBCUtil.getInstance();
   
   //주문목록 조회
   public List<Map<String, Object>> getorderListinfo(String orderSheet){
      OrderListDAO orderListinfo = new OrderListDAO();
      String sql = "SELECT ORD_NO, PROD_ID, ORD_QTY FROM ORDERLIST WHERE ORD_NO = ?";
      List<Object> list = new ArrayList<>();
      list.add(orderSheet);
      
      return jdbc.selectList(sql, list);
   }
   //주문수량 수정
   public boolean updateOderQuantity(OrderListDTO update) {
      String sql = "UPDATE ORDERLIST SET ORD_QTY = ? WHERE PROD_ID = ?";
      
      List<Object> list = new ArrayList<>();
      list.add(update.getOrderQuantity());
      list.add(update.getProductId());
      
      if(jdbc.update(sql, list) == 1) {
         return true;
      }
      return false;
   }
}