package wishList;

import java.util.HashMap;
import java.util.Map;

import controller.Controller;
import selectMenu.JDBCUtil;
import selectMenu.ScanUtil;

public class WishListService {

	private static WishListService instance;

	private WishListService() {
	}

	public static WishListService getInstance() {
		if (instance == null) {
			instance = new WishListService();
		}
		return instance;
	}

	private static JDBCUtil jdbcUtil = JDBCUtil.getInstance();
	private WishListDAO wishListDAO = WishListDAO.getInstance();
	
	
	public int addWishList() {
		System.out.println("=========== 위시리스트 등록 =============");
		//로그인한 멤버의 아이디로 자동 등록
		String memberId = (String) Controller.loginUser.get("MEM_ID");
		System.out.print("상품코드를 입력하세요");
		String productId = ScanUtil.nextLine();
		//위시리스트 추가일로 자동 날짜 등록
		

		Map<String, Object> param = new HashMap<>();
		param.put("MEM_ID", memberId);
		param.put("PROD_ID", productId);

		int result = WishListDAO.insertWishList(param);

		if (0 < result) {
			System.out.println("위시리스트 등록에 성공했습니다.");
		} else {
			System.out.println("위시리스트 등록에 실패했습니다.");
		}

		return addWishList();
	}

}
