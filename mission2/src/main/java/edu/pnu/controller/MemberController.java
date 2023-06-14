package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Member;
import edu.pnu.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController // 실행하자마자 등록
@RequiredArgsConstructor //4번.

public class MemberController {

	//1번 //필드에 설정하는 방법
	//@Autowired //멤버서비스 객체를 자동으로 오토와이어.
	private final MemberService memberService; //4번일때 final
	
	//2번 //생성자에서 설정하는 방법
	@Autowired 
//	public MemberController(MemberService memberService) {
//		this.memberService = memberService;		
//	}

	//3번 Setter를 이용한 방법
//	@Autowired 
//	private void setMemberService(MemberService memberService) {
//		this.memberService = memberService;	
//	}
	
	//4번. @RequiredArgsConstructor(롬복) 이거에 final 해주면 끝.
	//롬복 어노테이션을 활용한 방법. 2번방법을 롬복으로 활용한것뿐.
	//final 이 붙은것만 해준다.
	
	
//	public MemberController() {
//		System.out.println("MemberController가 생성되었습니다.");
//		log.info("MemberController가 생성되었습니다."); // 이건 오른쪽 화살표로 보면 오른쪽에 찍혀있다
//
////		memberService = new MemberService(); 객체 만들믄 안돼.
//
//	} // .info 라 하면 로그에도 info. 디버그 찍으면 디버그라 찍힌다.

	// 멤버 한사람 가져와서 리턴하는 코드
	// localhost:8080/member/1
	@GetMapping("/member/{id}") // id가 경로변수로 활용
	public Member getMember(@PathVariable Long id) {
		return memberService.getMember(id);
	}

	@GetMapping("/member") // 모든 멤버 데이터를 리턴 (Create = get)
	public List<Member> getMembers() {
		return memberService.getMembers(); //memberService.getMembers();
	}

	@PostMapping("/member") // 새로운 멤버 입력 (
	public int insertMember(Member member) {
		return memberService.insertMember(member);
	}

	@PutMapping("/member") // 멤버 이름, 암호 수정
	public int updateMember(Member member) {
		return memberService.updateMember(member);
	}

	@DeleteMapping("/member/{id}") // 멤버 삭제
	public int deleteMember(@PathVariable Long id) {
		return memberService.deleteMember(id);
	}
}
