package purchase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import selectMenu.Util;


public class PurchaseDAO {
	// 싱글톤 패턴
	private static PurchaseDAO instance;

	// 기본생성자 private로, 외부에서 생성을 막음
	private PurchaseDAO() {
	}

	// instance가 null 이 아니면 새 객체로 생성, 그 외면 instance를 리턴하여, 1개의 객체만을 보장
	public static PurchaseDAO getInstance() {
		if (instance == null) {
			instance = new PurchaseDAO();
		}
		return instance;
	}

	public static int insertPurchase(Map<String, Object> param) {
		
		
		return 0;
	}

	
	

	}


