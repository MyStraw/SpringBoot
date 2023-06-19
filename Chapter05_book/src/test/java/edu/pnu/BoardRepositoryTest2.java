package edu.pnu;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

//@Runwith 이건 사용 안한다 쓰지마.
@SpringBootTest
//@TestMethodOrder(OrderAnnotation.class)
class BoardRepositoryTest2 {

	@Autowired

	private BoardRepository boardRepo;

	@Test
	public void testByTitleLike(String title) {
		System.out.println("-".repeat(80));
		List<Board> list = boardRepo.findByTitleLike("1");
		System.out.println("타이틀이 1이 포함된 데이터 출력");
		for (Board b : list) {
			System.out.println(b);
		}
		System.out.println("-".repeat(80));
	}

}
