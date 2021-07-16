package qnaBoard;

import java.util.List;

import selectMenu.Util;

public class Test {
	public static void main(String[] args) {
		QnABoardDAO qnABoardDAO = QnABoardDAO.getInstance();
		while (true) {
			System.out.println("1.QnA등록 \t 2.QnA글 검색(아이디)");
			System.out.print("선택>> ");
			switch (Util.nextInt()) {
			case 1:
							QnABoardDTO qnABoardDTO = new QnABoardDTO();
							
							System.out.print("아이디>>");
							qnABoardDTO.setMemberId(Util.nextLine());
							System.out.print("제목>>");
							qnABoardDTO.setQnaTitle(Util.nextLine());
							System.out.println("내용>>");
							qnABoardDTO.setQnaContent(Util.nextLine());
							
							if (qnABoardDAO.insertQnABoard(qnABoardDTO)) {
								System.out.println("QnA등록 성공");
							} else {
								System.out.println("QnA등록 실패");
							}
				break;
				
			case 2:
							System.out.print("검색할 아이디 입력>>");
							System.out.println(qnABoardDAO.getQnaBoard(Util.nextLine()));
							break;
			}
			System.out.println("----------------------------------------------------------------------------------");
		}
		
	}
}