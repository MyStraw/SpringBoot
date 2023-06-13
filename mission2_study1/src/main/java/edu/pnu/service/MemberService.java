package edu.pnu.service;

import java.util.List;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.Member;

public class MemberService {
	
	private MemberDao memberDao;
	
	public MemberService() {
		memberDao = new MemberDao(); //컨트롤러에서는 서비스 객체를 생성해서 부르고, 서비스는 다오 객체를 생성해서 부르고.
	}

	public Member getMember(Long id) {		
		return memberDao.getMember(id);
	}

	public List<Member> getMembers() {
		
		return memberDao.getMembers();
	}

	public int insertMember(Member member) {
		
		return memberDao.insertMember(member);
	}

	public int updateMember(Member member) {
		
		return memberDao.updateMember(member);
	}

	public int deleteMember(Long id) {
		
		return memberDao.deleteMember(id);
	}

}
