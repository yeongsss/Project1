package product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Parameter;

import selectMenu.Util;

public class ProductService {
	String category ="";
	
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
			System.out.println("6.청소기/t7.휴대폰/t8.생활/주방용품/t9.잡화");
			int input = Util.nextInt();
			switch (input) {
			case 1: System.out.println(ProductDAO.getproductList("TV"));break;
			case 2: System.out.println(ProductDAO.getproductList("냉장고"));break;
			case 3: System.out.println(ProductDAO.getproductList("건조기"));break;
			case 4: System.out.println(ProductDAO.getproductList("컴퓨터"));break;
			case 5: System.out.println(ProductDAO.getproductList("카메라"));break;
			case 6: System.out.println(ProductDAO.getproductList("청소기"));break;
			case 7: System.out.println(ProductDAO.getproductList("휴대폰"));break;
			case 8: System.out.println(ProductDAO.getproductList("생활/주방용품"));break;
			case 9: System.out.println(ProductDAO.getproductList("잡화"));break;
			
			default: productList();
				
			}
			return productList();	
		
		
	}

}
