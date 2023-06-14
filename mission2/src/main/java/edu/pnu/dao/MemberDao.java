package edu.pnu.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.pnu.domain.Member;


@Repository //다오에서의 준비 끝.. 어플리케이션 시작하자마자 멤버 다오도 자동으로 객체를 만들어서 컨테이너에 올린다.
//이름이 뭐로 되는지는 모른다. 부트가 알아서 객체 이름 만들어서 컨테이너(메모리)에 올린다.
//데이터소스의 베이스를 해서 이 객체도 올린다.
//컨트롤러도 @RestController 이게 있어서 같이 올라간다. 지금까지 총 3개.
//서비스가 멤버 다오를 만드네? 만들면 안된댔잖아. 이것도 메모리에 올라가야겠다. 서비스로 가.
public class MemberDao {
	
	@Autowired
	private DataSource dataSource;
//	private String driver = "org.h2.Driver";
//	private String url = "jdbc:h2:tcp://localhost/~/mission2";
//	private String username = "scott";
//	private String password = "tiger";
//
//	private Connection con;

//	public MemberDao() { // 멤버다오 만듦과 동시에 커넥션 객체 만듦
//		try {
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, username, password);
//			System.out.println("데이터베이스가 연결되었습니다");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public Member getMember(Long id) {
		try {
			Statement stmt = dataSource.getConnection().createStatement();

			ResultSet rs = stmt.executeQuery(String.format("select * from Member where id=%d", id));
			rs.next();
			Member m = Member.builder().id(rs.getLong("id")).pass(rs.getString("pass")).name(rs.getString("name"))
					.regidate(rs.getDate("regidate")) //
					.build();
			rs.close();
			stmt.close();
			return m;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Member> getMembers() {
		List<Member> list = new ArrayList<>();
		try {
			Statement stmt = dataSource.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select * from Member");

			while (rs.next()) {
				Member m = Member.builder().id(rs.getLong("id")).pass(rs.getString("pass")).name(rs.getString("name"))
						.regidate(rs.getDate("regidate")) //
						.build();
				list.add(m); //리스트를 만들었으니까 추가를 해줘야지. 빌더 객체를 만들어서 얘 읽어오게 일 시켜가지고 리스트에 넣어.
			}
			rs.close();
			stmt.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int insertMember(Member member) {
		try {
			Statement stmt = dataSource.getConnection().createStatement();
			stmt.executeUpdate(String.format("insert into member (pass,name) values('%s','%s')", member.getPass(),
					member.getName()));
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("입력됐어용");
		return 1;
	}

	public int updateMember(Member member) {
		try {
			Statement stmt = dataSource.getConnection().createStatement();
			stmt.executeUpdate(String.format("update member set pass = '%s', name = '%s' where id = '%d'",
					member.getPass(), member.getName(), member.getId()));
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("업뎃됐어용");
		return 1;
	}

	public int deleteMember(Long id) {
		try {
			Statement stmt = dataSource.getConnection().createStatement();
			stmt.executeUpdate(String.format("delete from member where id='%d'", id));
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("삭제됐어용");
		return 1;
	}
}
