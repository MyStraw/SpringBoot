package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberDaoH2Impl implements MemberInterface {

	private String driver = "org.h2.Driver";
	private String url = "jdbc:h2:tcp://localhost/~/mission2";
	private String username = "scott";
	private String password = "tiger";

	private Connection con;

	public MemberDaoH2Impl() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			System.out.println("데이터베이스가 연결되었습니다");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MemberVO> getMembers() {
		List<MemberVO> list = new ArrayList<>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(String.format("select * from Member order by id"));

			while (rs.next()) {

				list.add(MemberVO.builder().id(rs.getInt("id")).pass(rs.getString("pass")).name(rs.getString("name"))
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

	@Override
	public MemberVO getMember(Integer id) {
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

	@Override
	public MemberVO addMember(MemberVO member) {
		try {
			Statement stmt = con.createStatement();
			int ret = stmt.executeUpdate(String.format("insert into member (pass,name) values('%s','%s')",
					member.getPass(), member.getName()));
			stmt.close();
			if (ret == 1) {
				System.out.println("입력됐어용");
				return member;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public MemberVO updateMember(MemberVO member) {
		try {
			Statement stmt = con.createStatement();
			int ret = stmt.executeUpdate(String.format("update member set pass = '%s', name = '%s' where id = '%d'",
					member.getPass(), member.getName(), member.getId()));
			stmt.close();
			if (ret == 1) {
				System.out.println("업뎃됐어용");
				return member;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
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
