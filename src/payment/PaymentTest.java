package payment;

import java.util.List;
import java.util.Map;

import orderList.OrderListDAO;
import selectMenu.ScanUtil;

public class PaymentTest {
   public static void main(String[] args) {
      
      PaymentDAO paymentDAO = PaymentDAO.getInstance();
      PaymentDTO paymentDTO = new PaymentDTO();
      
      Payment: while (true) {
         System.out.println("1.결제할 주문서 조회 \t2. 결제 수단 선택 \t3. 종료");
         System.out.print("선택>> ");
         
         switch (ScanUtil.nextInt()) {
         case 1:
            System.out.print("결제할 주문번호>> ");
            List<Map<String,Object>> list = paymentDAO.getPaymentinfo(ScanUtil.nextLine());
            
            System.out.println("주문번호\t | 아이디\t | 주문일자\t | 주소\t | 상세주소\t | 주문가격\t | 주문현황\t | 배송현황\t");
            
            for (Map<String, Object> map : list) {
               System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s",map.get("ORD_NO"), map.get("MEM_ID"),map.get("ORD_DATE"), map.get("ORD_ADD1"),map.get("ORD_ADD2"),map.get("PAY_PRICE"), map.get("PAY_STATE"),map.get("DELIVERY_STATE"));
            }
            break;

         case 2:
            PaymentDTO paymentDTO2 = new PaymentDTO();
            System.out.print("결제 수단을 선택해주세요>> ");
            paymentDTO.setPaymentCode(ScanUtil.nextLine());
            
            if (paymentDAO.updatePaymentCode(paymentDTO2)) {
               System.out.println("선택 완료");
            } else {
               System.out.println("선택 실패");
            }
            break;
         }
      }
   }
}