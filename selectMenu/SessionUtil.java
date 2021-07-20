package selectMenu;

import java.util.Scanner;

public class SessionUtil {
	private int orderNO;
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
	
	
}
