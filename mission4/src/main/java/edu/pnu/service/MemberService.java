package edu.pnu.service;

import java.util.List;
import java.util.Map;

import edu.pnu.dao.LogDao;
import edu.pnu.dao.MemberDaoH2Impl;
import edu.pnu.dao.MemberInterface;
import edu.pnu.domain.MemberVO;

public class MemberService {
	private MemberInterface memberInterface;;
	private List<MemberVO> list;
	private LogDao logDao;

	public MemberService() {
		memberInterface = new MemberDaoH2Impl();

	//	memberInterface = new MemberDaoListImpl();	
		logDao = new LogDao();
	}

	public Map<String, Object> getMembers() {
		
		return memberInterface.getMembers();
	}

	public Map<String, Object> getMember(Integer id) {
		return memberInterface.getMember(id);
	}

	public Map<String, Object> addMember(MemberVO member) {

		return memberInterface.addMember(member);
	}

	public Map<String, Object> updateMember(MemberVO member) {

		return memberInterface.updateMember(member);
	}

	public Map<String, Object> deleteMember(Integer id) {

		return memberInterface.deleteMember(id);
	}
	

}