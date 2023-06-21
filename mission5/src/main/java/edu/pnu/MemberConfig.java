package edu.pnu;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.pnu.dao.LogDao;
import edu.pnu.dao.MemberDaoListImpl;
import edu.pnu.dao.MemberInterface;
import edu.pnu.service.MemberService;

@Configuration
public class MemberConfig {
	
	
	@Bean //이거하면 @Service, @Repository 같은걸 할필요가 없지.
	public MemberService memberService() {
		return new MemberService();
	}
	
	
//	@Bean //컨트롤러는 내가 작성하는건데, 자동설정을 받을 필요가 없잖아. 내가 짜는 코드인데. 내가 다뤄야하는데.
//	public MemberController memberController() {
//		return new MemberController();
//	}
	
	
	@Bean
	public MemberInterface memberInterface(DataSource dataSource) {
	//	return new MemberDaoH2Impl(dataSource);
		return new MemberDaoListImpl();
	}
	
	@Bean	
	public LogDao logDao() {
		return new LogDao();
	}
	
	
	
//	@Bean
//	public BCrypPasswordEncoder bCryptPasswordEncoder(){
//		return new 	BCrypPasswordEncoder();
//	}

}
