package orderSheet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;

import orderSheet.OrderSheetDAO;
import orderSheet.OrderSheetService;
import selectMenu.JDBCUtil;
import selectMenu.Util;

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

	private static JDBCUtil jdbc = JDBCUtil.getInstance();

	private OrderSheetDAO orderSheetDao = OrderSheetDAO.getInstance();
	public OrderSheetDTO getorderDto(String orderNumber) {
		return null;

	}

	// 주문서 조회
	public static OrderSheetDTO getOrderSheetinfo(Object object) {
		OrderSheetDTO orderSheetinfo = new OrderSheetDTO();
		String sql = "SELECT * FROM ORDSHEET WHERE MEM_ID = ?";
		System.out.print("주문번호\t| 아이디\t| 주문일\t| 배송지");
		System.out.print("\t| 배송지\t| 결제금액 |결제상태\n");
		System.out.println("======================================");
		List<Object> list = new ArrayList<>();
		list.add(object);
		Map<String, Object> ordMap = jdbc.selectOne(sql, list);
//		orderSheetinfo.setOrderNumber((int) ordMap.get("ORD_NO"));
//		orderSheetinfo.setOrderDate((int) ordMap.get("ORD_DATE"));
//		orderSheetinfo.setOrderAdd1((String) ordMap.get("ORD_ADD1"));
//		orderSheetinfo.setOrderAdd2((String) ordMap.get("ORD_ADD2"));
//		orderSheetinfo.setPayPrice((int) ordMap.get("PAY_PRICE"));
//		orderSheetinfo.setPayState((String) ordMap.get("PAY_STATE"));
		orderSheetinfo.setMemberId((String) ordMap.get("MEM_ID"));
		System.out.println("1. 기본 배송지 \t2. 신규 배송지");
		System.out.println("======================================");
		System.out.print("배송지를 선택 해주세요>> ");
		
		return orderSheetinfo;
	
		
//		int input = Util.nextInt();
		
//		switch(input) {
//		case 1:
//			return orderSheetinfo;
//		case 2:
//			System.out.print("배송지>> :");
//			String add1 = Util.nextLine();
//			System.out.print("상세 배송지>> :");
//			String add2 = Util.nextLine();
//			return orderSheetinfo; 
//		}
		
//		private int updateOrderSheet() {
			
		

	}

}