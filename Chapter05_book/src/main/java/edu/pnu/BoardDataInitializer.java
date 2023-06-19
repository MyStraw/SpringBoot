package edu.pnu;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@Component // 이걸 해줘야 실행이 된다.
public class BoardDataInitializer implements ApplicationRunner {

	@Autowired
	BoardRepository boardRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Random rnd = new Random();
			for (int i = 0; i < 100; i++) {
				boardRepo.save(Board.builder()
						.title("title" + i)
						.writer("writer" + i)
						.content("content" + i)
						.createDate(new Date())
						.cnt(rnd.nextLong(0, 101))
								.build());
			}		

	}
}
