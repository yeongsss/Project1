package purchase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import member.MemberService;
import product.ProductDTO;
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
	private MemberService memberService = MemberService.getInstance();

	// 매입 (재고수량도 조정.)

	public int purchase() {
		System.out.println("========== 매입 신청 ============");
		System.out.print("상품코드를 입력하세요");
		String productId = ScanUtil.nextLine();
		System.out.print("매입수량을 입력하세요>");
		String puroductQuantity = ScanUtil.nextLine();

		Map<String, Object> param = new HashMap<>();
		param.put("PROD_ID", productId);
		param.put("PU_QTY", puroductQuantity);

		int result = PurchaseDAO.insertPurchase(param);

		// 매입후 if 문 이후에 상품등록 성공하면, 재고를 조정(수정) 함, +연산 넣기를 추가 할것.

		if (0 < result) {
			System.out.println("상품등록에 성공했습니다.");
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductId(productId);
			productDTO.setInventoryQuantity(+Integer.parseInt(puroductQuantity));
			PurchaseDAO.updateInventoryQuantity(productDTO);
		} else {
			System.out.println("상품등록에 실패했습니다.");
		}
		return purchase();
	}

	// 매입 취소(수정)

	public int updatePurchase() {
		ProductDTO productDTO = new ProductDTO();
		System.out.println("취소할 상품의 상품코드를 입력하세요");
		productDTO.setProductId(ScanUtil.nextLine());
		System.out.println("취소할 수량을 입력하세요");
		productDTO.setInventoryQuantity(-Integer.parseInt(ScanUtil.nextLine()));

		if (PurchaseDAO.updateInventoryQuantity(productDTO)) {
			System.out.println("매입 취소 성공");
		} else {
			System.out.println("매입 취소 실패");
		}

		return purchaseManagement();

	}

	// 매입 관리 뷰 -관리자

	private int purchaseManagement() {
		System.out.println("--------------매입관리 페이지 입니다---------------");
		System.out.println("1.매입내역 조회\t2.매입 신청\t3.매입 취소\t0.이전페이지");
		System.out.println("------------------------------------------");
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();

		switch (input) {
		case 1:
			System.out.println("매입내역을 조회합니다");
			List<Map<String, Object>> list = purchaseDAO.getPurchaseAllInfo();
			for (Map<String, Object> map : list) {
				System.out.printf("%s\t%s\t%s\t%s\n", map.get("PU_NO"), map.get("PROD_ID"), map.get("PU_DATE"),
						map.get("PU_QTY"));
			}

			return purchaseManagement();
		case 2:
			System.out.println("매입신청 페이지로 이동합니다");
			return purchase();
		case 3:
			System.out.println("매입취소 페이지로 이동합니다");
			return updatePurchase();
		case 0:
			return memberService.mypageAdmin();

		}
		return purchaseManagement();
	}
}
