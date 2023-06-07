package com.rubypaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chapter01Application { 

	public static void main(String[] args) {
		SpringApplication.run(Chapter01Application.class, args);
		//run -> 쓰레드 도는 코드. 메인쓰레드. 근데 자바는 메인쓰레드가 죽어도 자식쓰레드가 살아있다.
		//메인쓰레드 종료해도 계속 접속상태.
	} //부트 실행 메인 중추. 
	//.exe 실행하는건 프로세스.
	//일을 나눠서 작업(병행하게 진행되는 일 하나하나를 쓰레드라고 한다.)

}
