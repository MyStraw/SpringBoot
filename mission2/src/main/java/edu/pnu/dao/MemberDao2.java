package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.pnu.domain.Member;

public class MemberDao2 {

	private String driver = "org.h2.Driver";
	private String url = "jdbc:h2:tcp://localhost/~/mission2";
	private String username = "scott";
	private String password = "tiger";

	private Connection con;

	public MemberDao2() { // 멤버다오 만듦과 동시에 커넥션 객체 만듦
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			System.out.println("데이터베이스가 연결되었습니다");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Member getMember(Long id) {
		try {
			Statement stmt = con.createStatement();

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
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(String.format("select * from Member order by id")); //모든멤버 다 갖고올거니 스트링 포맷 없어도된다.
			//리스트를 만들었으니까 추가를 해줘야지. 빌더 객체를 만들어서 얘 읽어오게 일 시켜가지고 리스트에 넣어.

			while (rs.next()) { //리스트를 만들어서 추가해주고, 
				
				list.add(Member.builder().id(rs.getLong("id")).pass(rs.getString("pass")).name(rs.getString("name"))
						.regidate(rs.getDate("regidate")).build()); 
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
			Statement stmt = con.createStatement();
			int ret = stmt.executeUpdate(String.format("insert into member (pass,name) values('%s','%s')", member.getPass(),
					member.getName()));
			stmt.close();
			return ret; //기본적으로 1 리턴
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("입력됐어용");
		return 0;
	}

	public int updateMember(Member member) {
		try {
			Statement stmt = con.createStatement();
			int ret = stmt.executeUpdate(String.format("update member set pass = '%s', name = '%s' where id = '%d'",
					member.getPass(), member.getName(), member.getId()));
			stmt.close();
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("업뎃됐어용");
		return 1;
	}

	public int deleteMember(Long id) {
		try {
			Statement stmt = con.createStatement();
			int ret = stmt.executeUpdate(String.format("delete from member where id='%d'", id));
			stmt.close();
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("삭제됐어용");
		return 1;
	}
}
