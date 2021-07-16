package qnaBoard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import selectMenu.ScanUtil;
 
public class Test {
	public static void main(String[] args) {
		QnABoardDAO qnABoardDAO = QnABoardDAO.getInstance();
		qna :while (true) {
			System.out.println("1.QnA 조회 \t 2.QnA등록 \t 3.QnA글 검색(아이디)\t 4.QnA 수정 0.종료");
			System.out.print("선택>> ");
			int i =1;
			switch (ScanUtil.nextInt()) {
			// 조회
			case 1 :  
				List<Map<String,Object>> list = qnABoardDAO.allQnaBoard();
						for (Map<String, Object> map : list) {
					System.out.printf("글번호: %s\t작성일: %s\t아이디: %s\n제목: %s\n",(i++), map.get("Q_DATE").toString().split(" ")[0], map.get("MEM_ID"),  map.get("Q_TITLE"));
					
				}
				break;
			// 등록	
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
			// 검색	
			case 3:
				
							System.out.print("검색할 아이디 입력>>");
							List<Map<String,Object>> qnaBoard = qnABoardDAO.getQnaBoard(ScanUtil.nextLine());
							for (Map<String, Object> map : qnaBoard) {
								System.out.printf("글번호: %s\t작성일: %s\t아이디: %s\n제목: %s내용: %s\n", i, map.get("Q_DATE").toString().split(" ")[0], map.get("MEM_ID"),  map.get("Q_TITLE"),map.get("Q_CONTENT"));
							}
							break;
			// 수정
			case 4: 
					QnABoardDTO qnABoardDTO2 = new QnABoardDTO();
				
					System.out.print("수정할 글 번호 입력>>");
					qnABoardDTO2.setBoardNo(ScanUtil.nextInt());
					System.out.println("수정할 내용 입력>>");
					qnABoardDTO2.setQnaContent(ScanUtil.nextLine());
					
					if (qnABoardDAO.updateQnABoard(qnABoardDTO2)) {
						System.out.println("수정 성공");
					} else {
						System.out.println("수정 실패");
					}
					break;
					
			case 0: 
				System.out.println("QnA 종료");
				break qna;
			}
			System.out.println("----------------------------------------------------------------------------------");
			
		}
		
	}
}