package edu.pnu.service;

import java.util.List;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.Member;

public class MemberService { //왜 서비스를 이리 굴려서 쓰나~ 걍 해봐.
	
	private MemberDao memberDao;
	private List<Member> list;
	
	public MemberService() {
		memberDao = new MemberDao();		
	}
	
	public Member getMember(Long id) {
		return memberDao.getMember(id);
	}
	
	public List<Member> getMembers() {
		return list;
		
	}

}
 