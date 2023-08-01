package edu.pnu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;
@SpringBootTest
public class BoardInitialize {

	@Autowired
	BoardRepository boardRepo;

	@Test
	public void doWork() {
		boardRepo.save(Board.builder()
				.title("냐하하")
				.content("뇨호호호호호")
				.author("EMBER")
				.build());
	}

}