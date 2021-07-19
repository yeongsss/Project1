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
      String sql = "SELECT A.ORD_NO, B.PROD_ID FROM ORDERLIST A, PROD B"
               + "WHERE A.PROD_ID=B.PROD_ID AND ORD_NO = ? ";
      List<Object> list = new ArrayList<>();
      list.add(orderSheet);
      
      return jdbc.selectList(sql, list);
   }
   //주문수량 수정
   public boolean updateOderQuantity(OrderListDTO update) {
      String sql = "UPDATE ORDERLIST SET ORD_QTY = ? WHERE ORD_NO = ?";
      
      List<Object> list = new ArrayList<>();
      list.add(update.getOrderQuantity());
      list.add(update.getOrderNumber());
      
      if(jdbc.update(sql, list) == 1) {
         return true;
      }
      return false;
   }
}