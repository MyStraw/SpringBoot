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
class BoardRepositoryTest {

	@Autowired

	private BoardRepository boardRepo;

//	@Test	
//	void contextLoads() {
//		Board board = new Board();
//		board.setTitle("첫 번째 게시글");
//		board.setWriter("테스터");
//		board.setContent("잘 등록되나요?");
//		board.setCreateDate(new Date());
//		board.setCnt(0L);
//
//		boardRepo.save(board);
//	}

//	@Test
//	void testInsertBoard() {
//		for (int i = 0; i < 10; i++) {
//			boardRepo.save(Board.builder()
//					.title("title" + i)
//					.writer("writer" + i)
//					.content("content" + i)
//					.createDate(new Date())
//					.cnt(0L).build());
//		}
//	}

	@Test
	public void testGetBoard() {

//		Optional<Board> opt = boardRepo.findById(1L); //findById 옵셔널이 get
//		Board board = opt.get(); 이거 두줄이 아래 한줄.
//		
		Board board = boardRepo.findById(1L).get(); // 1행 검색
		System.out.println(board);
	}

	@Test
	public void testUpdateBoard() {
		{
			Board board = boardRepo.findById(1L).get();
			System.out.println("수정전");
			System.out.println(board);

			board.setTitle("제목 수정");
			boardRepo.save(board);

		}
		{
			Board board = boardRepo.findById(1L).get();
			System.out.println("수정 후");
			System.out.println(board);
		}
	}

//	@Test
//	public void testDeleteBoard() {
//		boardRepo.deleteById(2L); //테이블 2행 삭제
//	}

	@Test
	public void testFindAll() {
		List<Board> list = boardRepo.findAll(); // findAll(); 까지만 하면 얘가 뭔가 리턴해줘야 할게 있는데 어떻게? 마우스 얹져봐.
		System.out.println("-------------------------------");
		System.out.println("모든 데이터를 출력합니다.");
		for (Board b : list) {
			System.out.println(b);
		}

	}
	
	

}
