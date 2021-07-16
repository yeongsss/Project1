package purchase;

import java.util.HashMap;
import java.util.Map;

import selectMenu.ScanUtil;

public class PurchaseService {
	
	private static PurchaseService instance;
	
	private PurchaseService() {
		
	}
	
	public static PurchaseService getInstance() {
		if (instance == null) {
			instance = new PurchaseService();
			
		}
		return instance;
	}

	private PurchaseDAO purchaseDAO = PurchaseDAO.getInstance();
	
	//매입 (재고도 조정할 것)
	
	public int purchase() {
		System.out.println("=========== 상품매입 =============");
		System.out.print("상품번호>");
		String purchaseNumber = ScanUtil.nextLine();
		System.out.print("상품코드>");
		String productId = ScanUtil.nextLine();
		String puroductDate = "SYSDATE"; //매입일은 당일, 자동으로 입력됨
		System.out.print("매입수량>");
		String puroductQuantity = ScanUtil.nextLine();
		
		Map<String, Object> param = new HashMap<>();
		param.put("PU_NO", purchaseNumber);
		param.put("PROD_ID", productId);
		param.put("PU_DATE", puroductDate);
		param.put("PU_QTY", puroductQuantity);

		int result = PurchaseDAO.insertPurchase(param);

		if (0 < result) {
			System.out.println("상품등록에 성공했습니다.");
		} else {
			System.out.println("상품등록에 실패했습니다.");
		}
		return purchase();
		
	}
}
