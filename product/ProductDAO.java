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

	// 상품 등록 메소드

	public static int insertProduct(Map<String, Object> p) {
		String sql = "INSERT INTO PROD VALUES (?, ?, ?, ?, ?, ?, ?)";

		List<Object> param = new ArrayList<>();
		param.add(p.get("PROD_ID"));
		param.add(p.get("PROD_NAME"));
		param.add(p.get("CL_ID"));
		param.add(p.get("CL_NAME"));
		param.add(p.get("PRICE"));
		param.add(p.get("INVNTRY_QTY"));
		param.add(p.get("PU_COST"));

		return jdbcUtil.update(sql, param);

	}

	// 상품 카테고리 조회 메소드

	public List<Map<String, Object>> selectBoardList() {
		String sql = "SELECT FROM PROD";

		return jdbcUtil.selectList(sql);
	}

	// 상품 조회 메소드

	public static ProductDTO getproductInfo(String category) {
		ProductDTO productInfo = new ProductDTO();
		String sql = "SELECT * FROM PROD" + " WHERE" + " CL_NAME= ?";
		List<Object> param = new ArrayList<>();
		param.add(category);
		Map<String, Object> resMap = jdbcUtil.selectOne(sql, param);
		productInfo.setProductId((String) resMap.get("PROD_ID")); // set 메서드 안에 (String)으로 형변환 한 이유는 setMemberId 매개변수
		productInfo.setProductName((String) resMap.get("PROD_NAME"));
		productInfo.setPrice(Integer.parseInt(String.valueOf(resMap.get("PRICE"))));

		return productInfo;

	}

	public static List<Map<String, Object>> getproductList(String category) {
		ProductDTO productInfo = new ProductDTO();
		String sql = "SELECT * FROM PROD" + " WHERE" + " CL_NAME= ? ORDER BY PROD_ID ASC";
		List<Object> param = new ArrayList<>();
		param.add(category);
		return jdbcUtil.selectList(sql, param);
	}

	// 전체 상품조회 -관리자
	public static List<Map<String, Object>> getProductAllInfo() {
		String sql = "SELECT * FROM PROD ORDER BY PROD_ID ASC";
		List<Map<String, Object>> resMap = jdbcUtil.selectList(sql);

		return resMap;
	}

	// 상품 수정 -관리자

	public static boolean productModify(ProductDTO update) {
		String sql = "UPDATE PROD SET" + " PROD_NAME = ?, PRICE = ?" + " WHERE PROD_ID = ?";

		List<Object> list = new ArrayList<>();
		list.add(update.getProductName());
		list.add(update.getPrice());
		list.add(update.getProductId());

		if (jdbcUtil.update(sql, list) == 1) {
			return true;
		}
		return false;

	}

	// 상품 삭제 -관리자

	public static Map<String, Object> productDelete(String productId) {
		String sql = "DELETE FROM PROD WHERE PROD_ID = ?";
		List<Object> param = new ArrayList<>();
		param.add(productId);
		return jdbcUtil.selectOne(sql, param);

	}

	// 전체 재고조회 -관리자
	public static List<Map<String, Object>> getStockAllInfo() {
		String sql = "SELECT * FROM PROD";
		List<Map<String, Object>> resMap = jdbcUtil.selectList(sql);

		return resMap;
	}

	// 재고 수정- 관리자
	public static boolean stockModify(ProductDTO update) {
		String sql = "UPDATE PROD SET" + " INVNTRY_QTY = ?" + " WHERE PROD_ID = ?";

		List<Object> list = new ArrayList<>();
		list.add(update.getInventoryQuantity());
		list.add(update.getProductId());

		if (jdbcUtil.update(sql, list) == 1) {
			return true;
		}
		return false;

	}

	// 매입 후 재고 조정 메소드(재고 수량을 증가)
	public static boolean plusInventoryQuantity(ProductDTO productDTO) {

		String sql = "UPDATE PROD SET" + " INVNTRY_QTY = INVNTRY_QTY +?" + " WHERE PROD_ID = ?";

		List<Object> list = new ArrayList<>();
		list.add(productDTO.getInventoryQuantity());
		list.add(productDTO.getProductId());

		if (jdbcUtil.update(sql, list) == 1) {
			return true;
		}

		return false;
	}

//매입 후 재고 조정 메소드(재고 수량을 반영함)
	public static boolean minusInventoryQuantity(ProductDTO productDTO) {

		String sql = "UPDATE PROD SET" + " INVNTRY_QTY = INVNTRY_QTY -?" + " WHERE PROD_ID = ?";

		List<Object> list = new ArrayList<>();
		list.add(productDTO.getInventoryQuantity());
		list.add(productDTO.getProductId());

		if (jdbcUtil.update(sql, list) == 1) {
			return true;
		}

		return false;
	}

	public static Map<String, Object> productCheck(String productId) {
		String sql = "SELECT COUNT(*) FROM PROD" + " WHERE PROD_ID = ?";
		List<Object> param = new ArrayList<>();
		param.add(productId);
		return jdbcUtil.selectOne(sql, param);
	}
	
	// 상품 페이지 검사
	   
	   public static Map<String, Object> productPage() {
	      String sql = "SELECT COUNT(*) FROM PROD"; 
	      return jdbcUtil.selectOne(sql);
	   }   
	
	
	
	
	

}











