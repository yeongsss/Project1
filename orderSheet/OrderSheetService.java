package orderSheet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import controller.Controller;
import purchase.PurchaseDAO;
import purchase.PurchaseService;
import selectMenu.SessionUtil;

public class OrderSheetService {
	private static OrderSheetService instance;
	private OrderSheetService() {
	}
	public static OrderSheetService getInstance() {
		if (instance == null) {
			instance = new OrderSheetService();
		}
		return instance;
	}
	private OrderSheetService orderSheetService = OrderSheetService.getInstance();
	private OrderSheetDAO orderSheetDAO = OrderSheetDAO.getInstance();
			
	
	//주문내역 
	public void orderList() {
		List<Map<String,Object>> list = orderSheetDAO.getOrderSheetInfo();
		for (Map<String, Object> map : list) {
			System.out.printf("주문번호:%s\t아이디:%s\t주문일:%s\t배송지:%s %s\t결제금액%s\t결제상태%s\t배송상태%s",map.get("ORD_NO"),
					map.get("MEM_ID"),map.get("ORD_DATE").toString().split(" ")[0],map.get("ORD_ADD1"),map.get("ORD_ADD2"),
					map.get("PAY_PRICE"),map.get("PAY_STATE"),map.get(""));
		}
		
	}
	

	
	
	
	
}






