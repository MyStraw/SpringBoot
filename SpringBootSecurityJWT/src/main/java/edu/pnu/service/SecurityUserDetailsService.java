package edu.pnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;



//UserDetailsService 인터페이스를 구현한 SecurityUserDetailsService 
//UserDetailsService는 스프링 시큐리티에서 사용자 상세정보를 제공하는 방법을 지정하는 인터페이스임.
//이 서비스는 사용자가 로그인 할때 사용자명에 대한 상세 정보를 조회하는데 사용된다.

@Service //이 어노테이션은 이 클래스가 서비스 계층의 컴포넌트임을 스프링에게 알려주는 역할. 
//이 어노테이션을 이용해 스프링은 이 클래스를 관리하고 필요한 곳에 주입해줍니다.
public class SecurityUserDetailsService implements UserDetailsService {
	
	@Autowired //MemberRepository의 인스턴스를 주입받아 사용합니다.
	private MemberRepository memRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		//loadUserByUsername 메소드는 UserDetailsService 인터페이스의 메소드인거는 이제 알겠지? 
		//주어진 사용자명에 해당하는 사용자의 상세 정보를 조회한다. 이 메소드가 반환하는 UserDetails 인스턴스는 사용자의 인증 정보를 나타내준다
		Member member = memRepo.findById(username).orElseThrow(()-> new UsernameNotFoundException("Not Found!"));
		//findById 메소드를 사용해서 주어진 사용자명에 해당하는 Member객체를 조회한다. 만약 해당하는 Member 객체가 없으면 UsernameNotFoundException 던짐
				
		return new User(member.getUsername(), member.getPassword(), member.getAuthorities());
		//조회한 Member 객체의 사용자명, 비밀번호, 권한 정보를 이용해 User 객체를 생성하고 반환한다. 
		//User 클래스는 UserDetails 인터페이스의 구현체로, 사용자의 인증 정보를 나타낸다.
		//즉 사용자명에 해당하는 사용자의 인증 정보를 조회하여 반환하는 서비스를 제공하는 클래스. 
		//이 정보는 스프링 시큐리티에서 로그인 인증을 처리하는 데 사용되겠네		
	}
	

}
