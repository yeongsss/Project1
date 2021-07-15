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
	private String AUTHOR; // 일반회원, 권리자권한 여부

	public MemberDTO(String memberId, String memberPassword, String memberName, String memberBirth, String memberHp,
			String memberAdd1, String memberAdd2, String author) {
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberBirth = memberBirth;
		this.memberHp = memberHp;
		this.memberAdd1 = memberAdd1;
		this.memberAdd2 = memberAdd2;
		AUTHOR = author;
	}
	
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

	public String getAUTHOR() {
		return AUTHOR;
	}

	public void setAUTHOR(String aUTHOR) {
		AUTHOR = aUTHOR;
	}

	@Override
	public int hashCode() {
		return Objects.hash(AUTHOR, memberAdd1, memberAdd2, memberBirth, memberHp, memberId, memberName,
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
		return Objects.equals(AUTHOR, other.AUTHOR) && Objects.equals(memberAdd1, other.memberAdd1)
				&& Objects.equals(memberAdd2, other.memberAdd2) && Objects.equals(memberBirth, other.memberBirth)
				&& Objects.equals(memberHp, other.memberHp) && Objects.equals(memberId, other.memberId)
				&& Objects.equals(memberName, other.memberName) && Objects.equals(memberPassword, other.memberPassword);
	}

	@Override
	public String toString() {
		return "MemberDTO [회원 아이디=" + memberId + ", memberPassword=" + memberPassword + ", 회원 이름=" + memberName
				+ ", 생년월일=" + memberBirth + ", 전화번호=" + memberHp + ", 기본주소=" + memberAdd1
				+ ", 상세주소=" + memberAdd2 + ", 회원등급=" + AUTHOR + "]";
	}

}
