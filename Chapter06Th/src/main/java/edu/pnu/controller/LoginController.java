package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import edu.pnu.domain.Member;
import edu.pnu.service.MemberService;

@SessionAttributes("member")
@Controller
public class LoginController {

	@Autowired
	private MemberService memberService;

	@GetMapping("/login") // 8080/login 여기서 로드인.html 뷰리졸브로 로그인 화면 뜬다.
	public void loginView() {
	}
	// 이거 하면 또 똑같은 주소 8080/login으로 post로 온다.

	@PostMapping("/login")
	public String login(Member member, Model model) {
		Member findMember = memberService.getMember(member);

		if (findMember != null && findMember.getPassword().equals(member.getPassword())) {
			model.addAttribute("member", findMember);
			// 얘가 실제 모델객체에 넣는 의미도 있지만, "member"키로 findMember value를 세션에다가 저장한다
			// "member" 말고 다른걸로 한번 해봐. 로그인이면 세션에 저장하고, 세션에 저장한 이름은 세션 어트리뷰트에서 설정을 해뒀고,
			// 이 이름을 가지고 로그인 상태인지아닌지 보드 컨트롤러의 @ModelAttribute("member") Member member 이 항목으로
			// 처리한다.
			// 보드 컨트롤러의 @ModelAttribute("member") 이부분도 없애고 해봐.
			return "forward:getBoardList"; // forward 안하고 리다이렉트 했다
			// 누구 이름 뜨고
		} else {
			return "redirect:loginError"; //loginError?
		}
	}

	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:index.html";
	}

}
