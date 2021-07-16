package qnaBoard;

public class QnABoardDTO {
		private int boardNo;
		private String memberId;
		private String qnaDate;
		private String qnaTitle;
		private String qnaContent;
		
		public QnABoardDTO() {
		}

		public QnABoardDTO( String memberId, String qnaDate, String qnaTitle, String qnaContent) {
			super();
			this.memberId = memberId;
			this.qnaDate = qnaDate;
			this.qnaTitle = qnaTitle;
			this.qnaContent = qnaContent;
		}
		public QnABoardDTO(int boardNo, String memberId, String qnaDate, String qnaTitle, String qnaContent) {
			super();
			this.boardNo = boardNo;
			this.memberId = memberId;
			this.qnaDate = qnaDate;
			this.qnaTitle = qnaTitle;
			this.qnaContent = qnaContent;
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

		public String getQnaDate() {
			return qnaDate;
		}

		public void setQnaDate(String qnaDate) {
			this.qnaDate = qnaDate;
		}

		public String getQnaTitle() {
			return qnaTitle;
		}

		public void setQnaTitle(String qnaTitle) {
			this.qnaTitle = qnaTitle;
		}

		public String getQnaContent() {
			return qnaContent;
		}

		public void setQnaContent(String qnaContent) {
			this.qnaContent = qnaContent;
		}

		@Override
		public String toString() {
			return "QnA게시판 [ 글번호 : " + boardNo + "\t 아이디 : " + memberId + "\t 작성일 : " + qnaDate + "] \n 제목 : "
					+ qnaTitle + "\n 내용 : " + qnaContent ;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + boardNo;
			result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
			result = prime * result + ((qnaContent == null) ? 0 : qnaContent.hashCode());
			result = prime * result + ((qnaDate == null) ? 0 : qnaDate.hashCode());
			result = prime * result + ((qnaTitle == null) ? 0 : qnaTitle.hashCode());
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
			QnABoardDTO other = (QnABoardDTO) obj;
			if (boardNo != other.boardNo)
				return false;
			if (memberId == null) {
				if (other.memberId != null)
					return false;
			} else if (!memberId.equals(other.memberId))
				return false;
			if (qnaContent == null) {
				if (other.qnaContent != null)
					return false;
			} else if (!qnaContent.equals(other.qnaContent))
				return false;
			if (qnaDate == null) {
				if (other.qnaDate != null)
					return false;
			} else if (!qnaDate.equals(other.qnaDate))
				return false;
			if (qnaTitle == null) {
				if (other.qnaTitle != null)
					return false;
			} else if (!qnaTitle.equals(other.qnaTitle))
				return false;
			return true;
		}
		
		
}
