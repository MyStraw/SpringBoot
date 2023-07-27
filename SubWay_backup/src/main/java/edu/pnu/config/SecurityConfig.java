package edu.pnu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 스프링 설정. 애플리케이션, bean 설정 정의. @Bean은 이게 달린 메소드가 생성한 객체를 스프링 컨테이너가 관리하도록. 스프링 빈에
				// 등록됨.

public class SecurityConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**").allowedOrigins("http://localhost:3000") // React 앱의 URL
				.allowedMethods("*").allowCredentials(true);
	}

}
