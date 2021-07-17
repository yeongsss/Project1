package comment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import selectMenu.JDBCUtil;

public class commentDAO {
	private commentDAO() {}
	
	private static commentDAO instance;
	public static commentDAO getInstance() {
		if (instance ==null) {
			instance = new commentDAO();
		}
		return instance;
	}
	
	private JDBCUtil jdbc =  JDBCUtil.getInstance();
	
	public boolean insertComment(commentDTO comment ) {
		String sql = "INSERT INTO CMNTS"
							+ "    VALUES (? ,?,SYSDATE,?)";
		
		List<Object> list = new ArrayList<>();
		list.add(comment.getBoardNo());
		list.add(comment.getMemberId());
		list.add(comment.getCommentContent());
		
		if (jdbc.update(sql, list)==1) {
			return true;
		}
		return false;
	}
	
	public List<Map<String , Object>> allComment() {
		commentDTO commentDTO = new commentDTO();
		String sql = "SELECT * FROM CMNTS";
		List<Map<String , Object>> list = jdbc.selectList(sql);
		return list;
	}
	
	
}
