package comment;

import java.util.List;
import java.util.Map;

import member.MemberService;
import qnaBoard.QnABoardDAO;
import selectMenu.JDBCUtil;
import selectMenu.ScanUtil;
import selectMenu.View;

public class CommentService {
	
	private static CommentService instance;

	private CommentService() {
	}

	public static CommentService getInstance() {
		if (instance == null) {
			instance = new CommentService();
		}
		return instance;
	}
	
	private static JDBCUtil jdbc = JDBCUtil.getInstance();
	QnABoardDAO boardDAO = QnABoardDAO.getInstance();
	CommentDAO dao = CommentDAO.getInstance();
	
	
	
	
	public int managementComment() {
		int cnt =1;
		comment: while (true) {
			System.out.println("---------------------------------------- 댓글 관리 ----------------------------------------");
			System.out.println("1.댓글 조회 \t 2.댓글 등록 \t 3.댓글 삭제 \t 0.종료");
			System.out.println("--------------------------------------------------------------------------------------------");
			System.out.print("선택 :  ");
			switch (ScanUtil.nextInt()) {
			case 1:
				List<Map<String , Object>> list1 = dao.allComment();
				if (list1 == null) {
					System.out.println("댓글이 없습니다. 등록해주세요");
					return managementComment();
				}
				for (Map<String, Object> map : list1) {
					System.out.printf("글번호: %s\n작성일: %s\n아이디: %s\n댓글: %s\n",map.get("BOARD_NO"),map.get("CM_DATE").toString().split(" ")[0],map.get("MEM_ID"),map.get("CM_CONTENT"));
				}
				break;

				
			case 2: 
//				List<Map<String, Object>> list = boardDAO.allQnaBoard();
//				for (Map<String, Object> map : list) {
//					System.out.println("-------------------------------------------------------------------------------------------");
//					System.out.printf("%s\nNo( %s)\t작성일: %s\t작성자: %s\t제목: %s\n", (cnt++), map.get("BOARD_NO"),
//							map.get("Q_DATE").toString().split(" ")[0], map.get("MEM_ID"), map.get("Q_TITLE"));}
				CommentDTO commentDTO = new CommentDTO();
				System.out.print("글번호 : ");
				commentDTO.setBoardNo(ScanUtil.nextInt());
				System.out.print("아이디: ");
				commentDTO.setMemberId(ScanUtil.nextLine());
				System.out.print("댓글내용: ");
				commentDTO.setCommentContent(ScanUtil.nextLine());
				
				if (dao.insertComment(commentDTO)) {
					System.out.println("댓글 등록 성공");
				} else {
					System.out.println("댓글 등록 실패");
				}
				break;

			case 3: 
				System.out.print("삭제할 댓글 번호>");
				dao.deleteComment(ScanUtil.nextInt());
				break;
			
			case 0 : 
				System.out.println("종료");
				 break comment;
			default:
				break;
			}
		}
		return View.BOARD_LIST;
		
		}
		}