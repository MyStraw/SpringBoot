package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Member;
import edu.pnu.service.MemberService;
import lombok.extern.slf4j.Slf4j;

@Slf4j // 롬복 로깅코드 생성. 로그생성.
@RestController // 겟매핑, 포스트, 풋, 딜리트 매핑 다 가능하게. HPPT요청에 대한 처리 담당.
public class MemberController {
	
	private MemberService memberService;
	
	public MemberController() {
		System.out.println("MemberController가 생성되었습니다");
		log.info("MemberController가 생성되었습니다");
	}
	
	@GetMapping("/member/{id}")
	public Member getMember(@PathVariable Long id) {
		return memberService.getMember(id);
	}
	
	@GetMapping("/member")
	public List<Member> getMembers() {
		return memberService.getMembers();
	}
	
	@PostMapping("/member")
	public int insertMember(Member member) {
		return memberService.insertMember(member);
	}
	
	@PutMapping("/member")
	public int updateMember(Member member) {
		return memberService.updateMember(member);
	}
	
	@DeleteMapping("/member/{id}")
	public int deleteMember(@PathVariable Long id) {
		return memberService.deleteMember(id);
	}

}
