package edu.pnu.config.auth;

import java.io.IOException;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//JWT 토큰을 이용해 인증된 사용자의 정보를 읽고 이에 기반으로 인증 과정을 수행하는 클래스
//HTTP 요청을 필터링해 인증토큰이 존재할경우 해당 토큰을 이용해 인증정보를 불러오고 이를 스프링 시큐리티의
//SecurityContext에 등록. 이를 통해 후에 오는 요청에서는 SecurityContext를 통해 사용자 인증 정보를 쉽게 엑세스


public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
	// 사용자 정보를 읽기 위한 인터페이스 추가
	private MemberRepository memRepo;
	
	//생성자는 부모 클래스가 AuthenticationManager 객체를 요구한다.
	// 생성자는 AuthenticationManager와 MemberRepository를 파라미터로 요구

	public JWTAuthorizationFilter(AuthenticationManager authenticationManager, MemberRepository memRepo) {
		super(authenticationManager);
		this.memRepo = memRepo;
	}//AuthenticationManager와 MemberRepository 를 파라미터로 받아서 초기화. 이렇게 받은 MemberRepository는 필터링 과정에서
	//사용자 정보를 데이터베이스에서 조회하는데 이용됨.
	
	

	// 필터링 메서드를 오버라이드한다. doFilterInternal 메소드는 HTTP 요청을 필터링하는 메소드, 각 요청이 처리되기 전에 실행
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String srcToken = request.getHeader("Authorization");
		if (srcToken == null || !srcToken.startsWith("Bearer ")) {
			chain.doFilter(request, response);
			return;
		}
		//요청 헤더에서 "Authorization"이라는 이름의 값을 읽어온다. 
		//이 값이 존재하고 "Bearer "로 시작한다면 JWT 토큰이 있는 것으로 간주한다. 그렇지 않은 경우, 인증 없이 요청을 계속
		
		
		
		
		String jwtToken = srcToken.replace("Bearer ", ""); //"Bearer " 문자열을 제거하여 순수한 JWT 토큰만을 얻고, 이를 디코딩하여 "username" claim을 추출합니다.
		String username = JWT.require(Algorithm.HMAC256("edu.pnu.jwtkey")).build().verify(jwtToken).getClaim("username")
				.asString();
		// 토큰에서 얻은 username으로 DB를 검색해서 사용자를 찾고
		//JWT(json web token)는 페이로드(Payload)라고 불리는 데이터 부분에 여러가지 정보(클레임, 주장하는 정보?, JWT토큰이 담고있는 정보)를 담을수있다.
		//클레임은 JWT의 데이터를 나타내는 부분을 일컫고, 이는 추가적인 정보를 제공하거나 토큰이 어떠헥 적용되어야 하는지에 대한 세부정보를 제공
		
		//getClaim()메소드는 이 클레임의 값을 조회하는 메소드.


		Optional<Member> opt = memRepo.findById(username); //username을 이용하여 MemberRepository에서 Member 정보를 조회.
		if (!opt.isPresent()) {
			chain.doFilter(request, response);
			return;
		}
		
		
		
		Member findmember = opt.get(); // DB에서 읽은 사용자 정보를 이용해서 UserDetails 타입의 객체를 만들어서		
		User user = new User(findmember.getUsername(), findmember.getPassword(), findmember.getAuthorities());
		// Authentication 객체를 생성 : 사용자명과 권한 관리를 위한 정보를 입력(암호는 필요없음)

		Authentication auth = new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
		// 시큐리티 세션에 등록한다.
		//조회된 Member 정보를 기반으로 User 객체를 생성하고, 이를 이용해 UsernamePasswordAuthenticationToken 인증 객체를 만든다. 
		
		SecurityContextHolder.getContext().setAuthentication(auth);//이 인증 객체를 SecurityContextHolder에 설정하여 인증 정보를 유지하게 됨. 이후 요청 처리를 계속 진행.
		chain.doFilter(request, response);
		
		//SecurityContext는 보안관련정보, 특히 인증된 사용자에 대한 세부정보를 담고있는 객체.
		//SecurityContext 내부에는 Authentication 객체가 포함되어 있고 이 객체는 현재 인증된 사용자에 대한 정보를 포함한다
		//SecurityContextHolder는 SecurityContext의 인스턴스를 제공하는데 이걸 통해 현재 인증된 사용자의 세부 정보를 얻거나, 인증된 사용자를 변경할 수 있다. 
		//이는 일반적으로 사용자의 인증 상태를 확인하거나 변경하는 데 사용

	}
}
