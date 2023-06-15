package edu.pnu.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.pnu.domain.MemberVO;

@Repository
public class MemberDaoListImpl implements MemberInterface {

	@Autowired
	private DataSource dataSource;

	private List<MemberVO> list;

	public MemberDaoListImpl() {

		list = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			list.add(new MemberVO(i, "1234", "이름" + i, new Date())); // 서비스 5개 만들어 바로.

		}
	}

	@Override
	public Map<String, Object> getMembers() { // 어렵
		Map<String, Object> map = new HashMap<>();
		map.put("method", "Get");
		map.put("sqlstring", "모든데이터");
		map.put("success", true);
		map.put("result", list);
		return map;
	}

	@Override
	public Map<String, Object> getMember(Integer id) {

		for (MemberVO m : list) {
			if (m.getId() == id) {
				Map<String, Object> map = new HashMap<>();
				map.put("method", "Get");
				map.put("sqlstring", "특정누구만");
				map.put("success", true);
				map.put("result", m);
				return map;
			}
		}
		return null;
	}

	private int getNextId() {
		return list.size() + 1;
	}

	@Override
	public Map<String, Object> addMember(MemberVO member) {
		member.setId(list.size() + 1);
		member.setRegidate(new Date());
		list.add(member);
		Map<String, Object> map = new HashMap<>();
		map.put("method", "Post");
		map.put("sqlstring", "추가");
		map.put("success", true);
		map.put("result", member);
		return map;
	}

	@Override
	public Map<String, Object> updateMember(MemberVO member) {

		for (MemberVO m : list) {
			if (m.getId() == member.getId()) {
				m.setName(member.getName());
				m.setPass(member.getPass());
				Map<String, Object> map = new HashMap<>();
				map.put("method", "Put");
				map.put("sqlstring", "업뎃");
				map.put("success", true);
				map.put("result", m);
				return map;
			}
		}
		return null;
	}

	@Override
	public Map<String, Object> deleteMember(Integer id) {	
		
		for (MemberVO m : list) {
			if (m.getId() == id) {
				list.remove(m);
				Map<String, Object> map = new HashMap<>();
				map.put("method", "Delete");
				map.put("sqlstring", "삭제");
				map.put("success", true);
				map.put("result", 1);
				return map;
			}
		}
		return null;
	}

}
