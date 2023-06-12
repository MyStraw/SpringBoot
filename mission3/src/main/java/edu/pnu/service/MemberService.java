package edu.pnu.service;

import java.util.List;

import edu.pnu.dao.MemberDao;
import edu.pnu.dao.MemberDaoListImpl;
import edu.pnu.domain.MemberVO;

public class MemberService {

	private MemberDao memberDao;
	private List<MemberVO> list;

	public MemberService() {
//		memberDao = new MemberDaoH2Impl();

		memberDao = new MemberDaoListImpl();		
	}

	public List<MemberVO> getMembers() {
		
		return memberDao.getMambers();
	}

	public MemberVO getMember(Integer id) {
		return memberDao.getMember(id);
	}

	public MemberVO addMember(MemberVO member) {

		return memberDao.addMember(member);
	}

	public MemberVO updateMamber(MemberVO member) {

		return memberDao.updateMamber(member);
	}

	public int deleteMember(Integer id) {

		return memberDao.deleteMember(id);
	}

}