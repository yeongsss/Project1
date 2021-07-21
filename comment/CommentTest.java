package comment;

public class CommentTest {
	public static void main(String[] args) {
		CommentService commentService = CommentService.getInstance();
		
		commentService.managementComment();
	}
		}