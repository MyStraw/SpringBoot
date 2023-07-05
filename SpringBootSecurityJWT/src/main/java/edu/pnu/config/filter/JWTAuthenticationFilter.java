package edu.pnu.config.filter;

import java.io.IOException;
import java.sql.Date;
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


@Slf4j
@RequiredArgsConstructor
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private final AuthenticationManager authenticationManager;
	private final MemberRepository memRepo;
	// final은 초기화를 해줘야돼. 처음 실행할때 얘 뭔지 알아야 될거 아냐~
	// @RequiredArgsConstructor 이거 쓰면 뒤에서 생성자로 초기화 값 받는다.
	// 이거 안하면 여기서 = 어쩌구 값으로 초기화를 해줘야돼.
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
	throws AuthenticationException{
		
		ObjectMapper om = new ObjectMapper();
		try {			
			Member member = om.readValue(request.getInputStream(), Member.class);
			
			
			// ------ 유저가 틀렸을때. 추가코드---------
			Optional<Member> option = memRepo.findById(member.getUsername());
			if(!option.isPresent()) {
				log.info("Not Authenticated : Not found user!");
				return null;
			}//----------------------------------
			//보안을 위해서, 로그인시 뭐가 틀렸는지 안알려 주는데 굳이 아이디가 틀린지, 패스워드가 틀렸는지
			//구분해주려고 추가한 코드
			
			Authentication authToken = new UsernamePasswordAuthenticationToken(member.getUsername(),member.getPassword());
			Authentication auth = authenticationManager.authenticate(authToken);
			log.info("Authenticated:["+member.getUsername()+"]");		
			return auth;
		}catch (Exception e) {
			//log.info("Not Authenticated: "+e.getMessage());
			log.info("Not Authenticated : Not Match password!");
			//이것도 굳이 패스워드가 잘못됐다고 알려줄라고. 원래 보안상 안한다.
		}
		return null;
	}
	
	@Override //로그인에 성공하면 얘로 온다. 세션에 authen 객체 만들어지고 users 가 저장되어있다.	
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, 
			Authentication authResult) throws IOException, ServletException{
		
		User user = (User)authResult.getPrincipal();
		log.info("successfulAuthentication:" + user.toString());
		
		//JWT 생성
		String jwtToken = JWT.create()
				.withClaim("username",user.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis()+1000*60*10))
				.sign(Algorithm.HMAC256("edu.pnu.jwtkey"));
		
		//응답 헤더에 "Authorization"이라는 키를 추가해서 JWT를 설정
		//Bearer : JWT임을 나타내는 약속된 용어.
		
		response.addHeader("Authorization", "Bearer " + jwtToken);
		chain.doFilter(request, response);
	}
}
