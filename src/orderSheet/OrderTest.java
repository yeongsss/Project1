package orderSheet;

import selectMenu.Util;

public class OrderTest {

		
	public static void main(String[] args) {
		System.out.println("아이디 입력");

		System.out.println(OrderSheetService.getOrderSheetinfo(Util.nextLine()));
	}

}
