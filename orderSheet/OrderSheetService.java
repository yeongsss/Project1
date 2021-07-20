package orderSheet;

import purchase.PurchaseDAO;
import purchase.PurchaseService;

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
	
	//주문번호 가져오기
	public void getOrderNo() {
		
	}
	
	
//	public int insertCart() {
//		System.out.println();
//		System.out.println("----------------- 장바구니 등록 ------------------");
//		System.out.print("");
//		
//	}
	
	
	
	
	
}







