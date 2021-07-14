package member;

import java.util.List;
import java.util.Scanner;

import member.MemberDAO;
import member.MemberDTO;

public class MemberTest {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		menu: while (true) {
			System.out.println("--------------------------------------");
			System.out.println("메뉴를 선택하세요.");
			System.out.println("1.조회 | 2. 등록 | 3.수정 | 4.삭제 | 5.종료");
			System.out.println("--------------------------------------");
			MemberDAO dao = new MemberDAO();
			int menuNum = scanner.nextInt();
			switch (menuNum) {
			case 1:
				List<MemberDTO> list = dao.selectMember();
				for (MemberDTO dto : list) {
					System.out.println(String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s", dto.getId(), dto.getName(),
							dto.getPassword(), dto.getBirth(), dto.getHp(), dto.getAdd1(), dto.getAdd2()));

				}
				break;
			case 2:
				System.out.println("아이디: ");
				String id = scanner.next();
				System.out.println("비밀번호: ");
				String password = scanner.next();
				System.out.println("이름: ");
				String name = scanner.next();
				System.out.println("생년월일: ");
				String birth = scanner.next();
				System.out.println("전화번호: ");
				String hp = scanner.next();
				System.out.println("기본주소: ");
				String add1 = scanner.next();
				System.out.println("상세주소: ");
				String add2 = scanner.next();
				String author = scanner.next();

				int executeUpdate = dao.insertMember(new MemberDTO(id, password, name, birth, hp, add1, add2, author));

				if (executeUpdate > 0) {
					System.out.println("정상 등록되었습니다");

				} else {
					System.out.println("등록되지 않았습니다");
				}
				break;
			case 3:

				break;
			case 4:
				System.out.println("삭제할 아이디:");
				String deleteId = scanner.next();
				int deleteMember = dao.deleteMember(deleteId);
				if (deleteMember > 0) {
					System.out.println("삭제되었습니다");

				} else {
					System.out.println("삭제되지 않았습니다");
				}
				break;

			case 5:
				System.out.println("프로그램이 종료됩니다.");

				break menu;

			default:
				break;
			}

		}

		scanner.close();
	}

}
