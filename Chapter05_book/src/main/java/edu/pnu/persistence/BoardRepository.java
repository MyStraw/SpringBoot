package edu.pnu.persistence;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	// T는 엔티티 네임. 유저, ID는 ID타입

//	List<Board> findByTitleLike(String title);

	List<Board> findByTitleLikeAndCntGreaterThan(String title, Long cnt);

	List<Board> findByCntBetweenOrderBySeqAsc(Long less, Long Greater);

	List<Board> findByTitleLikeOrContentLikeOrderBySeqDesc(String title, String content);

	List<Board> findByTitleLike(String title, Pageable paging); // 페이징 된 데이터를 받아온다.

	Page<Board> findAll(Pageable paging);
}
