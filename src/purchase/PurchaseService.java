package purchase;

import java.util.HashMap;
import java.util.Map;

import selectMenu.Util;
import selectMenu.View;

public class PurchaseService {
	// 싱글톤 패턴으로 구현
	private static PurchaseService instance;

	private PurchaseService() {
	}

	public static PurchaseService getInstance() {
		if (instance == null) {
			instance = new PurchaseService();
		}
		return instance;
	}

	private PurchaseDAO purchaseDao = PurchaseDAO.getInstance();

	public int purchase() {
		System.out.println("===========매입============");
		System.out.print("매입번호: ");
		String purchaseNumber = Util.nextLine();
		System.out.print("상품코드: ");
		String prodId = Util.nextLine();
		System.out.print("매입단가:");
		int purchaseCost = Util.nextInt();
		System.out.print("매입일:");
		int purchaseDate = Util.nextInt();
		System.out.print("매입수량:");
		int purchaseQuantity = Util.nextInt();

		Map<String, Object> param = new HashMap<>();
		param.put("PU_NO", purchaseNumber);
		param.put("PROD_ID", prodId);
		param.put("PU_COST", purchaseCost);
		param.put("PU_DATE", purchaseDate);
		param.put("PU_QTY", purchaseQuantity);

		int result = purchaseDao.insertPurchase(param);

		if (0 < result) {
			System.out.println("매입등록 성공");
		} else {
			System.out.println("매입등록 실패");
		}
		return View.purchase;

	}
}
