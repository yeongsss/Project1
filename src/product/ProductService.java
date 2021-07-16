package product;

import java.util.List;
import java.util.Map;

import selectMenu.ScanUtil;

public class ProductService {
	String category = "";

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
}
