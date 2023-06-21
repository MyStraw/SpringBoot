package edu.pnu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/home") //이건 url주소일뿐
	public String home() {
		// [/WEB-INF/board/home.jsp]를 호출해라! 는 의미
		return "home"; 
	}
	
	// [/WEB-INF/board/home1.jsp]. home1로 호출을 한다.		
	@GetMapping("/home1")
	public void home1() {
	}	// 이건 리턴이 없으니까 "/home1" 이름을 자동으로 대신 사용한다.
	
	@GetMapping("/model") //EL을 배웠으니 이런식으로.
	public String model(Model model) {//부트가 자동으로 객체 만들어서 넘겨줘. new Model 할필요가 없어
		
		//List<Board> list = testService.getdata();
		//model.addAttribute("list", list); 리스트도 이런식으로 하겠지.
		
		model.addAttribute("data", "홍길동"); //model.jsp 에 있는 data. 디스패쳐 서블릿이 호출해서 모델안에
		//있는 데이터를 쪼개서 model.jsp를 호출하면서 리퀘스트 형태로 다 넣어준다.
		return "model";
	}
}

