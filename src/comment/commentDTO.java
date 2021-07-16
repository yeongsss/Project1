package comment;

public class commentDTO {
	private int boardNo;
	private String memberId;
	private int commentDate;
	private String commentContent;
	
	public commentDTO() {
	}

	public commentDTO(int boardNo, String memberId, String commentContent) {
		super();
		this.boardNo = boardNo;
		this.memberId = memberId;
		this.commentDate = commentDate;
		this.commentContent = commentContent;
	}

	
	public commentDTO(int boardNo, String memberId, int commentDate, String commentContent) {
		super();
		this.boardNo = boardNo;
		this.memberId = memberId;
		this.commentDate = commentDate;
		this.commentContent = commentContent;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(int commentDate) {
		this.commentDate = commentDate;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	@Override
	public String toString() {
		return "commentDTO [boardNo=" + boardNo + ", memberId=" + memberId + ", commentDate=" + commentDate
				+ ", commentContent=" + commentContent + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + boardNo;
		result = prime * result + ((commentContent == null) ? 0 : commentContent.hashCode());
		result = prime * result + commentDate;
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		commentDTO other = (commentDTO) obj;
		if (boardNo != other.boardNo)
			return false;
		if (commentContent == null) {
			if (other.commentContent != null)
				return false;
		} else if (!commentContent.equals(other.commentContent))
			return false;
		if (commentDate != other.commentDate)
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		return true;
	}
	
}
