package edu.pnu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RestController //이걸로 해야 실행이 되겠지?
public class SecurityController {

	@GetMapping({"/", "/index"})
	public String index() {
		System.out.println("index 요청입니다.");
		return "index";
	}

	@GetMapping("/member")
	public void forMember() {
		System.out.println("Member 요청입니다."); //member.html을 찾는다. void가 되면. 메소드 이름이랑은 관계없다 

	}

	@GetMapping("/manager")
	public void forManager() {
		System.out.println("Manager 요청입니다.");

	}

	@GetMapping("/admin")
	public void forAdmin() {
		System.out.println("Admin 요청입니다.");

	}
}
