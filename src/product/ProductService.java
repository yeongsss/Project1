package product;

import java.util.List;
import java.util.Map;

import selectMenu.ScanUtil;

public class ProductService {
	
	private static ProductService instance;
	private ProductService() {}
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
		System.out.println("6.청소기/t7.휴대폰/t8.생활/t주방용품/t9.잡화");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1:  break;
		case 2: break;
		case 3: break;
		case 4: 
		Object category = "컴퓨터";
		productDAO.getProductList((List<Object>) category);
		break;
		case 5: break;
		case 6: break;
		case 7: break;
		case 8: break;
		case 9: break;
		
		default: productList();
			
		}
		return productList();
		
		
		
		
		
	}

}
