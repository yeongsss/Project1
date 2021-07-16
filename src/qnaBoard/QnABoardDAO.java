package qnaBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import selectMenu.JDBCUtil;

public class QnABoardDAO {
	private QnABoardDAO() {
	}

	private static QnABoardDAO instance;

	public static QnABoardDAO getInstance() {
		if (instance == null) {
			instance = new QnABoardDAO();
		}
		return instance;
	}
		private JDBCUtil jdbc = JDBCUtil.getInstance();
		
		public boolean updateQnABoard(QnABoardDTO update) {
			String sql = "UPDATE QNA_BOARD "
									+ "SET Q_CONTENT =?"
									+ "WHERE BOARD_NO = ? ";
			List<Object> list =new ArrayList<>();
			list.add(update.getQnaContent());
			list.add(update.getBoardNo());
			
			if (jdbc.update(sql, list)==1) {
				return true;
			} return false;
				
			
		}
		
		
		public boolean insertQnABoard(QnABoardDTO boardInfo) {
			String sql =  "INSERT INTO "
									+ "			QNA_BOARD"
									+ " 	 VALUES (SEQ_BOARD_NO.NEXTVAL, ?, SYSDATE, ?, ?)";
			
			List<Object> list = new ArrayList<>();
			list.add(boardInfo.getMemberId());
			list.add(boardInfo.getQnaTitle());
			list.add(boardInfo.getQnaContent());
			
			if (jdbc.update(sql, list) == 1) {
				return true;
			}
			return false;
		}
		
		public List<Map<String, Object>> getQnaBoard(String memberId) {
			String sql = "SELECT * FROM QNA_BOARD"
								+ "        WHERE MEM_ID= ? ";
			List<Object> param = new ArrayList<>();
			param.add(memberId);
			return jdbc.selectList(sql, param);
			
			 
		}
	
		public List<Map<String, Object>> allQnaBoard() {
			QnABoardDTO boardDTO = new QnABoardDTO();
			String sql = "SELECT * FROM QNA_BOARD";
			
			List<Map<String, Object>>  list = jdbc.selectList(sql);
			
			return list;
			
			
		}
		

}

