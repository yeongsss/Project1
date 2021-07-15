package qnaBoard;

import java.util.List;

import util.JDBCUtil;

public class Test {
	public static void main(String[] args) {
		JDBCUtil jdbc = JDBCUtil.getInstance();
		
		List<Map<String, Object>> list = jdbc.selectList("BOARD_NO"); 
		
		
	}
}
