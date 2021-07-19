package qnaBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import comment.CommentDTO;
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
		
		public List<Map<String , Object>> getBoard() {
			QnABoardDTO qnABoardDTO = new QnABoardDTO();
			CommentDTO commentDTO = new CommentDTO();
			String sql = "    SELECT B.BOARD_NO, "
					   + "           B.Q_TITLE,"
					   + "           B.Q_CONTENT,"
					   + "			 B.Q_DATE,"
					   + "           NVL(C.CM_CONTENT, '댓글없음') AS CM_CONTENT,"
					   + "			 C.CM_DATE	"
					   + "      FROM QNA_BOARD B, CMNTS C"
					   + "     WHERE B.BOARD_NO = C.BOARD_NO(+)";
			List<Map<String, Object>> list = jdbc.selectList(sql);
			return list;
			
		}
		
		
		
		public List<Map<String, Object>> getQnaBoardMEMID(String memberId) {
			String sql = "SELECT * FROM QNA_BOARD"
								+ "        WHERE MEM_ID= ? ";
			List<Object> param = new ArrayList<>();
			param.add(memberId);
			return jdbc.selectList(sql, param);
			
			 
		}
		
		public List<Map<String, Object>> getQnaBoardNO(int boardNo) {
			String sql = "SELECT * FROM QNA_BOARD"
								+ "        WHERE BOARD_NO= ? ";
			List<Object> param = new ArrayList<>();
			param.add(boardNo);
			return jdbc.selectList(sql, param);
		}
		
		public List<Map<String, Object>> allQnaBoard() {
			QnABoardDTO boardDTO = new QnABoardDTO();
			String sql = "SELECT * FROM QNA_BOARD";
			List<Map<String, Object>>  list = jdbc.selectList(sql);
			return list;
		}
		
		public int deleteQnA(int  boardNo) {
			String sql = "DELETE FROM QNA_BOARD "
					+ " WHERE BOARD_NO = "+ boardNo;
			
			return jdbc.update(sql);
					
		
			
		}

}















