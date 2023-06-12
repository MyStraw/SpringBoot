package edu.pnu;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation; //이걸 임포트 해야된다.
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.Member;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class) //메소드 오더다. 클래스 오더말고 이거 택해

public class MemberDaoTest {

		
	
	@Test
	@Order(1)	
	public void insertMemberTest() {
		MemberDao memberDao = new MemberDao();

		for (int i = 1; i <= 10; i++) {
			//Builder를 이용한 방법
//			memberDao.insertMember(
//					Member.builder().name("name" + i).age(20 + i).nickname("nickname" + i).build());

			//기본 생성자를 이용한 방법 @NoArgsConstructor
//			Member m = new Member();
//			m.setName("name" + i);
//			m.setAge(20 + i);
//			m.setName("nickname" + i);
//			memberDao.insertMember(m);

			//파라미터가 필요한 생성자를 이용한 방법. @AllArgsConstructor
			memberDao.insertMember(new Member(-1L, "name" + i, 20 + i, "nickname" + i));
			//insert 할때 의미없는 데이터, 사용 안하니까 -1 넣었다. 100 넣어도 된다. id는 어차피 오토 인크리먼트
		}
	}
	
	
	@Test
	@Order(2) //시스템 환경에 따라서 순서가 달라진다. 이 순서를 없이 하면 위에꺼가 먼저 안되고 이게 먼저 될수가 있다.
	//위에서 데이터를 입력을 해야 지금 여기서 읽을수가 있는데, 순서가 지맘대로라서 이게 먼저 실행되면 아무것도 안읽히겠지.
	//그래서 맨위에 @TestMethodOrder(OrderAnnotation.class) 이걸로 메소드 순서를 정해
	public void selectAllMemberTest() {
		MemberDao memberDao = new MemberDao();		
		List<Member> list = memberDao.getMembers();
		for(Member m : list) {
			System.out.println(m);
		}
	}	

}
