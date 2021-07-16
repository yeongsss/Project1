package orderSheet;


import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import member.MemberDAO;
import selectMenu.JDBCUtil;

public class OrderSheetDAO {
	
	private static OrderSheetDAO instance;

	private OrderSheetDAO() {}

	public static OrderSheetDAO getInstance() {
		if (instance == null) {
			instance = new OrderSheetDAO();
		}
		return instance;
	}
	
	private static JDBCUtil jdbc = JDBCUtil.getInstance();

	public List<Map<String, Object>> selecteOrderSheetDAO(Map<String, Object> dto) {
		String sql = "SELECT ORD_NO, COL, ORD_ADD1, ORD_ADD2, PAY_PRICE, PAY_STATE, MEM_ID"
					+ "FROM ORDSHEET"
					+ "WHERE MEM_ID = ? ";
		
		List<Object> list = new ArrayList<>();
//		list.add(param.get("MEM_ID"));
		return jdbc.selectList(sql, list);
		
	}
	
	public int intsertOrderSheet(Map<String, Object> dto) {
		String sql = "INSERT INTO ORDSHEET(ORD_NO, ORD_DATE, ORD_ADD1, ORD_ADD2, PAY_PRICE, PAY_STATE, MEM_ID)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		List<Object> list = new ArrayList<>();
		list.add(dto.get("ORD_NO"));
		list.add(dto.get("ORD_DATE"));
		list.add(dto.get("ORD_ADD1"));
		list.add(dto.get("ORD_ADD2"));
		list.add(dto.get("PAY_PRICE"));
		list.add(dto.get("PAY_STATE"));
		list.add(dto.get("MEM_ID"));
		return jdbc.update(sql, list);
	}
	public int updateOrderSheet(Map<String, Object> dto) {
		String sql = "UPDATE ORDSHEET SET ORD_ADD1 = ?, ORD_ADD2 = ?"
					+ "WHERE MEM_ID = ?";
		
		List<Object> list = new ArrayList<>();
		list.add(dto.get("ORD_ADD1"));
		list.add(dto.get("ORD_ADD2"));
		list.add(dto.get("MEM_ID"));
		
		return jdbc.update(sql, list);
	}
	public int deleteOrderSheet(Map<String, Object> dto){
		String sql = "DELETE FROM ORDSHEET WHERE MEM_ID = ?";
		
		List<Object> list = new ArrayList<>();
		list.add(dto.get("MEM_ID"));
		return jdbc.update(sql, list);
		
	}
}
