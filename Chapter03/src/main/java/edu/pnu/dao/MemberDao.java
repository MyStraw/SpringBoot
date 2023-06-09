package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.pnu.domain.Member;

public class MemberDao {

	private String driver = "org.h2.Driver";
	private String url = "jdbc:h2:tcp://localhost/~/chapter3";
	private String username = "scott";
	private String password = "tiger";

	// Database Connection 설정(콘 객체 만들기)

	private Connection con;

	public MemberDao() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			System.out.println("데이터베이스에 연결됐당");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void insertMember(Member m) {
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(String.format("insert into member (name,age,nickname) values('%s', '%d','%s')",
					m.getName(), m.getAge(), m.getNickname()));

			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Member> getMembers() {
		List<Member> list = new ArrayList<>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(String.format("select * from member order by id"));

			while (rs.next()) {
				list.add(Member.builder().id(rs.getLong("id")).name(rs.getString("name")).age(rs.getInt("age"))
						.nickname(rs.getString("nickname")).build());
			}
			rs.close();
			stmt.close();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Member getMember(Long id) {
		String sql = "select * from member where id =?";
		PreparedStatement ps;
		try {
			// Statement stmt = con.createStatement();
			// ResultSet rs = stmt.executeQuery(String.format("select * from member where id
			// = '%d'", id));
			ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();

			rs.next();
			if (rs != null) {
				Member.builder().id(rs.getLong("id")).name(rs.getString("name")).age(rs.getInt("age"))
						.nickname(rs.getString("nickname")).build();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
