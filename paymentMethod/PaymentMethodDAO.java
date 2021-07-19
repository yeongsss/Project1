package paymentMethod;

import java.util.ArrayList;
import java.util.List;

import selectMenu.JDBCUtil;

public class PaymentMethodDAO {
	private static PaymentMethodDAO instance;
	
	private PaymentMethodDAO() {}
	
	public static PaymentMethodDAO getInstance() {
		if (instance == null) {
			instance = new PaymentMethodDAO();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	//결제수단코드 
	public boolean insertPaymentMethod(PaymentMethodDTO paymentcodeinfo) {
		String sql = "INSERT INTO PAYMENTMETHOD VALUES (?, ?)";
		
		List<Object> list = new ArrayList<>();
		
		list.add(paymentcodeinfo.getPaymentCode());
		list.add(paymentcodeinfo.getPaymentMethod());
		
		if (jdbc.update(sql, list) == 1) {
			return true;
		}
		return false;
	}
	
}
