package edu.pnu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;

@SpringBootTest //스프링부트 테스트를 위한 설정 제공. 실제 환경과 동일하게 테스트
public class MemberInitialize {
	@Autowired //MemberRepository 타입의 memRepo필드에 빈 주입
	MemberRepository memRepo;
	
	@Autowired
	//PasswordEncoder encoder = new BCryptPasswordEncoder();
	//패스워드 인코더 인터페이스의 인스턴스 생성.
	PasswordEncoder encoder;
	
	
	@Test //Junit 테스트 프레임워크에서 테스트 메소드임을 표시. 여기서 doWord가 테스트 되는 메소드
	public void doWork() { //세개의 Member 엔티티를 생성. 이를 데이터베이스에 save(). build()통해 생성.
		memRepo.save(Member.builder()
				.username("member")
				.password(encoder.encode("abcd"))
				.role("ROLE_MEMBER") //각각의 역할 부여
				.enabled(true).build()); //활성화됨
		memRepo.save(Member.builder()
				.username("manager")
				.password(encoder.encode("abcd"))
				.role("ROLE_MANAGER")
				.enabled(true).build());
		memRepo.save(Member.builder()
				.username("admin")
				.password(encoder.encode("abcd"))
				.role("ROLE_ADMIN")
				.enabled(true).build());
		
	}

}
