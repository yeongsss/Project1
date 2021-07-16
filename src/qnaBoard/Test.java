package qnaBoard;

import java.util.List;
import java.util.Map;

import selectMenu.ScanUtil;

public class Test {
	public static void main(String[] args) {
		QnABoardDAO qnABoardDAO = QnABoardDAO.getInstance();
		while (true) {
			System.out.println("1.QnA 조회 \t 2.QnA등록 \t 3.QnA글 검색(아이디)");
			System.out.print("선택>> ");
			switch (ScanUtil.nextInt()) {
			case 1 :  
				List<Map<String,Object>> list = qnABoardDAO.allQnaBoard();
				for (Map<String, Object> map : list) {
					System.out.printf("%s\t\t%s\t%s\t%s\n", map.get("MEM_ID"), map.get("BOARD_NO"), map.get("Q_TITLE"), map.get("Q_DATE"));
				}
				break;
				
				
				
			case 2:
							QnABoardDTO qnABoardDTO = new QnABoardDTO();
							
							System.out.print("아이디>>");
							qnABoardDTO.setMemberId(ScanUtil.nextLine());
							System.out.print("제목>>");
							qnABoardDTO.setQnaTitle(ScanUtil.nextLine());
							System.out.println("내용>>");
							qnABoardDTO.setQnaContent(ScanUtil.nextLine());
							
							if (qnABoardDAO.insertQnABoard(qnABoardDTO)) {
								System.out.println("QnA등록 성공");
							} else {
								System.out.println("QnA등록 실패");
							}
				break;
				
			case 3:
				
							System.out.print("검색할 아이디 입력>>");
							System.out.println(qnABoardDAO.getQnaBoard(ScanUtil.nextLine()));
							break;
			}
			System.out.println("----------------------------------------------------------------------------------");
		}
		
	}
}