package member;

import java.util.Objects;

public class MemberDTO {

	private String id;
	private String password;
	private String name;
	private String birth;
	private String hp;
	private String add1;
	private String add2;
	private String author;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getAdd1() {
		return add1;
	}
	public void setAdd1(String add1) {
		this.add1 = add1;
	}
	public String getAdd2() {
		return add2;
	}
	public void setAdd2(String add2) {
		this.add2 = add2;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public int hashCode() {
		return Objects.hash(add1, add2, author, birth, hp, id, name, password);
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
		return Objects.equals(add1, other.add1) && Objects.equals(add2, other.add2)
				&& Objects.equals(author, other.author) && Objects.equals(birth, other.birth)
				&& Objects.equals(hp, other.hp) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password);
	}
	public MemberDTO(String id, String password, String name, String birth, String hp, String add1, String add2,
			String author) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.birth = birth;
		this.hp = hp;
		this.add1 = add1;
		this.add2 = add2;
		this.author = author;
	}
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", password=" + password + ", name=" + name + ", birth=" + birth + ", hp=" + hp
				+ ", add1=" + add1 + ", add2=" + add2 + ", author=" + author + "]";
	}

}