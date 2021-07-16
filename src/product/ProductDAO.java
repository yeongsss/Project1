package product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import selectMenu.JDBCUtil;

public class ProductDAO {
	// 싱글톤
	private ProductDAO() {
	}

	private static ProductDAO instance;

	public static ProductDAO getInstance() {
		if (instance == null) {
			instance = new ProductDAO();
		}
		return instance;
	}

	private static JDBCUtil jdbcUtil = JDBCUtil.getInstance();

	// 상품 카테고리 조회 메소드

	public List<Map<String, Object>> selectBoardList() {
		String sql = "SELECT FROM PROD";

		return jdbcUtil.selectList(sql);
	}

	// 상품 조회 메소드
	public static ProductDTO getProductList2(Object object) {
		ProductDTO productInfo = new ProductDTO();
		String sql = "SELECT FROM PROD" + "where" + "CL_NAME= ?";
		List<Object> param = new ArrayList<>();
		param.add(object);
		Map<String, Object> resMap = jdbcUtil.selectOne(sql, param);
		productInfo.setProductName((String) resMap.get("PROD_NAME"));
		productInfo.setProductId((String) resMap.get("PROD_ID"));
		productInfo.setPrice((int) resMap.get("PRICE"));
		productInfo.setInventoryQuantity((int) resMap.get("INVNTRY_QTY"));
		return productInfo;

	}

	public static Map<String, Object> getProductList(List<Object> category) {
		ProductDTO productList = new ProductDTO();
		String sql = "SELECT * FROM PROD" + " WHERE" + " CL_NAME= ?";
		List<Object> param = new ArrayList<>();
		param.add(category);
		Map<String, Object> resMap = (Map<String, Object>) jdbcUtil.selectList(sql, category);

		return jdbcUtil.selectOne(sql, param);
	}
}
