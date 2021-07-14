package selectMenu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Util {
	final static int MEMBER_MENU = 1;
	final static int MANAGER_MENU = 2;
	final static int LOGIN = 1;
	final static int JOIN_MEMBERSHIP = 2;
	final static int PAYMENT = 1;
	final static int REGISTER_PRODUCT = 1;
	final static int PRODUCT_MANAGEMENT = 1;
	final static int PRODUCT_MODIFICATION = 2;
	final static int PRODUCT_DELETE = 3;
	final static int SALES_MANAGEMENT = 2;
	final static int CUSTOMER_INFORMATION_MANAGEMENT = 3;
	final static int CHECK_SALES_PERIOD = 1;
	final static int CHECK_SALES_PRODUCT = 2;
	final static int CHECK_GENDER_SALES = 3;
	final static int INVENTORY_CHECK = 1;
	final static int SALES_CHECK = 2;
	final static int PURCHASE = 3;
	final static int CHECK = 4;
	final static int CHECK_PERIOD = 5;
	final static int PERIOD_DAY = 1;
	final static int PERIOD_WEEK = 2;
	final static int PERIOD_MONTH = 3;
	final static int PERIOD_HALF_YEAR = 5;
	final static int FIRST_HALF_YEAR = 1;
	final static int SECOND_HALF = 2;
	final static int PERIOD_YEAR = 6;
	final static int CHECK_PRODUCT = 6;
	final static int EXIT_PROGRAM = 0;
	
	static Scanner scanner = new Scanner(System.in);
	
	
	public void jdbConnect() throws Exception {
		//JDBC 공통 접속 메소드 실행 (JDBC 템플릿은 spring 프레임워크에서 구현하는 기능이라 대체함)
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection(""); // 접속할 DB주소, 아이디, 비밀번호 입력
		Statement statement = connection.createStatement();
	}
	
	
	

}
