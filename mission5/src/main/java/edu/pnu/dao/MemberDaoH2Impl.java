package edu.pnu.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.pnu.domain.MemberVO;

@Repository
public class MemberDaoH2Impl implements MemberInterface {

	@Autowired
	private DataSource dataSource;

	private int getMaxID() {
		try {
			Statement stmt = dataSource.getConnection().createStatement();
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
			Statement stmt = dataSource.getConnection().createStatement();
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
		map.put("method", "Get");
		String sql = String.format("select * from Member where id=%d", id); // 오~~
		map.put("sqlstring", sql);
		map.put("success", false);
		try {
			Statement stmt = dataSource.getConnection().createStatement();
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
		map.put("method", "Post");
		String sql = String.format("insert into member (pass,name) values('%s','%s')", member.getPass(), member.getName());
		map.put("sqlstring", sql);
		map.put("success", false);

		try {
			Statement stmt = dataSource.getConnection().createStatement();
			
			int ret = stmt.executeUpdate(sql);
			map.put("success", true);
			stmt.close();
			if (ret == 1)
				System.out.println("입력됐어용");
			int maxid = getMaxID();
			map.put("result", getMember(maxid).get("result"));
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		System.out.println("입력됐어용");
		return map;
	}

	@Override
	public Map<String, Object> updateMember(MemberVO member) {
		Map<String, Object> map = new HashMap<>();
		map.put("method", "Put");
		String sql = String.format("update member set pass = '%s', name = '%s' where id = %d", member.getPass(), member.getName(), member.getId());
		map.put("sqlstring", sql);
		map.put("success", false);

		try {
			Statement stmt = dataSource.getConnection().createStatement();
			
			int ret = stmt.executeUpdate(sql);

			stmt.close();
			if (ret == 1) {
				System.out.println("업뎃됐어용");
				map.put("success", true);
				map.put("result", getMember(member.getId()).get("result"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> deleteMember(Integer id) {
		Map<String, Object> map = new HashMap<>();
		map.put("method", "Delete");
		String sql = String.format("delete from member where id= %d", id);
		map.put("sqlstring", sql);
		map.put("success", false);
		try {
			Statement stmt = dataSource.getConnection().createStatement();
			
			int ret = stmt.executeUpdate(sql);
			stmt.close();
			map.put("success", true);
			map.put("result", ret);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("삭제됐어용");
		return map;
	}
}