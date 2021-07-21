package purchase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import product.ProductDTO;
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

	// 매입 메소드 (재고 수량은 미반영)

	public static int insertPurchase(Map<String, Object> p) {
		String sql = "INSERT INTO PUCHAS VALUES (SEQ_PUCHAS.NEXTVAL, ?, SYSDATE, ?)";

		List<Object> param = new ArrayList<>();
		param.add(p.get("PROD_ID"));
		param.add(p.get("PU_QTY"));

		return jdbcUtil.update(sql, param);

	}
	
	
	
			
	//매입 내역 조회
			
			public static List<Map<String, Object>> getPurchaseAllInfo() {
				String sql = " SELECT A.pu_no,"
		                  + "           A.prod_id,"
		                  + "           B.prod_name,"
		                  + "           A.pu_date,"
		                  + "           A.pu_qty"
		                  + " FROM PUCHAS A, PROD B"
		                  + " WHERE A.PROD_ID=B.PROD_ID"
		                  + " order by 1";
				List<Map<String, Object>> resMap = jdbcUtil.selectList(sql);

				return resMap;
			
			
			
			
}
			
			
}