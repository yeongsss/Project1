package wishList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import selectMenu.JDBCUtil;

public class WishListDAO {
	//싱글톤
	
	private WishListDAO() {
	}
	
	private static WishListDAO instance;
	
	public static WishListDAO getInstance() {
		if (instance == null) {
			instance = new WishListDAO();
			
		}
		return instance;
	}
	
	private static JDBCUtil jdbcUtil = JDBCUtil.getInstance();
	
	
	//위시 리스트 등록 메소드
	
	public static int insertWishList(Map<String, Object> p) {
		String sql = "INSERT INTO WISHLIST VALUES (?, ?, SYSDATE)";
		
		List<Object> param = new ArrayList<>();
		param.add(p.get("MEM_ID"));
		param.add(p.get("PROD_ID"));
		
		
		
		return jdbcUtil.update(sql, param);
		
	}
	
	
	
	

}
