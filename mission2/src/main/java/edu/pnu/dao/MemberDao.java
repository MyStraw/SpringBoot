package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import edu.pnu.domain.Member;

public class MemberDao {

	private String driver = "org.h2.Driver";
	private String url = "jdbc:h2:tcp://localhost/~/mission2";
	private String username = "scott";
	private String password = "tiger";
	
	private Connection con;
	
	public MemberDao() { //멤버다오 만듦과 동시에 커넥션 객체 만듦
		try {
			Class.forName(driver);			
			con = DriverManager.getConnection(url, username, password);
			System.out.println("데이터베이스가 연결되었습니다");
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public Member getMember(Long id)  {
		try {
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(String.format("select * from Member where id=%d", id));		
		rs.next();
		Member m = Member.builder()
				.id(rs.getLong("id"))
				.pass(rs.getString("pass"))
				.name(rs.getString("name"))
				.regidate(rs.getDate("regidate")) //
				.build();		
		rs.close();
		stmt.close();		
		return m;				
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Member> getMembers()  {
		try {
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(String.format("select * from Member"));		
		
		rs.next();
		Member m1 = Member.builder()
				.id(rs.getLong("id"))
				.pass(rs.getString("pass"))
				.name(rs.getString("name"))
				.regidate(rs.getDate("regidate")) //
				.build();		
		rs.close();
		stmt.close();		
		return m1;		
					
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Member insertMember(Member member) {
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(String.format("insert into mission2 (id, pass,name,regidate) values('%d','%s','%s','%s')", member.getId(),member.getPass(),member.getName(),member.getRegidate()));
			stmt.close();	
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("입력됐어용");
		return null;
	}
	
	public Member updateMember(Long id) {
		return null;
	}
	
	public void deleteMember(Long id) {
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("삭제됐어용");
	}
}
