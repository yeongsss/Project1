package member;

import java.util.Objects;

public class MemberDTO {
	private String memberId; // 아이디
	private String memberPassword; // 비밀번호
	private String memberName; // 이름
	private String memberBirth; // 생년월일
	private String memberHp; // 전화번호
	private String memberAdd1; // 기본주소
	private String memberAdd2; // 상세주소
	private String author; // 일반회원, 권리자권한 여부

	public MemberDTO() {
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String getMemberHp() {
		return memberHp;
	}

	public void setMemberHp(String memberHp) {
		this.memberHp = memberHp;
	}

	public String getMemberAdd1() {
		return memberAdd1;
	}

	public void setMemberAdd1(String memberAdd1) {
		this.memberAdd1 = memberAdd1;
	}

	public String getMemberAdd2() {
		return memberAdd2;
	}

	public void setMemberAdd2(String memberAdd2) {
		this.memberAdd2 = memberAdd2;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, memberAdd1, memberAdd2, memberBirth, memberHp, memberId, memberName,
				memberPassword);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberDTO other = (MemberDTO) obj;
		return Objects.equals(author, other.author) && Objects.equals(memberAdd1, other.memberAdd1)
				&& Objects.equals(memberAdd2, other.memberAdd2) && Objects.equals(memberBirth, other.memberBirth)
				&& Objects.equals(memberHp, other.memberHp) && Objects.equals(memberId, other.memberId)
				&& Objects.equals(memberName, other.memberName) && Objects.equals(memberPassword, other.memberPassword);
	}

	@Override
	public String toString() {
		return "MemberDTO [memberId=" + memberId + ", memberPassword=" + memberPassword + ", memberName=" + memberName
				+ ", memberBirth=" + memberBirth + ", memberHp=" + memberHp + ", memberAdd1=" + memberAdd1
				+ ", memberAdd2=" + memberAdd2 + ", author=" + author + "]";
	}
	
}
	