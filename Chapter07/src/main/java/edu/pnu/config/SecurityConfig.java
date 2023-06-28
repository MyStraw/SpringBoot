package edu.pnu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //bean 객체 등록해야 하니까~ 근데 시큐리티에서 제공되는걸 사용 못하게 막으니까
@EnableWebSecurity //이걸로 사용하게 하겠다
public class SecurityConfig {
	
	@Autowired
	BoardUserDetailsService boardUserDetailsService;
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}//이 클래스를 만들어서 IOC 컨테이너 등록한단 얘기. (바로 암호화 라이브러리.)
	
	
	
	@Bean //빈이 붙었으니 http.build() 이 객체가 IOC에 등록되고 사용되게끔 하겠징. 이 상태서 실행하면 다 된다.
	//로그인창 안뜨고 걍 된다. 시큐리티에서 제공해주는걸 다 안쓰겠다! 선언
	public SecurityFilterChain filterChan(HttpSecurity security) throws Exception {
		
		security.authorizeHttpRequests(auth->{
//			auth.requestMatchers("/").permitAll();
//			auth.requestMatchers("/member//**").authenticated();
			
			auth.requestMatchers("/member/**").authenticated() //인증이 되어야 한다
			.requestMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN") //이중에 어떠한 한개라도 권한이 있어야 한다.		
			.requestMatchers("/admin/**").hasRole("ADMIN") //그외 하부는 전부 admin
			.anyRequest().permitAll(); //그외 모든 요청은 전부 허용 하겠다. 이러면 코드읽기 쉽다
		});
		
//		security.csrf().disable(); //이 기능을 무효화 하겠다. 이것도 옛날버전 사라졌다. 
		security.csrf(csrf->csrf.disable()); // 포스트맨 같은데서도 접근 가능하게 해준다.
		//스크립트로 url호출 못하게 막는애가 csrf 인데, 가능하도록.
		//security.cors(cors->cors.disable());
		//cors는 리액트에서 호출하는.. cors보호 비할성화.
		
		
		//security.formLogin(); //이것도 사라졌네
		//security.formLogin(form->form.defaultSuccessUrl("/")); //form 로그인을 쓰겠다! 루트(인덱스) 화면을 띄워주겠다
		//로그인 창은 뜬다 여기까진. 하지만 로그인은 안돼. 아직 에러
		security.formLogin(form->{ //여러줄일땐 이렇게
			form.loginPage("/login") //로그인 페이지로는 뭘 쓸거냐~ 겟 매핑이징 이건. 로그인 페이지 불러와야지. 
			// 로그인 컨트롤러 만들자. 이 로그인을 받아줄 컨트롤러를 만들어야. 그냥 시큐리티 컨트롤러에 만들어도 됨.
			.defaultSuccessUrl("/loginSuccess", true); //로그인 성공하면 여기로 가라.
		});
		
		security.exceptionHandling(ex->ex.accessDeniedPage("/accessDenied"));
		
		security.logout(logt->{
			logt.invalidateHttpSession(true)
					.deleteCookies("JSESSIONID")
					.logoutSuccessUrl("/login");		
		
		});
		
		security.userDetailsService(boardUserDetailsService);
		
		return security.build();
	}
	
	@Autowired //이거하면 application.properties에 abcd 막힌다.
	public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("member")
		.password("{noop}abcd")
		.roles("MEMBER");
		
		auth.inMemoryAuthentication()
		.withUser("manager")
		.password("{noop}abcd")
		.roles("MANAGER");
		
		auth.inMemoryAuthentication()
		.withUser("admin")
		.password("{noop}abcd")
		.roles("ADMIN");
		
	}
}
