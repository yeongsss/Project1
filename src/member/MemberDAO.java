package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

	public List<MemberDTO> selectMember() throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "projectTest",
				"java");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM MEMBER"); //
		List<MemberDTO> list = new ArrayList<>();
		while (resultSet.next()) {
			String id = resultSet.getString("MEM_ID");
			String password = resultSet.getString("MEM_PW");
			String name = resultSet.getString("MEM_NAME");
			String birth = resultSet.getString("MEM_BIRTH");
			String hp = resultSet.getString("MEM_HP");
			String add1 = resultSet.getString("MEM_ADD1");
			String add2 = resultSet.getString("MEM_ADD2");
			String author = resultSet.getString("AUTHOR");

			list.add(new MemberDTO(id, password, name, birth, hp, add1, add2, author));

		}
		// 6. 사용된 자원 반납
		resultSet.close();
		statement.close();
		connection.close();
		return list;

	}

	public int insertMember(MemberDTO dto) throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "projectTest",
				"java"); // 접속할 DB주소, 아이디, 비밀번호 입력
		Statement statement = connection.createStatement();

		StringBuilder builder = new StringBuilder();
		builder.append("INSERT INTO MEMBER (");
		builder.append("	MEM_ID,");
		builder.append("	MEM_PW,");
		builder.append("	MEM_NAME,");
		builder.append("	MEM_BIRTH,");
		builder.append("	MEM_HP,");
		builder.append("	MEM_ADD1,");
		builder.append("	MEM_ADD2,");
		builder.append("	AUTHOR");
		builder.append(") VALUES(");
		builder.append("	'" + dto.getId() + "',");
		builder.append("	'" + dto.getPassword() + "',");
		builder.append("	'" + dto.getName() + "',");
		builder.append("	'" + dto.getBirth() + "',");
		builder.append("	'" + dto.getHp() + "',");
		builder.append("	'" + dto.getAdd1() + "',");
		builder.append("	'" + dto.getAdd2() + "',");
		builder.append("	'" + dto.getAuthor() +"'");
		builder.append(")");
		int executeUpdate = statement.executeUpdate(builder.toString());

		statement.close();
		connection.close();
		return executeUpdate;
	}

	public int deleteMember(String id) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "projectTest",
				"java");
		PreparedStatement statement = connection.prepareStatement("DELETE FROM MEMBER WHERE MEM_ID = ?");
		statement.setString(1, id);
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;

	}

}
