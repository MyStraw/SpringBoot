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

@Slf4j // 롬복에서 제공하는 어노테이션. 자동으로 로깅 코드를 생성. 로깅은 프로그램 실행줄 발생하는 이벤트나 상태정보를 기록. log 작업.
		// 동작추적, 모니터링, 디버깅이 가능.
//@Slf4j 애너테이션은 클래스에 붙여 사용하며, 해당 클래스에서 로그 메시지를 출력하기 위해 Logger 객체를 자동으로 생성합니다. 생성된 Logger 객체를 사용하여 다양한 로그 레벨에 따라 메시지를 출력할 수 있습니다. 예를 들어, log.info("정보 메시지");와 같은 형식으로 로그 메시지를 출력할 수 있습니다.

@RestController // Spring Framework에서 제공하는 애너테이션으로, 해당 클래스가 RESTful 웹 서비스의 컨트롤러 역할을 한다는 것을
				// 나타냅니다.
//@RestController 애너테이션이 붙은 클래스는 HTTP 요청에 대한 처리를 담당하며, 요청을 받고 응답을 반환하는 역할을 수행합니다. 
//이를 위해 필요한 메서드에는 다양한 HTTP 메서드에 대응하는 애너테이션을 사용하여 요청을 처리합니다. 
//예를 들어, @GetMapping, @PostMapping, @PutMapping, @DeleteMapping 등이 있으며, 이러한 애너테이션을 메서드에 적용하여 해당 요청을 처리합니다.
//@RestController 애너테이션이 적용된 클래스는 Spring MVC에서 자동으로 인식되어 요청과 매핑되는 엔드포인트로 사용됩니다. 따라서, 클라이언트의 요청에 대한 처리 로직을 구현하고 응답을 생성하여 반환하는 역할을 수행합니다.

public class MemberController {
	
	private MemberService memberService; //멤버서비스에 있는걸 여기서. 멤버서비스를 사용할수 있도록 준비. 이 memberService 객체를 사용해서 MemberService 클래스의 메서드를 호출해서 사용가능.

	private MemberController() { // 생성자
		System.out.println("MemberController가 생성되었습니다"); // 인스턴스 생성됐다는~
		log.info("MemberController가 생성되었습니다"); // 로그랑 sysout이랑 비교 해보셈

		memberService = new MemberService(); // 컨트롤러에서 서비스에서 DAO로.
	}

	// @RestController 했으니까 겟매핑, 포스트 매핑등을 해야겠지?

	@GetMapping("/member/{id}") // id가 경로변수로. 실제 요청 URL에서 해당위치의 값을 추출하여 메서드 내부에서 사용할수 있도록 한다. 이를 위해
								// @Pathvariable.을 사용해서 경로변수를 매개변수로 끌어들일수있다.
	public Member getMember(@PathVariable Long id) { // 이건 매소드.
		return memberService.getMember(id); // 이걸 통해 수행.

	}
	
	@GetMapping("/member")
	public List<Member> getMembers(){
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