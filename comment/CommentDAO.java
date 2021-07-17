package comment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import selectMenu.JDBCUtil;

public class CommentDAO {
	private CommentDAO() {}
	
	private static CommentDAO instance;
	public static CommentDAO getInstance() {
		if (instance ==null) {
			instance = new CommentDAO();
		}
		return instance;
	}
	
	private JDBCUtil jdbc =  JDBCUtil.getInstance();
	
	public boolean insertComment(CommentDTO comment ) {
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
		CommentDTO commentDTO = new CommentDTO();
		String sql = "SELECT * FROM CMNTS";
		List<Map<String , Object>> list = jdbc.selectList(sql);
		return list;
	}
	
	
}
