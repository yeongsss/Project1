package orderSheet;

import java.util.HashMap;
import java.util.Map;

import selectMenu.ScanUtil;

public class OrderTest {
	public static void main(String[] args) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("MEM_ID", "onyx01");
		OrderSheetDAO osDAO = OrderSheetDAO.getInstance();
		
		System.out.println(osDAO.deleteOrderSheetInfo(param));
		
	}

}
