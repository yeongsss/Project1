package orderSheet;

import java.util.Scanner;

import orderSheet.OrderSheetDAO;
import orderSheet.OrderSheetService;
import selectMenu.Util;

public class OrderSheetService {
//	public static void main (String[] args) {
	private static OrderSheetService instance;
	private OrderSheetService() {
	}

	public static OrderSheetService getInstance() {
		if (instance == null) {
			instance = new OrderSheetService();
		}
		return instance;
	}

//	private OrderSheetDAO orderSheetDao = OrderSheetDAO.getInstance();
	public OrderSheetDTO getorderDto(String orderNumber) {
		return null;
		
	}
	public int order() {
		System.out.println("============ 주문서 ============");
		System.out.print("1. 주문번호\t2. 아이디\t3. 주문일\t4. 배송지");
		System.out.print("\t4. 배송지5. 배송지 상세주소\t6. 결제금액\t7. 결제상태");
		return payPrice;

	}
}