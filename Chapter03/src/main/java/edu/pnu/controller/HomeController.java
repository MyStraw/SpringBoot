package edu.pnu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j //simple logging facade for java
@RestController
public class HomeController {

	public HomeController() {
		System.out.println("HomeController가 생성되었습니다");
		log.error("HomeController error가 생성되었습니다");
		log.warn("HomeController warn가 생성되었습니다");
		log.info("HomeController info가 생성되었습니다"); //이게 기본 옵션
		log.debug("HomeController debug가 생성되었습니다"); //화면에 안나와
		log.trace("HomeController trace가 생성되었습니다"); //화면에 안나와.이게 제일 상세.
		
	}

	@GetMapping("/hello")
	public String hello(String name) {
		return "Hello : " + name;
	}
}
