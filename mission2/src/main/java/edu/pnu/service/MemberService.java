package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.Member;

@Service
public class MemberService { //왜 서비스를 이리 굴려서 쓰나~ 걍 해봐.
	
	@Autowired
	private MemberDao memberDao;	
	
//	public MemberService() {
//		memberDao = new MemberDao();		
//	}
	
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
 