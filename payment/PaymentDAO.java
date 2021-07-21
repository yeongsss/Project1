package payment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import orderSheet.OrderSheetDTO;
import paymentMethod.PaymentMethodDTO;
import selectMenu.JDBCUtil;
import selectMenu.SessionUtil;

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
		String sql = "SELECT B.PAY_METH, A.ORD_NO, A.PAY_DATE"
				+ " FROM PAYMENT A, PAYMENTMETHOD B"
				+ " WHERE A.PAY_CODE=B.PAY_CODE"
				+ " AND A.ORD_NO = ?";

		List<Object> list = new ArrayList<>();
		list.add(payment);
		return jdbc.selectList(sql, list);
	}
//	변경할 결제 수단
	public boolean updatePaymentCode(PaymentDTO update) {
		String sql = "UPDATE PAYMENT "
				+ "SET PAY_CODE = ? "
				+ "WHERE ORD_NO = ?";

		List<Object> list = new ArrayList<>();
		list.add(update.getPaymentCode());
		list.add(update.getOrderNumber());

		if (jdbc.update(sql, list) == 1) {
			return true;
		}
		return false;
	}

// 결제
	public boolean payment(OrderSheetDTO ord) {
		String sql = " UPDATE ORDSHEET "
				   + "       SET ORD_ADD1 = ? , ORD_ADD2 =  ? , PAY_PRICE = "+ SessionUtil.getInstance().getPrice() +" ,"
				   + " PAY_STATE = ?, DELIVERY_STATE= '배송 준비중' "
				   + "  WHERE ORD_NO="+ SessionUtil.getInstance().getOrderNO() +"" ;
		List<Object>list = new ArrayList<Object>();
		list.add(ord.getOrderAdd1());
		list.add(ord.getOrderAdd2());
//		list.add(ord.getPayPrice());
		list.add(ord.getPayState());
		
		if (jdbc.update(sql, list)>0) {
			return true;
		}
		return false;
	}
	
}