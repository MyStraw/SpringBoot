package edu.pnu.service;

import java.util.List;

import edu.pnu.dao.MemberDaoH2Impl;
import edu.pnu.dao.MemberInterface;
import edu.pnu.domain.MemberVO;

public class MemberService {

	private MemberInterface memberInterface;;
	private List<MemberVO> list;

	public MemberService() {
		memberInterface = new MemberDaoH2Impl();

	//	memberInterface = new MemberDaoListImpl();		
	}

	public List<MemberVO> getMembers() {
		
		return memberInterface.getMembers();
	}

	public MemberVO getMember(Integer id) {
		return memberInterface.getMember(id);
	}

	public MemberVO addMember(MemberVO member) {

		return memberInterface.addMember(member);
	}

	public MemberVO updateMember(MemberVO member) {

		return memberInterface.updateMember(member);
	}

	public int deleteMember(Integer id) {

		return memberInterface.deleteMember(id);
	}

}
