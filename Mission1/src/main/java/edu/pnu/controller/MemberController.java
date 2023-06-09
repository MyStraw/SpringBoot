package edu.pnu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;
//@Slf4j 이거 달면 이부분 없애도 된다.

@RestController
public class MemberController {

	private MemberService memberService; //객체선언
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class); //이부분
	
	public MemberController() { //컨트롤러 만들어 지자마자 멤버서비스.
		memberService = new MemberService();
	}
	
	@GetMapping("/hello")
	public String hello(String name) {
		return "Hello : " + name;
	}
	
	@GetMapping("/members")
	public List<MemberVO> getMembers() {
		log.info("getMembers()");
		return memberService.getMembers();
	}
//
	//localhost:8080/member/1	
	@GetMapping("/member/{id}") //초면입니다. 전형적인 RestAPI에서 데이터 가져오는 방식. 멤버중 아이디가 이거인 애를 가져와라. /member?id=~ 호출방식에 따라서 이렇게.
	public MemberVO getMember(@PathVariable Integer id) { //경로상 있는 변수를 매핑하겠다. 괄호안 id가 매핑돼서 Integer id에 온다. 디스패쳐가 알아서.
		log.info("getMember()");
		return memberService.getMember(id);
	}
	
	//localhost:8080/member?id=1
	@GetMapping("/member") ///member?id=~ 호출방식에 따라서 이렇게. 위랑 똑같다. 쿼리스트링 방식. 파라미터에 값 넣어주는거. 물음표 뒤에꺼가 자동으로 매핑해서 Integer id에 들여온다. 이건 부트가 알아서.
	public MemberVO getMember1(Integer id) {
		log.info("getMember()");
		return memberService.getMember(id);
	}
	
	@PostMapping("/member")
	public MemberVO addMember(MemberVO member) {
		log.info("addMember()");
		return memberService.addMember(member);
	}

	@PutMapping("/member")
	public MemberVO updateMember(MemberVO member) {
		log.info("updateMember()");
		return memberService.updateMember(member);
	}
	
	@DeleteMapping("/member/{id}")
	public MemberVO deleteMember(@PathVariable Integer id) {
		log.info("deleteMember()");
		return memberService.deleteMember(id);
	}
}
