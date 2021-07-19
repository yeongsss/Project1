package payment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import selectMenu.JDBCUtil;

public class PaymentDAO {

	private static PaymentDAO instance;

	private PaymentDAO() {
	}

	public static PaymentDAO getInstance() {
		if (instance == null) {
			instance = new PaymentDAO();
		}
		return instance;
	}

	private JDBCUtil jdbc = JDBCUtil.getInstance();

//   결제할 주문서 조회
	public List<Map<String, Object>> getPaymentinfo(String payment) {
		PaymentDTO paymentDTO = new PaymentDTO();
		String sql = "SELECT * FROM PAYMENT WHERE ORD_NO = ?";

		List<Object> list = new ArrayList<>();
		list.add(payment);
		return jdbc.selectList(sql, list);
	}

	public boolean updatePaymentCode(PaymentDTO update) {
		String sql = "UPDATE PAYMENT SET PAY_CODE = ? WHERE ORD_NO = ?";

		List<Object> list = new ArrayList<>();
		list.add(update.getPaymentCode());
		list.add(update.getOrderNumber());

		if (jdbc.update(sql, list) == 1) {
			return true;
		}
		return false;
	}
}