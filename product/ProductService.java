package product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import member.MemberService;
import selectMenu.ScanUtil;

public class ProductService {
	String category = "";
	// 싱글톤
	private static ProductService instance;

	private ProductService() {
	}

	public static ProductService getInstance() {
		if (instance == null) {
			instance = new ProductService();

		}
		return instance;
	}

	private ProductDAO productDAO = ProductDAO.getInstance();

	// 상품목록 조회 -회원메뉴
	public Map<String, Object> productList() {
		System.out.println("==========================");
		System.out.println("=====대분류를 선택해 주세요======");
		System.out.println("1.TV/t2.냉장고/t3.건조기/t4.컴퓨터/t5.카메라");
		System.out.println("6.청소기/t7.휴대폰/t8.생활/주방용품/t9.잡화");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			List<Map<String, Object>> list = ProductDAO.getproductList("TV");
			for (Map<String, Object> map : list) {
				System.out.printf("%s\t\t%s\t%s\n", map.get("PROD_ID"), map.get("PROD_NAME"), map.get("PRICE"));

			}
			break;
		case 2:
			list = ProductDAO.getproductList("냉장고");
			for (Map<String, Object> map : list) {
				System.out.printf("%s\t\t%s\t%s\n", map.get("PROD_ID"), map.get("PROD_NAME"), map.get("PRICE"));

			}
			break;
		case 3:
			list = ProductDAO.getproductList("건조기");
			for (Map<String, Object> map : list) {
				System.out.printf("%s\t\t%s\t%s\n", map.get("PROD_ID"), map.get("PROD_NAME"), map.get("PRICE"));

			}
			break;
		case 4:
			list = ProductDAO.getproductList("컴퓨터");
			for (Map<String, Object> map : list) {
				System.out.printf("%s\t\t%s\t%s\n", map.get("PROD_ID"), map.get("PROD_NAME"), map.get("PRICE"));

			}
			break;
		case 5:
			list = ProductDAO.getproductList("카메라");
			for (Map<String, Object> map : list) {
				System.out.printf("%s\t\t%s\t%s\n", map.get("PROD_ID"), map.get("PROD_NAME"), map.get("PRICE"));

			}
			break;
		case 6:
			list = ProductDAO.getproductList("청소기");
			for (Map<String, Object> map : list) {
				System.out.printf("%s\t\t%s\t%s\n", map.get("PROD_ID"), map.get("PROD_NAME"), map.get("PRICE"));

			}
			break;
		case 7:
			list = ProductDAO.getproductList("휴대폰");
			for (Map<String, Object> map : list) {
				System.out.printf("%s\t\t%s\t%s\n", map.get("PROD_ID"), map.get("PROD_NAME"), map.get("PRICE"));

			}
			break;
		case 8:
			list = ProductDAO.getproductList("생활/주방용품");
			for (Map<String, Object> map : list) {
				System.out.printf("%s\t\t%s\t%s\n", map.get("PROD_ID"), map.get("PROD_NAME"), map.get("PRICE"));

			}
			break;
		case 9:
			list = ProductDAO.getproductList("잡화");
			for (Map<String, Object> map : list) {
				System.out.printf("%s\t\t%s\t%s\n", map.get("PROD_ID"), map.get("PROD_NAME"), map.get("PRICE"));

			}
			break;

		default:
			productList();

		}
		return productList();

	}

	// 상품관리 메뉴 뷰
	public static int productManagement() {
		try {
			System.out.println("-----------------------상품관리 페이지 입니다-----------------------");
			System.out.println("1.상품 조회\t2.상품 등록\t3.상품정보 수정\t4.상품삭제\t5.재고 관리\t0.이전페이지");
			System.out.println("------------------------------------------------------------");
			System.out.print("번호 입력>");
			int input = ScanUtil.nextInt();

			switch (input) {
			case 1:
				System.out.println("상품목록을 조회합니다");
				List<Map<String, Object>> list = ProductDAO.getProductAllInfo();
				for (Map<String, Object> map : list) {
					System.out.printf("%s\t%s\t%s\t%s\t%s\n", map.get("PROD_ID"), map.get("PROD_NAME"), map.get("CL_ID"),
							map.get("CL_NAME"), map.get("PRICE"));
				}
				return productManagement();
			case 2:
				System.out.println("상품 등록 메뉴로 이동합니다");
				return addProduct();
			case 3:
				System.out.println("상품정보를 수정 합니다");
				ProductDTO productDTO = new ProductDTO();
				System.out.print("변경할 상품의 상품코드를 입력하세요");
				productDTO.setProductId(ScanUtil.nextLine());
				System.out.print("수정할 상품명을 입력하세요");
				productDTO.setProductName(ScanUtil.nextLine());
				System.out.print("수정할 상품코드를 입력하세요");
				productDTO.setClassificationCode(ScanUtil.nextLine());
				System.out.print("수정할 분류명 입력하세요");
				productDTO.setClassificationName(ScanUtil.nextLine());
				System.out.print("수정할 판매가격 입력하세요");
				productDTO.setPrice(ScanUtil.nextInt());
				System.out.print("수정할 매입가격 입력하세요");
				productDTO.setCost(ScanUtil.nextInt());
				if (ProductDAO.productModify(productDTO)) {
					System.out.println("상품정보 변경 성공");
				} else {
					System.out.println("상품정보 변경 실패");
				}

				return productManagement();
			case 4:

				System.out.println("상품을 삭제 합니다.");
				System.out.print("삭제할 상품 코드를 입력하세요");
				String productId = ScanUtil.nextLine();

				Map<String, Object> product = ProductDAO.productDelete(productId);

				if (product == null) {
					System.out.println("상품코드를 잘못 입력했거나, 존재하지 않는 상품코드 입니다");
					return productManagement();
				} else {
					System.out.println("상품 삭제 성공");

					return productManagement();
				}
			case 5:
				System.out.println("재고관리 메뉴로 이동합니다");
				return stockManagement();
			case 0:
				return MemberService.getInstance().mypageAdmin();

			}
			return productManagement();
		} catch (NumberFormatException e) {
			System.out.println("메뉴 선택은 숫자로만 입력해 주세요");
		}
		return productManagement();
	}

	// 상품 등록 -관리자 메뉴
	public static int addProduct() {
		System.out.println("=========== 상품등록 =============");
		System.out.print("상품코드>");
		String productId = ScanUtil.nextLine();
		System.out.print("상품명>");
		String productName = ScanUtil.nextLine();
		System.out.print("분류코드>");
		String classificationCode = ScanUtil.nextLine();
		System.out.print("분류명>");
		String classificationName = ScanUtil.nextLine();
		System.out.print("판매가격>");
		int price = ScanUtil.nextInt();
		int inventoryQuantity = 0; // 재고는 0으로 시작함
		System.out.print("매입가격>");
		int cost = ScanUtil.nextInt();

		Map<String, Object> param = new HashMap<>();
		param.put("PROD_ID", productId);
		param.put("PROD_NAME", productName);
		param.put("CL_ID", classificationCode);
		param.put("CL_NAME", classificationName);
		param.put("PRICE", price);
		param.put("INVNTRY_QTY", inventoryQuantity);
		param.put("PU_COST", cost);

		int result = ProductDAO.insertProduct(param);

		if (0 < result) {
			System.out.println("상품등록에 성공했습니다.");
		} else {
			System.out.println("상품등록에 실패했습니다.");
		}
		return productManagement();
	}

	// 재고관리 뷰

	public static int stockManagement() {
		try {
			System.out.println("-------재고관리 페이지 입니다-------");
			System.out.println("1.재고 조회\t2.재고 수정\t0.이전페이지");
			System.out.println("-------------------------_---");
			System.out.print("번호 입력>");
			int input = ScanUtil.nextInt();

			switch (input) {
			case 1:
				System.out.println("재고목록을 조회합니다");
				List<Map<String, Object>> list = ProductDAO.getStockAllInfo();
				for (Map<String, Object> map : list) {
					System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\n", map.get("PROD_ID"), map.get("PROD_NAME"),
							map.get("CL_ID"), map.get("CL_NAME"), map.get("INVNTRY_QTY"), map.get("PU_COST"));
				}
				return stockManagement();
			case 2:
				ProductDTO productDTO = new ProductDTO();
				System.out.print("변경할 재고의 상품코드를 입력하세요");
				productDTO.setProductId(ScanUtil.nextLine());
				System.out.print("변경할 재고의 수량을 입력하세요");
				productDTO.setInventoryQuantity(ScanUtil.nextInt());
				if (ProductDAO.stockModify(productDTO)) {
					System.out.println("재고수량 변경 성공");
				} else {
					System.out.println("재고수량 변경 실패");
				}
				return stockManagement();
			case 0:
				return productManagement();

			}
			return stockManagement();
		} catch (NumberFormatException e) {
			System.out.println("메뉴 선택은 숫자로만 입력해 주세요");
		}
		return stockManagement();

	}
}