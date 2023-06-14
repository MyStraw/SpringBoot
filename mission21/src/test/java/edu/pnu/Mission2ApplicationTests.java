package edu.pnu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Member;
import edu.pnu.service.MemberService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class Mission2ApplicationTests {

	@Autowired
	MemberService memberService;

	@Autowired
	DataSource dataSource;

	@Test
	public void dataSourceTest() throws SQLException {
		Statement stmt = dataSource.getConnection().createStatement();
		ResultSet rs = stmt.executeQuery("select * from Member");
		while (rs.next()) {
		}
	}
	

	@Test
	@Order(1)
	public void contextLoad1() {
		List<Member> list = memberService.getMembers();
		for (Member m : list) {
			System.out.println(m);
		}
		System.out.println("=".repeat(40));
	}

	@Test
	@Order(2)
	public void contextLoad2() {
		System.out.println("=".repeat(40));
		Member m = memberService.getMember(4L);
		System.out.println(m);
		System.out.println("=".repeat(40));
	}

	@Test
	@Order(3)
	public void contextLoad3() {
		System.out.println("=".repeat(40));
		System.out.println(memberService.insertMember(new Member(9L, "pass9", "name9", new Date())));
		List<Member> list = memberService.getMembers();
		for (Member m : list) {
			System.out.println(m);
		}
		System.out.println("=".repeat(40));
	}

}
