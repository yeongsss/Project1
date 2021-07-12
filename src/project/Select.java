package project;

import java.util.Scanner;

public interface Select {
	Scanner SCANNER = new Scanner(System.in);
	int MEMBER_MENU = 1;
	int MANAGER_MENU = 2;
	int LOGIN = 1;
	int JOIN_MEMBERSHIP = 2;
	int PAYMENT = 3;
	int PRODUCT_MANAGEMENT = 1;
	int SALES_MANAGEMENT = 2;
	int CUSTOMER_INFORMATION_MANAGEMENT = 3;
	int INVENTORY_CHECK = 1;
	int SALES_CHECK = 2;
	int PURCHASE = 3;
	int CHECK = 4;
	int CHECK_PERIOD = 5;
	int YEAR_SEARCH = 0;
	int PERIOD_DAY = 1;
	int PERIOD_WEEK = 2;
	int PERIOD_MONTH = 3;
	int PERIOD_HALF_YEAR = 5;
	int FIRST_HALF_YEAR = 1;
	int SECOND_HALF = 2;
	int PERIOD_YEAR = 6 ;
	int CHECK_PRODUCT = 6;
	int EXIT_PROGRAM = 0;
	
	
	

}
