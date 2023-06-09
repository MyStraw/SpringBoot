package edu.pnu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

	public TestConfig() {// 생성자 생성.
		System.out.println("=".repeat(50));
		System.out.println("TestConfig가 생성되었습니다.");
		System.out.println("=".repeat(50));
	}
	@Bean //이거 해주니까 아래꺼 실행되네~? @Configuration과 쌍. 
	public TestBean testBean() {
		return new TestBean(); //객체 리턴해서 자동으로 메모리에 올려둔다. bean:인스턴스.
	}	//IOC, 스프링 프레임워크 컨테이너 메모리에 자동으로 객체 생성해서 올린다. 스프링부트가 관리. 
}



//밑에... 새로 파일 만들기 싫으니 여기에 클래스 만들쟈~

class TestBean{
	public TestBean() {// 생성자 생성.
		System.out.println("=".repeat(50));
		System.out.println("TestBean이 생성되었습니다.");
		System.out.println("=".repeat(50));
	}
}