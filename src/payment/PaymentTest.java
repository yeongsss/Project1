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
         System.out.println("1.결제서 조회 \t2. 결제 수단 선택 \t0. 종료");
         System.out.print("선택>> ");
         
         switch (ScanUtil.nextInt()) {
         case 1:
           
        	 System.out.print("결제할 주문번호>> ");
            List<Map<String,Object>> list = paymentDAO.getPaymentinfo(ScanUtil.nextLine());
            
            
            System.out.println("주문번호\t| 결제수단코드\t | 결제일\t");
            
            for (Map<String, Object> map : list) {
               System.out.printf("%s\t%s\t\t%s\n",map.get("ORD_NO"), map.get("PAY_CODE"),map.get("PAY_DATE"));
            }
            break;

         case 2:
            PaymentDTO paymentDTO2 = new PaymentDTO();
            System.out.print("변경할 주문번호 입력>");
            paymentDTO2.setOrderNumber(ScanUtil.nextInt());
            
            System.out.println("1.계좌이체\t 2.카드결제");
            System.out.print("결제 수단을 선택해주세요>> ");
            paymentDTO2.setPaymentCode(ScanUtil.nextLine());
            
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