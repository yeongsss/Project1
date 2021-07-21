package product;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import member.MemberService;
import orderList.OrderListService;
import orderSheet.OrderSheetDAO;
import orderSheet.OrderSheetDTO;
import selectMenu.ScanUtil;
import wishList.WishListService;

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
	private OrderListService orderListService = OrderListService.getInstance();
	private WishListService wishListService = WishListService.getInstance();
	private OrderSheetDAO orderSheetDAO = OrderSheetDAO.getInstance();

	public int listMenu() throws IOException {
		System.out.println("==========================================================");
		System.out.println();
		System.out.println("1.장바구니 등록\t 2.위시리스트 등록\t 0.이전메뉴");
		switch (ScanUtil.nextInt()) {
		case 1:
			orderSheetDAO.OrderSheetNo();
			return orderListService.insertCart();
		case 2:
			return wishListService.addWishList();
		case 0:
			return productList();
		}
		return listMenu();
	}

	// 상품목록 조회 -회원메뉴
	public int productList() throws IOException {
		System.out.println();
		System.out.println("------------------------------------- 대분류 ------------------------------------");
		System.out.println("[ 1.TV \t 2.냉장고 /t 3.건조기 /t 4.컴퓨터 /t 5.카메라 ]");
		System.out.println("[ 6.청소기 /t 7.휴대폰 /t 8.생활/주방용품 /t 9.잡화 \t 0.이전메뉴  ]");
		System.out.println("---------------------------------------------------------------------------------");

		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			List<Map<String, Object>> list = ProductDAO.getproductList("TV");
			System.out.println("[상품코드\t\t 상품명\t\t\t\t 가격]");
			for (Map<String, Object> map : list) {
				System.out.printf(" %s\t%s\t%s\n", map.get("PROD_ID"), map.get("PROD_NAME"), map.get("PRICE"));

			}
			return listMenu();
		case 2:
			list = ProductDAO.getproductList("냉장고");
			System.out.println("[상품코드\t\t 상품명\t\t\t\t 가격]");
			for (Map<String, Object> map : list) {
				System.out.printf(" %s\t%s\t%s\n", map.get("PROD_ID"), map.get("PROD_NAME"), map.get("PRICE"));

			}
			return listMenu();
		case 3:
			list = ProductDAO.getproductList("건조기");
			System.out.println("[상품코드\t\t 상품명\t\t\t\t 가격]");
			for (Map<String, Object> map : list) {
				System.out.printf("%s\t\t%s\t%s\n", map.get("PROD_ID"), map.get("PROD_NAME"), map.get("PRICE"));

			}
			return listMenu();
		case 4:
			list = ProductDAO.getproductList("컴퓨터");
			System.out.println("[상품코드\t\t 상품명\t\t\t\t 가격]");
			for (Map<String, Object> map : list) {
				System.out.printf(" %s\t%s\t%s\n", map.get("PROD_ID"), map.get("PROD_NAME"), map.get("PRICE"));

			}
			return listMenu();
		case 5:
			list = ProductDAO.getproductList("카메라");
			System.out.println("[상품코드\t\t 상품명\t\t\t\t 가격]");
			for (Map<String, Object> map : list) {
				System.out.printf(" %s\t%s\t%s\n", map.get("PROD_ID"), map.get("PROD_NAME"), map.get("PRICE"));

			}
			return listMenu();
		case 6:
			list = ProductDAO.getproductList("청소기");
			System.out.println("[상품코드\t\t 상품명\t\t\t\t 가격]");
			for (Map<String, Object> map : list) {
				System.out.printf(" %s\t%s\t%s\n", map.get("PROD_ID"), map.get("PROD_NAME"), map.get("PRICE"));

			}
			return listMenu();
		case 7:
			list = ProductDAO.getproductList("휴대폰");
			System.out.println("[상품코드\t\t 상품명\t\t\t\t 가격]");
			for (Map<String, Object> map : list) {
				System.out.printf(" %s\t%s\t%s\n", map.get("PROD_ID"), map.get("PROD_NAME"), map.get("PRICE"));

			}
			return listMenu();
		case 8:
			list = ProductDAO.getproductList("생활/주방용품");
			System.out.println("[상품코드\t\t 상품명\t\t\t\t 가격]");
			for (Map<String, Object> map : list) {
				System.out.printf(" %s\t%s\t%s\n", map.get("PROD_ID"), map.get("PROD_NAME"), map.get("PRICE"));

			}
			return listMenu();
		case 9:
			list = ProductDAO.getproductList("잡화");
			System.out.println("[상품코드\t\t 상품명\t\t\t\t 가격]");
			for (Map<String, Object> map : list) {
				System.out.printf(" %s1\t%s\t%s\n", map.get("PROD_ID"), map.get("PROD_NAME"), map.get("PRICE"));

			}
			return listMenu();
		case 0:
			return MemberService.getInstance().memberLoginMenu();

		default:
			productList();

		}
		return productList();

	}

	// 상품관리 메뉴 뷰a
	public static int productManagement() throws IOException {
		try {
			System.out.println();
			System.out.println("-----------------------------------------상품관리 ---------------------------------------");
			System.out.println("1.상품 조회\t2.상품 등록\t3.상품정보 수정\t 4.상품삭제\t5.재고 관리\t0.이전페이지");
			System.out.println(
					"------------------------------------------------------------------------------------------");
			System.out.print("번호 입력 :  ");
			int input = ScanUtil.nextInt();

			switch (input) {
			case 1:
			    Map<String, Object> productPage = ProductDAO.productPage();
	            int totalPage = Integer.parseInt(productPage.get("COUNT(*)").toString());
	            System.out.println("총 상품목록 페이지는" + (totalPage / 10) + "페이지 입니다");

	            while (true) {
	               
	               System.out.println("확인할 페이지를 입력하세요\t\t 0.뒤로가기");
	               int i = ScanUtil.nextInt();
	               if ((totalPage / 10) < i) {
	               System.out.println("범위 내 페이지를 입력하세요");
	               continue;
	                  
	               }
	               if (i == 1) {
	                  i = 1;
	               }
	               else {
	                  i = i * 10;
	               }

	               int p = 10;
	               int z = i - 1;
	               System.out.println();
	               System.out.println(" < 상품목록 >   ");
	               System.out.println("[상품코드\t 분류코드\t 분류명\t 상품명\t\t\t\t\t\t 가격 ]");
	               List<Map<String, Object>> list = ProductDAO.getProductAllInfo();

	               for (i = i - 1; i < z + p; ++i) {
	                  System.out.printf("%s", list.get(i).get("PROD_ID"));
	                  System.out.printf("\t%10s", list.get(i).get("CL_ID"));
	                  System.out.printf("\t%s", list.get(i).get("CL_NAME"));
	                  System.out.printf("\t%s", list.get(i).get("PROD_NAME"));
	                  System.out.printf("\t%s\n", list.get(i).get("PRICE"));

	               }
	               System.out.println("보고계시는 페이지는" + (i / 10) + " 페이지 입니다");
	            }

			case 2:
				System.out.println("상품 등록 메뉴로 이동합니다");
				return addProduct();
			case 3:
				System.out.println();
				System.out.println(">> 상품정보를 수정 합니다");
				System.out.println();
				ProductDTO productDTO = new ProductDTO();
				System.out.print("변경할 상품의 상품코드를 입력하세요\n상품코드: ");
				productDTO.setProductId(ScanUtil.nextLine());
				System.out.print("수정할 상품명을 입력하세요\n상품명: ");
				productDTO.setProductName(ScanUtil.nextLine());
				System.out.print("수정할 판매가격 입력하세요\n판매가격: ");
				productDTO.setPrice(ScanUtil.nextInt());

				if (ProductDAO.productModify(productDTO)) {
					System.out.println("상품정보 변경 성공");
				} else {
					System.out.println("상품정보 변경 실패");
				}

				return productManagement();
			case 4:
				System.out.println();
				System.out.println("상품을 삭제 합니다.");
				System.out.println();
				System.out.print("삭제할 상품 코드를 입력하세요\n상품코드: ");
				String productId = ScanUtil.nextLine();

				Map<String, Object> product = ProductDAO.productDelete(productId);
				Map<String, Object> productCheck = ProductDAO.productCheck(productId);
				if (product == null && productCheck.get("COUNT(*)").toString().equals("0")) {
					System.out.println("존재하지 않는 상품코드이거나 잘못된 값을 입력했습니다");

					return productManagement();
				} else {
					System.out.println("상품 삭제 성공");

					return productManagement();
				}
			case 5:
				System.out.println();
				System.out.println("재고관리 메뉴로 이동합니다");
				System.out.println();
				return stockManagement();
			case 0:
				return MemberService.getInstance().mypageAdmin();

			}
			return productManagement();
		} catch (NumberFormatException e) {
			System.out.println("메뉴 선택은 숫자로만 입력해 주세요");
			
		}catch (IndexOutOfBoundsException e) {
	         return productManagement();

	      }

		return productManagement();

	}

	// 상품 등록 -관리자 메뉴
	public static int addProduct() throws IOException {
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

	public static int stockManagement() throws IOException {
		try {
			System.out.println("------------------------------------재고관리 페이지 입니다-------------------------------");
			System.out.println("1.재고 조회\t2.재고 수정\t0.이전페이지\t9.관리자페이지");
			System.out.println(
					"-----------------------------------------------------------------------------------------");
			System.out.print("번호 입력>");
			int input = ScanUtil.nextInt();

			switch (input) {
			case 1:
				System.out.println();
				System.out.println(">> 재고목록을 조회합니다");
				System.out.println();
				System.out.println("[ 상품코드\t재고수량 \t 상품명  ]");
				List<Map<String, Object>> list = ProductDAO.getStockAllInfo();
				for (Map<String, Object> map : list) {
					System.out.printf(" %s\t\t%s\t%s\n", map.get("PROD_ID"), map.get("INVNTRY_QTY"),
							map.get("PROD_NAME"));
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

			case 9:
				return MemberService.getInstance().mypageAdmin();
			}
			return stockManagement();
		} catch (NumberFormatException e) {
			System.out.println("메뉴 선택은 숫자로만 입력해 주세요");
		}
		return stockManagement();

	}
}