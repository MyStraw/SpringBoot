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

@Slf4j
@RestController // 실행하자마자 등록
public class MemberController2 {

	private MemberService memberService;

	public MemberController2() {
		System.out.println("MemberController가 생성되었습니다.");
		log.info("MemberController가 생성되었습니다."); // 이건 오른쪽 화살표로 보면 오른쪽에 찍혀있다

		memberService = new MemberService();

	} // .info 라 하면 로그에도 info. 디버그 찍으면 디버그라 찍힌다.

	// 멤버 한사람 가져와서 리턴하는 코드
	// localhost:8080/member/1
	@GetMapping("/member/{id}") // id가 경로변수로 활용
	public Member getMember(@PathVariable Long id) {
		return memberService.getMember(id); //서비스엔 이거 안만들어줬으니 서비스에 create
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
