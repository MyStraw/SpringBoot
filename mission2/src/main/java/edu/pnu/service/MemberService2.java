package edu.pnu.service;

import java.util.List;

import org.springframework.web.bind.annotation.PutMapping;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.Member;

public class MemberService2 { //왜 서비스를 이리 굴려서 쓰나~ 걍 해봐.
	
	private MemberDao memberDao;	
	
	public MemberService2() {
		memberDao = new MemberDao();		
	}
	
	public Member getMember(Long id) {
		return memberDao.getMember(id);
	}
	
	public List<Member> getMembers() {
		return memberDao.getMembers(); //이것도 자동으로. 컨트롤러->서비스->DAO
		
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
 