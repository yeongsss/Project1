package selectMenu;

import java.util.Scanner;

public class SessionUtil {
	private int orderNO;
	private int orderQty;
	private int price;
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	private SessionUtil() {
	}
	private SessionUtil(int orderNo) {
		
	}
	
	private static SessionUtil instance;
	
	public static SessionUtil getInstance() {
		if (instance == null) {
			instance = new SessionUtil();
		}
		return instance;
	}
	

	public int getOrderNO() {
		return orderNO;
	}

	public void setOrderNO(int object) {
		this.orderNO = object;
	}
	public int getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	
	
}
