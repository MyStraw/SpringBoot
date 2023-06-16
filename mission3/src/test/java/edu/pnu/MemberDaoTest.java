package edu.pnu;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation; //이걸 임포트 해야된다.
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.dao.MemberDaoListImpl;
import edu.pnu.dao.MemberInterface;
import edu.pnu.domain.MemberVO;
//Chapter03에서 쓴거 그대로 베껴왔네. 나만의 걸로 다시 만들어야해.

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class) //메소드 오더다. 클래스 오더말고 이거 택해

public class MemberDaoTest {

		
//@BeforeEach 
//테스트는 앞뒤 순서가 없는데 우리가 순서를 준게 오더링.
//리스트에 올리는건 매번 테스트 초기화가 된다. 그래서 오더1에 추가를 해도
//밑에서 계속 초기화돼서 이거 삽입이 안된것처럼 콘솔에 뜬다.
//그럼 order을 무조건 해주려면
//이때 @BeforeEach를 쓰면 무조건 이걸 실행한다
//order(2)를 해도 무조건 @BeforeEach가 붙은걸 한번 실행하고 한다.
//끝나고 무조건 실행하는건 @AfterEach
	
	@Test
	@Order(1)	
	public void insertMemberTest() {
		MemberInterface memberInterface = new MemberDaoListImpl();

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
			memberInterface.addMember(new MemberVO(-1L, "name" + i, 20 + i, "nickname" + i));
			//insert 할때 의미없는 데이터, 사용 안하니까 -1 넣었다. 100 넣어도 된다. id는 어차피 오토 인크리먼트
		}
	}
	
	
	@Test
	@Order(2) //시스템 환경에 따라서 순서가 달라진다. 이 순서를 없이 하면 위에꺼가 먼저 안되고 이게 먼저 될수가 있다.
	//위에서 데이터를 입력을 해야 지금 여기서 읽을수가 있는데, 순서가 지맘대로라서 이게 먼저 실행되면 아무것도 안읽히겠지.
	//그래서 맨위에 @TestMethodOrder(OrderAnnotation.class) 이걸로 메소드 순서를 정해
	public void selectAllMemberTest() {
		MemberInterface memberDao = new MemberDaoListImpl();		
		List<MemberVO> list = memberDao.getMembers();
		for(MemberVO m : list) {
			System.out.println(m);
		}
	}	

}
