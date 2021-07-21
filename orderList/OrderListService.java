package orderList;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import controller.Controller;
import member.MemberService;
import orderSheet.OrderSheetDAO;
import orderSheet.OrderSheetDTO;
import payment.PaymentDAO;
import payment.PaymentService;
import payment.PaymentTest;
import product.ProductService;
import selectMenu.ScanUtil;
import selectMenu.SessionUtil;

public class OrderListService {

	private static OrderListService instance;

	private OrderListService() {
	}

	public static OrderListService getInstance() {
		if (instance == null) {
			instance = new OrderListService();

		}
		return instance;
	}

	private OrderListDAO orderListDAO = OrderListDAO.getInstance();
	private PaymentService paymentService = PaymentService.getInstance();
	private OrderSheetDAO orderSheetDAO = OrderSheetDAO.getInstance();

	public int insertCart() throws IOException {

		System.out.println(SessionUtil.getInstance().getOrderNO());
		OrderListDTO orderListDTO = new OrderListDTO();
		orderListDTO.setOrderNumber(SessionUtil.getInstance().getOrderNO());
		System.out.print("추가할 상품코드: ");
		String prodId = ScanUtil.nextLine();
		System.out.print("수량: ");
		orderListDTO.setOrderQuantity(ScanUtil.nextInt());

		orderListDTO.setProductId(prodId);
		// 장바구니에 상품 코드가 있는지 확인
		boolean result = false;

		List<Map<String, Object>> orderList = OrderListDAO.getInstance().selectCart();
		for (Map<String, Object> entry : orderList) {
			if ((entry.get("ORD_NO").toString()).equals(prodId)) {
				result = orderListDAO.plusQuantity(orderListDTO);
			}
		}
		// 있으면 update
		// 없으면 insert
		if (!result) {
			result = orderListDAO.insertOrderList(orderListDTO);
		}
		if (result) {
			System.out.println("장바구니 등록 성공");
		} else {
			System.out.println("장바구니 등록 실패");
		}
		return ProductService.getInstance().productList();
	}
	

	public int orderList() throws IOException {
		System.out.println();
		System.out.println("================ 장바구니 ================");
		System.out.println("1.장바구니 조회\t 2.장바구니 수정\t 3.구매하기 \t 0.종료");
		System.out.print("선택:  ");
		switch (ScanUtil.nextInt()) {
		case 1:
			System.out.println(SessionUtil.getInstance().getOrderNO());
			List<Map<String, Object>> list = orderListDAO.selectCart();

			System.out.println("========== 장바구니 목록 ==========");
			System.out.println("[ 주문번호\t 상품코드\t 상품명\t 주문수량 ] ");

			for (Map<String, Object> map : list) {
				System.out.printf("%s\t%s\t\t%s\t%s\n", map.get("ORD_NO"), map.get("PROD_ID"), map.get("PROD_NAME"),
						map.get("ORD_QTY"));
			}
			return orderList();
		case 2:
			OrderListDTO orderListDTO2 = new OrderListDTO();
			System.out.print("변경할 주문수량: ");
			orderListDTO2.setOrderQuantity(ScanUtil.nextInt());
			System.out.println("상품코드:  ");
			
			orderListDTO2.setProductId(ScanUtil.nextLine());
			orderListDTO2.setOrderNumber(SessionUtil.getInstance().getOrderNO());
			orderListDAO.selectQty();
			if (orderListDAO.updateOderQuantity(orderListDTO2)) {
				System.out.println("변경 성공");
			} else {
				System.out.println("변경 실패");
			}
			return orderList();

		case 3:
			orderListDAO.selectQty();
			orderSheetDAO.paymentPrice();
//			System.out.println(SessionUtil.getInstance().getOrderQty());
//			System.out.println(SessionUtil.getInstance().getPrice());
			List<Map<String, Object>> cartlist = orderSheetDAO.getOrderSheetInfo();
			System.out.println("주문번호\t| 아이디\t| 주문일\t| 배송지\t| 결제금액\t| 결제상태\t| 배송상태");
			for (Map<String, Object> map : cartlist) {
				System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\n", map.get("ORD_NO"), map.get("MEM_ID"),
						map.get("ORD_DATE").toString().split(" ")[0], map.get("ADRESS"), SessionUtil.getInstance().getPrice(),
						map.get("PAY_ST"), map.get("DEL_ST"));
			}
			
			OrderSheetDTO orderSheetDTO = new OrderSheetDTO();
			System.out.println("배송지를 입력하세요.");
			System.out.print("기본배송지: ");
			String add1 = ScanUtil.nextLine();
			orderSheetDTO.setOrderAdd1(add1);
			System.out.println("상세주소: ");
			String add2 = ScanUtil.nextLine();
			orderSheetDTO.setOrderAdd2(add2);
//			orderSheetDTO.setPayPrice(SessionUtil.getInstance().getPrice());
			orderSheetDTO.setPayState("결제 완료");
			
			
			
			if (PaymentDAO.getInstance().payment(orderSheetDTO)) {
				System.out.println("구매 성공");
			} else {
				System.out.println("구매 실패");
			}
			return MemberService.getInstance().memberLoginMenu();

		case 0:
			System.out.println("종료");
			return MemberService.getInstance().memberLoginMenu();
		}

		return MemberService.getInstance().memberLoginMenu();
	}
}