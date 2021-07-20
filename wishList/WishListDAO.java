package wishList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import member.MemberDTO;
import selectMenu.JDBCUtil;

public class WishListDAO {
	// 싱글톤

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

	// 위시 리스트 조회 메소드

	  public static List<Map<String, Object>> getWishListInfo(String memberId) {
	      String sql = "SELECT A.PROD_ID,"
	      + " A.PROD_NAME,"
	      + " A.PRICE,"
	      + " B.WISH_DATE"
	      + " FROM PROD A, WISHLIST B"
	      + " WHERE A.PROD_ID=B.PROD_ID"
	      + " AND MEM_ID = ?";
	      List<Object> param = new ArrayList<>();
	      param.add(memberId);

	      return jdbcUtil.selectList(sql, param);
	   }

	// 위시 리스트 등록 메소드

	public static int insertWishList(Map<String, Object> p) {
		String sql = "INSERT INTO WISHLIST VALUES (?, ?, SYSDATE)";

		List<Object> param = new ArrayList<>();
		param.add(p.get("MEM_ID"));
		param.add(p.get("PROD_ID"));

		return jdbcUtil.update(sql, param);

	}

	// 위시 리스트 삭제

	public static Map<String, Object> wishListDelete(String productId, String memberId) {
		String sql = "DELETE FROM WISHLIST WHERE PROD_ID = ? AND MEM_ID = ?";
		List<Object> param = new ArrayList<>();
		param.add(productId);
		param.add(memberId);
		return jdbcUtil.selectOne(sql, param);

	}
}
