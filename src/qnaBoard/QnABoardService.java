package qnaBoard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class QnABoardService {
	private QnABoardService( ) {	}

	private static QnABoardService instance;

	private static QnABoardService getInstance() {
		if (instance == null) {
			instance = new QnABoardService();
		}
		return instance;
	}

	private QnABoardDAO QnABoard = QnABoardDAO.getInstance();
	
	public void QnABoard() {
			 Map<String,Object> param = new HashMap<>();
			 param.put("MEM_ID", param);
			 String[] board = {"BOARD_NO","MEM_ID","Q_DATE","Q_TITLE","Q_CONTENT"};
			 List<Map<String, Object>> list = QnABoard.selectQnABoard(param);
			 System.out.println("==========================================");
			 System.out.println("글번호\t 아이디\t작성일\t제목\t내용");
			 System.out.println("==========================================");
			 for (int i = 0; i < list.size() ; i++) {
				for (int j = 0; j < board.length; j++) {
					System.out.println(list.get(i).get(board[j])+ "\t\t");
				}
				System.out.println();
			}
			 System.out.println("===================================================");

}


}
