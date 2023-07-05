package edu.pnu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import edu.pnu.config.auth.JWTAuthorizationFilter;
import edu.pnu.config.filter.JWTAuthenticationFilter;
import edu.pnu.persistence.MemberRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private AuthenticationConfiguration authConfig;
	
	
	
	@Bean //교수님 추가.
	public PasswordEncoder bCryptPasswordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	
//	@Bean //이거 위에꺼랑 같다. 이게 ppt
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	
	
	@Bean	
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http.csrf(csrf->csrf.disable());
		http.cors(cors->cors.disable());
		
		http.authorizeHttpRequests(security->{
			security.requestMatchers("/member/**").authenticated()
			.requestMatchers("/manager/").hasAnyRole("MANAGER", "ADMIN")
			.requestMatchers("/admin/**").hasRole("ADMIN")
			.anyRequest().permitAll();
			
		});
		
		http.formLogin(frmLogin->frmLogin.disable());
		http.sessionManagement(ssmg->ssmg.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		//로그인 해서 상태 유지되는게 state
		//로그인 하고(리퀘스트) 하고 response 되는순간 삭제 : stateless
		//즉 리퀘스트랑 리스폰스 사이에만 세션 존재.
		
		//http.addFilter(new JWTAuthenticationFilter()); 이제 이거 죽이고 밑에 파라미터 추가하면서
		//JWTAuthenticationFilter.java 에서 final 살리고 @ReauiredArgs~살리고
	
		http.addFilter(new JWTAuthenticationFilter(authConfig.getAuthenticationManager(), memberRepository));		
		http.addFilter(new JWTAuthorizationFilter(authConfig.getAuthenticationManager(),
				memberRepository));		
		
		
		
		return http.build();
	}	

}
