package qnaBoard;

import java.io.IOException;
import java.sql.SQLNonTransientException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import comment.CommentDAO;
import comment.CommentDTO;
import comment.CommentService;
import member.MemberDAO;
import member.MemberService;
import selectMenu.ScanUtil;
import selectMenu.View;

public class QnABoardService {
	private static QnABoardService instance;

	private QnABoardService() {
	}

	public static QnABoardService getInstance() {
		if (instance == null) {
			instance = new QnABoardService();
		}
		return instance;
	}

	QnABoardDAO qnABoardDAO = QnABoardDAO.getInstance();
	MemberService memberservice = MemberService.getInstance();
	CommentDAO commentDAO = CommentDAO.getInstance();

	public int boardManagement() throws IOException {
		qna: while (true) {
			System.out.println();
			System.out.println("------------------------------ QnA게시판 (관리자) -------------------------------");
			System.out.println("1.QnA조회 \t 2.QnA삭제 \t 3.댓글작성 \t 4.댓글삭제  0.이전단계");
			System.out.println("---------------------------------------------------------------------------------");
			System.out.print("번호 입력 :  ");
			switch (ScanUtil.nextInt()) {
			case 1:
				List<Map<String, Object>> qnaBoard = qnABoardDAO.getBoard();
				for (Map<String, Object> map : qnaBoard) {
//						System.out.println("----
					if (map.get("CM_DATE") == null) {
						System.out.printf("%s   제목: %s	내용: %s	날짜: %s\n    댓글: %s	날짜: %s\n", map.get("BOARD_NO"),
								map.get("Q_TITLE"), map.get("Q_CONTENT"), map.get("Q_DATE").toString().split(" ")[0],
								"--", "--");
						System.out.println();
					} else {
						System.out.printf("%s   제목: %s	내용: %s	날짜: %s\n    댓글: %s	날짜: %s\n", map.get("BOARD_NO"),
								map.get("Q_TITLE"), map.get("Q_CONTENT"), map.get("Q_DATE").toString().split(" ")[0],
								map.get("CM_CONTENT"), map.get("CM_DATE").toString().split(" ")[0]);
						System.out.println();
					}

				}
				break;
			case 2:
				System.out.print("삭제할 번호 입력:  ");
				int input = ScanUtil.nextInt();
				if (commentDAO.deleteComment(input)) {
					if (qnABoardDAO.deleteQnA(ScanUtil.nextInt())) {
						System.out.println("삭제 완료!");
					}
				} else {
					System.out.println("실패");
				}

				break;

			case 3:
				CommentDTO commentDTO = new CommentDTO();
				System.out.print("글번호 : ");
				commentDTO.setBoardNo(ScanUtil.nextInt());
				System.out.print("아이디: ");
				commentDTO.setMemberId(ScanUtil.nextLine());
				System.out.print("댓글내용: ");
				commentDTO.setCommentContent(ScanUtil.nextLine());

				if (commentDAO.insertComment(commentDTO)) {
					System.out.println("댓글 등록 성공");
				} else {
					System.out.println("댓글 등록 실패");
				}
				break;

			case 4:
				System.out.print("삭제할 댓글 번호 :  ");
				if (commentDAO.deleteComment(ScanUtil.nextInt())) {
					System.out.println("삭제 완료!");
				} else {
					System.out.println("삭제 실패!");
				}

			case 0:
				return memberservice.mypageAdmin();
			}
		}
	}

	public int qnaBoardMember() {
		// 게시글 순번
		int cnt = 1;
		qna: while (true) {
			System.out.println();
			System.out.println("========================== QnA ==========================");
			System.out.println("1.QnA 조회 \t 2.QnA등록 \t 3.QnA글 검색(아이디)\t 4.QnA 수정 \t 0.종료");
			System.out.print("선택>> ");
			int input = ScanUtil.nextInt();
			if (input >= 0 && input < 5) {

				switch (input) {
				// 조회
				case 1:
					List<Map<String, Object>> list = qnABoardDAO.allQnaBoard();
					for (Map<String, Object> map : list) {
						System.out.println(
								"-------------------------------------------------------------------------------------------");
						System.out.printf("%s\nNo( %s)\t작성일: %s\t작성자: %s\t제목: %s\n", (cnt++), map.get("BOARD_NO"),
								map.get("Q_DATE").toString().split(" ")[0], map.get("MEM_ID"), map.get("Q_TITLE"));
//						System.out.println();
					}
					cnt = 1;
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
					List<Map<String, Object>> qnaBoard = qnABoardDAO.getQnaBoardMEMID(ScanUtil.nextLine());

					for (Map<String, Object> map : qnaBoard) {
						System.out.println(
								"------------------------------------------------------------------------------------------------");
						System.out.print("=>  ");
						System.out.printf("No(%s)\t작성일: %s\t작성자: %s\n\t\t\t제목: %s\n\t\t\t내용: %s\n", map.get("BOARD_NO"),
								map.get("Q_DATE").toString().split(" ")[0], map.get("MEM_ID"), map.get("Q_TITLE"),
								map.get("Q_CONTENT"));
					}
					cnt = 1;
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
				}// switch문
			} // if 문
			else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
				continue;
			}
		}
		return View.HOME;
	}

}