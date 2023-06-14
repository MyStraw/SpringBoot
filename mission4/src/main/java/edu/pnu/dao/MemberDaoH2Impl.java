package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.pnu.domain.MemberVO;

public class MemberDaoH2Impl implements MemberInterface {

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

	private int getMaxID() {
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM member");

			rs.next();
			int maxId = rs.getInt(1);

			rs.close();
			stmt.close();

			return maxId;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public Map<String, Object> getMembers() {
		Map<String, Object> map = new HashMap<>();
		List<MemberVO> list = new ArrayList<>();
		String sql = "select * from Member order by id";

		map.put("method", "Get");
		map.put("sqlstring", sql);
		map.put("success", false);

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(String.format(sql));

			while (rs.next()) {
				list.add(MemberVO.builder().id(rs.getInt("id")).pass(rs.getString("pass")).name(rs.getString("name"))
						.regidate(rs.getDate("regidate")).build());
			}
			map.put("success", true);
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("result", list);
		return map;
	}

	@Override
	public Map<String, Object> getMember(Integer id) {
		Map<String, Object> map = new HashMap<>();
		String sql = String.format("select * from Member where id=%d", id);
		map.put("method", "Get");
		map.put("sqlstring", sql);
		map.put("success", false);
		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			MemberVO m = MemberVO.builder().id(rs.getInt("id")).pass(rs.getString("pass")).name(rs.getString("name"))
					.regidate(rs.getDate("regidate")) //
					.build();
			map.put("success", true);
			rs.close();
			stmt.close();
			map.put("result", m);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> addMember(MemberVO member) {
		Map<String, Object> map = new HashMap<>();
		String sql = String.format("insert into member (pass,name) values('%s','%s')", member.getPass(), member.getName());
		map.put("method", "Post");
		map.put("sqlstring", sql);
		map.put("success", false);

		try {
			Statement stmt = con.createStatement();
			int ret = stmt.executeUpdate(sql);
			map.put("success", true);
			stmt.close();
			if (ret == 1)
				System.out.println("입력됐어용");
			int maxid = getMaxID();
			map.put("result", getMember(maxid).get("result"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("입력됐어용");
		return map;
	}

	@Override
	public Map<String, Object> updateMember(MemberVO member) {
		Map<String, Object> map = new HashMap<>();
		String sql = String.format("update member set pass = '%s', name = '%s' where id = %d", member.getPass(), member.getName(), member.getId());

		map.put("method", "Put");
		map.put("sqlstring", sql);
		map.put("success", false);

		try {
			Statement stmt = con.createStatement();

			int ret = stmt.executeUpdate(sql);

			stmt.close();
			if (ret == 1)
				System.out.println("업뎃됐어용");
			map.put("success", true);
			map.put("result", getMember(member.getId()).get("result"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> deleteMember(Integer id) {
		Map<String, Object> map = new HashMap<>();
		String sql = String.format("delete from member where id= %d", id);
		map.put("method", "Delete");
		map.put("sqlstring", sql);
		map.put("success", false);
		try {
			Statement stmt = con.createStatement();

			int ret = stmt.executeUpdate(sql);

			stmt.close();
			map.put("success", true);
			map.put("result", 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("삭제됐어용");
		return map;
	}
}