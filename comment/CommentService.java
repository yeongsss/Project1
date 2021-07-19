package comment;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import qnaBoard.QnABoardDAO;
import selectMenu.ScanUtil;

public class CommentService {
	public static void main(String[] args) {

		QnABoardDAO qnABoardDAO = QnABoardDAO.getInstance();
		CommentDAO dao = CommentDAO.getInstance();
		int cnt = 1;

		service: while (true) {
			System.out.println("===========================================================");
			System.out.println("1.QnA 조회 \t 2.QnA등록 \t 3.QnA글 검색(아이디)\t 4.QnA 수정 \t 0.종료");
			System.out.print("선택>> ");
			int input = ScanUtil.nextInt();
			if (input >= 0 && input < 5) {

				switch (input) {
				case 1:
					List<Map<String, Object>> list = qnABoardDAO.allQnaBoard();
					for (Map<String, Object> map : list) {
						System.out.println(	"-------------------------------------------------------------------------------------------");
						System.out.printf("%s\nNo( %s)\t작성일: %s\t작성자: %s\t제목: %s\n", (cnt++), map.get("BOARD_NO"),
								map.get("Q_DATE").toString().split(" ")[0], map.get("MEM_ID"), map.get("Q_TITLE"));
					}
					System.out.println("============================================================");
					cnt = 1;
					System.out.println("1.댓글등록 \t 2.이전단계");
					System.out.print("선택>>");
					int input2 = ScanUtil.nextInt();
					switch (input2) {
					case 1:
						CommentDTO commentDTO = new CommentDTO();
						System.out.print("글번호 : ");
						int boardNo = ScanUtil.nextInt();
						commentDTO.setBoardNo(boardNo);
						System.out.print("아이디: ");
						String memberId = ScanUtil.nextLine();
						commentDTO.setMemberId(memberId);
						System.out.print("댓글내용: ");
						commentDTO.setCommentContent(ScanUtil.nextLine());

						if (dao.insertComment(commentDTO)) {
							System.out.println("댓글 등록 성공");
						} else {
							System.out.println("댓글 등록 실패");
						}
						List<Map<String, Object>> qnaBoard = qnABoardDAO.getQnaBoardNO(boardNo);
						for (Map<String, Object> map : qnaBoard) {
							System.out.println("------------------------------------------------------------------------------------------------");
							System.out.print("QnA :   ");
							System.out.printf("No.%s \t작성일:%s\t작성자:%s\n\t\t\t제목: %s\n\t\t\t내용: %s\n", map.get("BOARD_NO"),
									map.get("Q_DATE").toString().split(" ")[0], map.get("MEM_ID"), map.get("Q_TITLE"),
									map.get("Q_CONTENT"));
						}
						List<Map<String, Object>> comment = dao.getComment(boardNo);
						for (Map<String, Object> map : comment) {
							System.out.printf("글번호:%s\t작성일:%s\t아이디:%s\n댓글:%s\n",map.get("BOARD_NO"),map.get("CM_DATE").toString().split(" ")[0],map.get("MEM_ID"),map.get("CM_CONTENT"));
						}
						
						
						break;
					case 2:
						break;
					}
					break;
				case 2:
					
				default:
					break;
				}
			}
		}

	}
}