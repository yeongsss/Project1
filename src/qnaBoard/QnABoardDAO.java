package qnaBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

	public List<QnABoardDTO> selectQnABoard(String memberId){
		String sql = "SELECT BOARD_NO, MEM_ID, Q_DATE, Q_TITLE"
								+ " FROM QNA_BOARD "
								+ "	WHERE MEM_ID = ?";


		return instance.selectQnABoard()
	}

	// public List<Map<String, Object>> selectQnABoard(Map<String, Object> param) {
//		String sql = "SELECT BOARD_NO, MEM_ID, Q_DATE, Q_TITLE"
//							 + " FROM QNA_BOARD "
//							 + "	WHERE MEM_ID = ?";
//		List<Object> list = new ArrayList<>();
//		list.add(param.get("MEM_ID"));
//				
//		return jdbc.selectList(sql, list);
//	}
//	
//	public int insertQnABoard(Map<String, Object> param) {
//		String sql = "INSERT INTO "
//							+ "			QNA_BOARD"
//							+ " 	 VALUES (SEQ_BOARD_NO.NEXTVAL, ?, SYSDATE, ?, ?)";
//
//		List<Object> list = new ArrayList<>();
//		list.add(param.get("MEM_ID"));
//		list.add(param.get("Q_TITLE"));
//		list.add(param.get("Q_CONTENT"));
//				
//		return jdbc.update(sql, list);
//	}
//	
//	public int deleteQnABoard(Map<String , Object> param) {
//		String sql = "DELETE FROM QNA_BOARD"
//							 + "		WHERE BOARD_NO = ? ";
//		
//		List<Object> list = new ArrayList<>();
//		list.add(param.get("BOARD_NO"));
//		
//		return jdbc.update(sql,list);
//	}

}
