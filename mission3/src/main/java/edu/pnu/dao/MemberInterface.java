package edu.pnu.dao;

import java.util.List;

import edu.pnu.domain.MemberVO;

public interface MemberInterface { //인터페이스는 껍데기. 이것들을 반드시 밑에 애들이 구현해라!
	//추상 클래스는 부모로부터 기능을 상속받아 이용하고 확장 시키는데 있다! 사용 목적이 다르다. 비슷해도.
	//다중상속을 지원하지 않기에 둘이 좋다.
	
	List<MemberVO> getMembers();

	MemberVO getMember (Integer id);	

	MemberVO addMember(MemberVO member);

	MemberVO updateMember(MemberVO member);

	int deleteMember(Integer id);
	
}
