package edu.pnu.dao;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import edu.pnu.domain.MemberVO;

public class MemberDaoH2Impl extends MemberDao {
	
	private String driver = "org.h2.Driver";
	private String url = "jdbc:h2:tcp://localhost/~/mission2";
	private String username = "scott";
	private String password = "tiger";


	private Connection con;
	
	
	
	public MemberDaoH2Impl() { // 멤버다오 만듦과 동시에 커넥션 객체 만듦
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			System.out.println("데이터베이스가 연결되었습니다");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public MemberVO getMember(Long id) {
		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(String.format("select * from Member where id=%d", id));
			rs.next();
			MemberVO m = MemberVO.builder().id(rs.getInt("id")).pass(rs.getString("pass")).name(rs.getString("name"))
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


	public MemberVO addMember(MemberVO member) {		
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

	public MemberVO updateMamber(MemberVO member) {		
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

	public int deleteMember(Integer id) {		
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
