package orderSheet;

import java.util.List;
import java.util.Map;

import selectMenu.ScanUtil;

public class OrderSheetTest {
	public static void main(String[] args) {
		
		OrderSheetDAO orderSheetDAO = OrderSheetDAO.getInstance();
		OrderSheetDTO dto = new OrderSheetDTO();
		order : while (true) {
		System.out.println("1.주문서 조회 \t 2. 배송지 변경 \t3.가격변경 \t 0.종료");
		System.out.print("선택>>");
		switch (ScanUtil.nextInt()) {
		case 1:
			System.out.print("확인할 아이디:");
			List<Map<String,Object>> list = orderSheetDAO.getOrderSheetInfo(ScanUtil.nextLine());
			
			System.out.println("============================ 주문서 ==============================");
			System.out.println("주문번호\t | 아이디\t | 주문일자\t | 주소\t | 상세주소\t | 주문가격\t | 주문현황\t | 배송현황\t");
			
			for (Map<String, Object> map : list) {
				System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s",map.get("ORD_NO"), map.get("MEM_ID"),map.get("ORD_DATE"), map.get("ORD_ADD1"),map.get("ORD_ADD2"),map.get("PAY_PRICE"), map.get("PAY_STATE"),map.get("DELIVERY_STATE"));
			}
			
			
//			Map<String, Object> param = new HashMap<String, Object>();
//			param.put("MEM_ID", "onyx01");
//			
//			System.out.println(orderSheetDAO.getOrderSheetInfo(param));
			break;
		case 2: 
			OrderSheetDTO orderSheetDTO = new OrderSheetDTO();
			System.out.print("변경할 배송지 입력>> ");
			orderSheetDTO.setOrderAdd1(ScanUtil.nextLine());
			System.out.print("상세 주소 입력>>");
			orderSheetDTO.setOrderAdd2(ScanUtil.nextLine());
			System.out.println("아이디:");
			orderSheetDTO.setMemberId(ScanUtil.nextLine());
			
			if (orderSheetDAO.updateOrderSheetinfo(orderSheetDTO)) {
				System.out.println("변경 성공");
			}else {
				System.out.println("변경 실패");
			}
			break;
			
		case 3: 
			OrderSheetDTO orderSheetDTO2 = new OrderSheetDTO();
			System.out.print("변경할 가격 입력>> ");
			orderSheetDTO2.setPayPrice(ScanUtil.nextInt());
			System.out.print("아이디>> ");
			orderSheetDTO2.setMemberId(ScanUtil.nextLine());
			
			if(orderSheetDAO.updatOrderSheet(orderSheetDTO2)) {
				System.out.println("변경 성공");
			}else {
				System.out.println("변경 실패");
			}break;
			
			
		case 0:
			System.out.println("종료");
			break order;
		}
		
		
		}
	}

}
