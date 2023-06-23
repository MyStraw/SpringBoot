package edu.pnu.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // 익셉션 다 다루겠다
public class GlobalExceptionHandler {

	@ExceptionHandler(BoardException.class) // 모델세팅 : 뷰에다가 데이터 전달목적이 있다. 익셉션 객체 전체를 전달.
	public String handleCustomException(BoardException exception, Model model) { //보드익셉션 throw new 던지고
		//클래스 타입에 따라 boardException
		model.addAttribute("exception", exception); //보드부터 그 자식 클래스들 다 이 보라색 exception으로 온다.
		return "/errors/boardError"; //스트링이니까 여기로 리턴
	}
	
	@ExceptionHandler(Exception.class) // 모델세팅 : 뷰에다가 데이터 전달목적이 있다. 익셉션 객체 전체를 전달.
	public String handleException(Exception exception, Model model) {
		model.addAttribute("exception", exception); //loginError 따로 처리기 안만들어주면 여기에 걸린다.
		return "/errors/globalError";
	}
	
	@ExceptionHandler(UsernameNotFoundException.class) // 모델세팅 : 뷰에다가 데이터 전달목적이 있다. 익셉션 객체 전체를 전달.
	public String usernameNotFoundException(Exception exception, Model model) {
		model.addAttribute("exception", exception);
		return "/errors/loginError";
	}

}
