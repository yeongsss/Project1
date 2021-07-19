package orderList;


import java.util.List;
import java.util.Map;

import selectMenu.ScanUtil;

public class OrderListTest {

   public static void main(String[] args) {
      OrderListDAO orderListDAO = OrderListDAO.getInstance();
      OrderListDTO orderListDTO = new OrderListDTO();
      List: while(true) {
         System.out.println("1.주문목록조회\t 2.주문수량 수정\t 0.종료");
         System.out.print("선택>> ");
         switch (ScanUtil.nextInt()) {
         case 1:
            System.out.print("조회할 주문번호>> ");
            List<Map<String,Object>> list = orderListDAO.getorderListinfo(ScanUtil.nextLine());
            
            System.out.println("==========주문목록==========");
            System.out.println("주문번호\t  상품코드\t  주문수량 ");
            for (Map<String, Object> map : list) {
               System.out.printf("%s\t%s\t\t%s\n", map.get("ORD_NO"), map.get("PROD_ID"), map.get("ORD_QTY"));
            }
            break;
         case 2:
            OrderListDTO orderListDTO2 = new OrderListDTO();
            System.out.println("상품코드>> ");
            orderListDTO2.setProductId(ScanUtil.nextLine());
            System.out.print("변경할 주문수량>> ");
            orderListDTO2.setOrderQuantity(ScanUtil.nextInt());
            
            if (orderListDAO.updateOderQuantity(orderListDTO2)) {
               System.out.println("변경 성공");
            } else {
               System.out.println("변경 실패");
            }
            break;
         
         case 0:
            System.out.println("종료");
            break List;
         }
      }
   }

}