package edu.pnu.config.filter;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//클래스에 Annotation 추가 (@Slf4j)
//JWT를 이용한 로그인 시스템은 일반적으로 JSON을 이용하므로 이를 기준으로 작성한다.

//먼저 @Slf4j 어노테이션을 사용하여 로깅을 위한 Logger 객체를 자동으로 생성
//클래스에 Annotation 추가 (@RequiredArgsConstructor) ppt 15

@Slf4j
@RequiredArgsConstructor
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
    // AuthenticationManager는 사용자가 제공한 인증 정보 (아이디와 비밀번호 등)를 이용해 인증을 시도하고 인증 성공시 인증 정보를 담은 
	//Authentication 객체를 생성하는 역할을 한다
	private final AuthenticationManager authenticationManager; // = null
	private final MemberRepository memRepo; //유저가 틀렸을때 추가코드로 memRepo를 쓰기위해서. 이거 활성화하면 SecurityConfig도 추가해야.
	// final은 초기화를 해줘야돼. 처음 실행할때 얘 뭔지 알아야 될거 아냐~
	// @RequiredArgsConstructor 이거 쓰면 뒤에서 생성자로 초기화 값 받는다.
	// 이거 안하면 여기서 = 어쩌구 값으로 초기화를 해줘야돼.
	
	
	// attemptAuthentication 메소드는 로그인을 시도할 때 실행되는 메소드. 이 메소드에서는 사용자의 인증을 시도.
	// 로그인 인증 시도를 위한 메소드 오버라이딩
	@Override// 아래꺼 그냥 콘트롤 + 스페이스 해서 자동완성.
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
	throws AuthenticationException{
		// ObjectMapper를 사용하여 JSON 형식의 요청 데이터를 Member 객체로 변환하고 있습니다.
		ObjectMapper om = new ObjectMapper();
		try {			
			//request.getInputStream()에서 직접 읽어서 객체를 만들어도 된다. 자신감을 갖고 해보장
			Member member = om.readValue(request.getInputStream(), Member.class);
			
			
			// ------ 유저가 틀렸을때. 추가코드---------
			Optional<Member> option = memRepo.findById(member.getUsername());
			if(!option.isPresent()) {
				
				log.info("Not Authenticated : Not found user!");
				return null;
			}
			
			//----------------------------------
			//보안을 위해서, 로그인시 뭐가 틀렸는지 안알려 주는데 굳이 아이디가 틀린지, 패스워드가 틀렸는지
			//구분해주려고 추가한 코드			
			Authentication authToken = new UsernamePasswordAuthenticationToken(member.getUsername(),member.getPassword()); //Member 클래스의 메소드. 사용자가 입력한 사용자명, 비번 가져옴.
			Authentication auth = authenticationManager.authenticate(authToken);
			//UserDetails - loadUserbyUsername 메소드에서 DB 검색후 리턴되어 온 객체를
			//session의 Authentication에 등록한다.
			
			//위 두줄은 로그인 시도에 사용되는 사용자의 인증 정보를 생성하고 인증과정을 수행하는 역할.
			//첫줄은 UsernamePasswordAuthenticationToken 객체를 생성, 이 객체는 Authentication 인터페이스가 구현된것
			//Authentication 이건 사용자의 인증정보를 나타낸다.
			//UsernamePasswordAuthenticationToken 의 생성자에 사용자명과 비밀번호를 인자로 넘겨주어 생성하니까
			// 이 authToken 객체는 사용자의 인증 정보를 담고 있게된다.
			
			//두번째줄은 AuthenticationManager의 authenticate 메소드를 호출해서 인증을 수행한다. 이 메소드에 authToken을 인자로 넘겨주면
			//AuthenticationManager는 이 인증정보를 바탕으로 사용자의 인증 과정을 수행한다.
			//authenticate 메소드는 인증에 성공하면 Authentication 객체를 반환하고, 인증에 실패하면 AuthenticationException을 던진다.
			// 즉 이 두줄은 따라서, 이 두 줄의 코드는 사용자가 입력한 사용자명과 비밀번호를 바탕으로 인증 토큰을 생성하고, 이를 사용하여 사용자의 인증을 수행하는 역할을 합니다.
			log.info("Authenticated:["+member.getUsername()+"]");		
			// 로그를 이용해 어떤 사용자가 인증을 시도하는지를 출력합니다.
			return auth;
		}catch (Exception e) {
			//log.info("Not Authenticated: "+e.getMessage());
			log.info("Not Authenticated : Not Match password!");
			//이것도 굳이 패스워드가 잘못됐다고 알려줄라고. 원래 보안상 안한다.
			
		}
		//return super.attemptAuthentication(request, response);	
		return null;
		// super.attemptAuthentication(request, response) 호출로 원래 UsernamePasswordAuthenticationFilter에서 제공하는 인증 절차를 수행해야 하는데 
        // 하지만 여기선 이를 호출하지 않고 null을 반환.
	}
	
	@Override //로그인에 성공하면 얘로 온다. 세션에 Authentication 객체 만들어지고 users 가 저장되어있다.	
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, 
			Authentication authResult) throws IOException, ServletException{
		// JWT 토큰을 만들어서 response의 헤더에 등록한다.
		// JWT 토큰을 생성하고 응답 헤더에 등록하는 코드
      
		User user = (User)authResult.getPrincipal();
		log.info("successfulAuthentication:" + user.toString());
		
		//JWT 생성
		String jwtToken = JWT.create()
				.withClaim("username",user.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis()+1000*60*10))
				.sign(Algorithm.HMAC256("edu.pnu.jwtkey"));
		
		//응답 헤더에 "Authorization"이라는 키를 추가해서 JWT를 설정
		//Bearer : JWT임을 나타내는 약속된 용어.
		//Basic:Basic "+Base64(username:password)
		// JWT 토큰을 만들어서 response의 헤더에 등록한다.
		response.addHeader("Authorization", "Bearer " + jwtToken);
		chain.doFilter(request, response);
		//super.successfulAuthentication(request, response, chain, authResult);
		 // super.successfulAuthentication(request, response, chain, authResult) 호출로 원래 UsernamePasswordAuthenticationFilter에서 제공하는 로그인 성공 후의 동작을 수행.
	}
}
