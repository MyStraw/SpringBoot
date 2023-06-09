package com.rubypaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.rubypaper", "edu.pnu"}) //이거 재 정의. 최상위 패키지만 적으면 된다. 하위패키지까지 다 뒤져줘.
public class Chapter01Application { 

	public static void main(String[] args) {
		SpringApplication.run(Chapter01Application.class, args);
		
	}  


}
