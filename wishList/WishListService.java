package wishList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.Controller;
import product.ProductDAO;
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
	
	
	public int Wishlist() {
		System.out.println("================= 위시리스트 메뉴 =====================");
		System.out.println("1.위시리스트 조회\t2.위시리스트 추가\t3.위시리스트 삭제\t0.이전페이지");
		System.out.println("==================================================");
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();

		switch (input) {
		case 1: //Join 문으로 SQL문 작성해야 상품 정보 불러오기 가능.
			System.out.println("위시리스트를 조회합니다");
			List<Map<String, Object>> list = WishListDAO.getWishListInfo();
			for (Map<String, Object> map : list) {
				System.out.printf("%s\t%s\n", map.get("PROD_ID"), map.get("WISH_DATE"));
			}
			return Wishlist();
			
			
		case 2:
			System.out.println("위시리스트 등록 메뉴로 이동 합니다");
			return addWishList();
			
		case 3:
			System.out.println("위시리스트 삭제 메뉴로 이동 합니다");
			break;
		}
		
		
		return Wishlist();
		
	}
	
	
	
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
