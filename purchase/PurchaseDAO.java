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
		String sql = "INSERT INTO PUCHAS VALUES (SEQ_PU_NO.NEXTVAL, ?, SYSDATE, ?,)";

		List<Object> param = new ArrayList<>();
		param.add(p.get("PROD_ID"));
		param.add(p.get("PU_QTY"));

		return jdbcUtil.update(sql, param);

	}
	
	
	//매입 후 재고 조정 메소드(재고 수량을 반영함)
			public static boolean updateInventoryQuantity(ProductDTO productDTO) {
				
				String sql = "UPDATE PROD SET" + "PROD_ID = ?"
							+ " WHERE INVNTRY_QTY = ?;";
				
				List<Object> list = new ArrayList<>();
				list.add(productDTO.getProductId());
				list.add(productDTO.getInventoryQuantity());
				
				if (jdbcUtil.update(sql, list) == 1) {
					return true;
				}
						
				return false;
			}
			
	//매입 내역 조회
			
			public static List<Map<String, Object>> getPurchaseAllInfo() {
				String sql = "SELECT * FROM PUCHAS";
				List<Map<String, Object>> resMap = jdbcUtil.selectList(sql);

				return resMap;
			
			
			
			
}
			
			
}
