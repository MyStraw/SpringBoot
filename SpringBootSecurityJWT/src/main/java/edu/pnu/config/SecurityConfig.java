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


@Configuration //스프링 설정. 애플리케이션, bean 설정 정의. @Bean은 이게 달린 메소드가 생성한 객체를 스프링 컨테이너가 관리하도록. 스프링 빈에 등록됨.
@EnableWebSecurity // 스프링 시큐리티 활성화. 웹 보안 설정할수 있게;.


public class SecurityConfig {
	
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private AuthenticationConfiguration authConfig;
	
	
	
	@Bean //교수님 추가. 
	public PasswordEncoder bCryptPasswordEncoder() { 
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	// 암호화된 비밀번호를 생성하기 위한 BCryptPasswordEncoder를 스프링 빈으로 등록합니다.
	//이거 위에꺼랑 같다. 이게 ppt @Bean은 이게 달린 메소드가 생성한 객체를 스프링 컨테이너가 관리하도록. 스프링 빈에 등록됨.
//	@Bean 
//	public PasswordEncoder passwordEncoder() { 
		//return new BCryptPasswordEncoder();
	// PasswordEncoder 인터페이스의 구현체 BCryptPasswordEncoder()의 인스턴스 생성해 반환. 
	//PasswordEncoder가 빈으로 등록됨.
//	}
	
	
	@Bean	
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		//securityFilterChain : Bean을 생성하는 메소드. HTTP의 보안을 정의한다.
		
		http.csrf(csrf->csrf.disable()); //csrf 보호 비활성화(JS에서 호출가능) : Cross-Site Request Forgery. 웹사이트간 요청 위조공격 방지 
		http.cors(cors->cors.disable()); //cors 보호 비활성화(React에서 호출가능):RestAPI로 호출할때 :Cross-Origin Resource Sharing
		//다른 도메인에서의 리소스 접근을 제어하는 보안 기능
		
		http.authorizeHttpRequests(security->{ //http 요청에 대한 보안설정을 정의.
			security.requestMatchers("/member/**").authenticated() // /member/ 경로로 들어오는 요청은 인증된 사용자만 허용
			.requestMatchers("/manager/").hasAnyRole("MANAGER", "ADMIN") // /manager 경로로 오는애들은 매니저, 어드민만 허용
			.requestMatchers("/admin/**").hasRole("ADMIN") // /admin경로는 admin ROLE만 허용 
			.anyRequest().permitAll();
			
		});
		
		http.formLogin(frmLogin->frmLogin.disable()); //Form을 이용한 로그인을 사용하지 않겠다는 설정
		http.sessionManagement(ssmg->ssmg.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		//form 로그인은 그 우리가 url창에 /login 경로 쳤을때 스프링 시큐리티가 제공해주던 로그인 폼 페이지 있었잖아. 그걸 통한거 말하는거.
		//로그인 해서 상태 유지되는게 state
		//로그인 하고(리퀘스트) 하고 response 되는순간 삭제 : stateless
		//즉 리퀘스트랑 리스폰스 사이에만 세션 존재. 인증을 위해 세션을 사용하지 않겠다!
		//스프링 시큐리티가 세션을 생성하지 않음.
		//이는 JWT 토큰을 이용한 인증 방식에서 일반적으로 사용되는 설정이다
		
//		서버가 정상적으로 실행되는지 확인.
//		localhost:8080 호출하면 index가 출력되는지 확인
//		localhost:8080/login 호출하면 404 에러가 발생하는지 확인
//		localhost:8080/member 호출하면 403 에러가 발생하는지 확인	
		
		
		
		//http.addFilter(new JWTAuthenticationFilter()); 이제 이거 죽이고 밑에 파라미터 추가하면서
		//JWTAuthenticationFilter.java 에서 final 살리고 @ReauiredArgs~살리고
		
		
		//시큐리티 필터 체인에 커스텀으로 만든 필터를 추가하는 메소드를 add 하는 코드다. 여기서 말하는 필터는 웹 애플리케이션에서 HTTp요청이
		//서버에 도달하기 전에 실행되는 코드를 말하고, 이를 이용해 사용자 인증, 입력값 검증, 로깅 등 다양한 전처리 작업을 수행할 수 있다.
		//여기서 추가된JWTAuthenticationFilter는 JWT(JSON Web Token)기반의 사용자 인증을 처리하는 커스텀 필터이다.
		//이 필터는 사용자의 로그인 요청을 받아 로그인 처리를 하고, 성공적으로 로그인이 되었다면 JWT토큰을 생성해 응답에 표시하는 역할을 한다.
		
		//http.addFilter(new JWTAuthenticationFilter(authConfig.getAuthenticationManager()));//원래코드인데 
		//JWTAuthenticationFilter 에서 추가코드로 유저가 틀렸을떼 로그를 쓰려고 memRepo를 쓰려다보니 이걸 추가하게됨
		
		http.addFilter(new JWTAuthenticationFilter(authConfig.getAuthenticationManager(), memberRepo));
		//JWTAuthenticationFilter는 사용자 인증을 담당하며, 사용자 인증 정보를 통해 JWT 토큰을 생성하고 이를 응답에 포함시키는 로직을 
		//포함해야 한다. 이 필터를 체인에 추가함으로써 사용자 인증 요청이 JWTAuthenticationFilter를 거치게 된다. 이로서 보안을 강화.
		//JWTAuthenticationFilter의 생성자에 authConfig.getAuthenticationManager()를 넘기고 있는데, 
		//이건 JWTAuthenticationFilter에서 인증 과정을 수행하기 위해 필요한 AuthenticationManager 객체를 제공하려고 하는거. 그럼 AuthenticationManager이건 뭐냐
		//AuthenticationManager는 사용자의 인증 요청을 처리하는 인터페이스, Spring Security에서 제공한다. 
		//주로 ProviderManager라는 구현체를 사용하는데, 이는 여러 AuthenticationProvider들을 관리하면서 사용자의 인증 요청을 해당 프로바이더들에게 위임하는 역할을 한다.
		
		//authConfig는 맨 윗줄에 AuthenticationConfiguration의 객체이고, @Autowired를 이용해서 스프링이 자동으로 주입.
		//이 객체를 통해 스프링 시큐리티의 기본인 AuthenticationManager를 얻을수있다.
		
		//즉 JWTAuthenticationFilter가 인증을 수행할수 있도록 필요한 AuthenticationManager를 넘겨주면서
		//해당 필터를 HTTP요청에 추가하는 역할을 한다. 이를 통해 모든 요청은 JWTAuthenticationFilter를 거치게 되어 JWT를 이용한 인증 수행.
		
		http.addFilter(new JWTAuthorizationFilter(authConfig.getAuthenticationManager(), memberRepo));		
		//JWTAuthorizationFilter는 JWT 토큰을 사용하여 인증된 사용자의 요청을 인가하는 과정을 담당하는 필터다. 
		//이 필터는 보안 체인에서 인증(JWTAuthenticationFilter)된 후에 위치하고 토큰의 유효성을 검사하고 이에 따른 인증 객체를 생성해 
		//Spring Security Context에 등록하는 역할을 수행한다.
		//이렇게 설정된 Security Context는 이후 요청이 접근하려는 리소스에 대한 권한을 가지고 있는지 확인하는데 사용된다.
		//그리고 이 addFilter이하 부분은
		//JWTAuthorizationFilter를 HTTP 보안 필터 체인에 추가하는 코드이다 
		//이때 인자로 주입되는 AuthenticationManager는 사용자 인증 정보를 관리하고, MemberRepository는 사용자 정보를 데이터베이스에서 조회하는데 사용된다.
		//AuthenticationManager는 Spring Security에서 제공하는 사용자 인증을 처리하는 인터페이스로, 사용자의 인증 정보를 확인하고 관리합니다. 여기서는 사용자의 JWT 토큰이 유효한지 검사하는데 사용됩니다.
		//MemberRepository는 사용자 정보를 데이터베이스에서 조회하는 데 사용되는 인터페이스다. JWT 토큰에 포함된 사용자 이름(username)을 이용하여 사용자의 정보를 데이터베이스에서 꺼내온다.조회한다.
		//그래서 이 코드는 모든 HTTP 요청이 JWT를 이용하여 인가를 받도록 JWTAuthorizationFilter를 보안 필터 체인에 추가하는 역할을 한다.
		
		
		return http.build(); //httpSecurity 설정을 빌드하고 이걸 사용, securityFilterChain을 생성해 반환.
	}	

}
