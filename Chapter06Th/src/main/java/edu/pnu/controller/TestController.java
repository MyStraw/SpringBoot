package edu.pnu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@GetMapping("/hello")
	public void hello(Model model) {
		model.addAttribute("greeting", "Hello 타임리프.^^");
	}
	
//	@GetMapping("/hello")
//	public String hello(Model model) {
//		model.addAttribute("greeting", "Hello 타임리프.^^");
//		return "hello";//		
//	} 위랑 같당~
	

	
}

