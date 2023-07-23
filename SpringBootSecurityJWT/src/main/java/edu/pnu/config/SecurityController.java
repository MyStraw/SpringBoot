package edu.pnu.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //RESTful 웹 서비스의 컨트롤러임을 나타낸다. @Controller + @ResponseBody를 합친거라 보면 되겠당
//컨트롤러 클래스의 모든 메소드가 ResponseBody를 가지는 효과!
public class SecurityController {
	
	@GetMapping("/") //HTTP Get요청을 해당 메소드로 처리할겨.
	public String index() {
		return "index"; //이 문자열을 반환하고...// 뷰 리졸버, Thymeleaf 등 썼을때 index.html 뭐 이런거 됐던거 같은데
	}
	
	@GetMapping("/member") // /member 경로로 들어오는건 내가 처리할거야~
	public String member() {
		return "member";
	}

	@GetMapping("/manager")
	public String manager() {
		return "manager";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin"; 
	}

}
