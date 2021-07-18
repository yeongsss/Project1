package product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import member.MemberDAO;
import member.MemberDTO;
import selectMenu.JDBCUtil;
import selectMenu.ScanUtil;

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
		String sql = "SELECT * FROM PROD" + " WHERE" + " CL_NAME= ?";
		List<Object> param = new ArrayList<>();
		param.add(category);
		return jdbcUtil.selectList(sql, param);
	}

	// 전체 상품조회 -관리자
	public static List<Map<String, Object>> getProductAllInfo() {
		String sql = "SELECT * FROM PROD";
		List<Map<String, Object>> resMap = jdbcUtil.selectList(sql);

		return resMap;
	}

	
	// 상품 수정 -관리자
	
	public static boolean productModify(ProductDTO update) {
		String sql = "UPDATE PROD SET" + " PROD_NAME = ? CL_ID = ? CL_NAME = ? PRICE = ? PU_COST =?" + " WHERE PROD_ID = ?;";

		List<Object> list = new ArrayList<>();
		list.add(update.getProductName());
		list.add(update.getClassificationCode());
		list.add(update.getProductName());
		list.add(update.getPrice());
		list.add(update.getProductId());

		if (jdbcUtil.update(sql, list) == 1) {
			return true;
		}
		return false;

	}
	
	
	
	
	// 전체 재고조회 -관리자
	public static List<Map<String, Object>> getStockAllInfo() {
		String sql = "SELECT * FROM PROD";
		List<Map<String, Object>> resMap = jdbcUtil.selectList(sql);

		return resMap;
	}

	// 재고 수정- 관리자
	public static boolean stockModify(ProductDTO update) {
		String sql = "UPDATE PROD SET" + " INVNTRY_QTY = ?" + " WHERE PROD_ID = ?;";

		List<Object> list = new ArrayList<>();
		list.add(update.getInventoryQuantity());
		list.add(update.getProductId());

		if (jdbcUtil.update(sql, list) == 1) {
			return true;
		}
		return false;

	}
	
	

}