package purchase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import selectMenu.JDBCUtil;

public class PurchaseDAO {

	// 싱글톤

	private PurchaseDAO() {

	}

	private static PurchaseDAO instance;

	public static PurchaseDAO getInstance() {
		if (instance == null) {
			instance = new PurchaseDAO();

		}
		return instance;
	}

	private static JDBCUtil jdbcUtil = JDBCUtil.getInstance();

	// 매입 메소드 (재고 수량도 반영됨)

	public static int insertPurchase(Map<String, Object> p) {
		String sql = "INSERT INTO PUCHAS VALUES (?, ?, ?, ?,)";

		List<Object> param = new ArrayList<>();
		param.add(p.get("PU_NO"));
		param.add(p.get("PROD_ID"));
		param.add(p.get("PU_DATE"));
		param.add(p.get("PU_QTY"));

		return jdbcUtil.update(sql, param);

	}
}
