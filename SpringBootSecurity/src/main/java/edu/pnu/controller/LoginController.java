package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.pnu.domain.Member;
import edu.pnu.service.MemberService;

@Controller
public class LoginController {
	PasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public void login() {}	
	
	@GetMapping("/loginSuccess")
	public void loginSuccess() {}	
	
	
	@GetMapping("/accessDenied")
	public void accessDenied() {}	
	
	//로그인 세션 정보 확인용 URL
	@GetMapping("/auth")
	public @ResponseBody String auth(@AuthenticationPrincipal OAuth2User user) { //User
		
		if(user ==null) {
			return "user is Null";
		}
		
		return user.toString();
	}
	
	@GetMapping("/join")
	public void join() {		
	}
	
	@PostMapping("/join")
	public String joinProc(Member member) {
		if(!member.getUsername().isEmpty() && !member.getPassword().isEmpty()) {			
			//member.setUsername(member.getUsername());
			member.setPassword(encoder.encode(member.getPassword()));
			member.setEnabled(true);
			member.setRole("ROLE_MEMBER");
		}		
		memberService.save(member);
		return "welcome";
		
	}

}
