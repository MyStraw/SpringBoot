package edu.pnu.persistence;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.pnu.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	// <T, ID>T는 엔티티 네임. 유저, ID는 ID타입을 기입

//	List<Board> findByTitleLike(String title);

	List<Board> findByTitleLikeAndCntGreaterThan(String title, Long cnt);

	List<Board> findByCntBetweenOrderBySeqAsc(Long less, Long Greater);

	List<Board> findByTitleLikeOrContentLikeOrderBySeqDesc(String title, String content);

	List<Board> findByTitleLike(String title, Pageable paging); // 페이징 된 데이터를 받아온다.

	Page<Board> findAll(Pageable paging);
	
	//위치기반
	@Query("select b from Board b where b.title like %?1% order by b.seq DESC")
	List<Board> queryAnnotationTest1(String searchKeyword); //소스를 만들어 준다. 위 쿼리를 기반으로.
	
	//이름기반	
	@Query("select b from Board b where b.title like %:searchKeyword% order by b.seq desc")
	List<Board> queryAnnotationTest2(String searchKeyword);
	
//	@Query("select b from Board b where b.title like %:searchTitleKeyword%"
//			+ "and b.writer like %:searchWriterKeyword% order by b.seq desc")
//	List<Board> queryAnnotationTest2(String searchKeyword, String searchWriterKeyword);
	
	//이름기반 파람 사용. 파라미터 명 바꾸기
//	@Query("select b from Board b where b.title like %:skw% order by b.seq desc")
//	List<Board> queryAnnotationTest2(@Param("skw")String searchKeyword);
	
	//특정변수 조회
	@Query("Select b.seq, b.title, b.writer, b.createDate from Board b "
			+ "where b.title like %:searchKeyword% order by b.seq desc")
	List<Object[]> queryAnnotationTest3(String searchKeyword);
	
	//네이티브 쿼리 사용하기
	@Query(value = "select seq, title, writer, create_Date "
			+ "from board where title like '%'||:sk||'%' "
			+ "order by seq desc", nativeQuery = true)
	List<Object[]> queryAnnotationTest4(@Param("sk") String searchKeyword);
	
	//페이징 이용
	@Query("select b from Board b order by b.seq asc") //
//	@Query("select b from Board b")
	List<Board> queryAnnotationTest5(Pageable paging);
	//보드 클래스 데이터 b를 가져오는데 테이블 데이터 전부 다 가져오는데 b.seq로 정렬해서 가져옴.
	//Pageable 객체 하나를 밷아오네. 컨트롤 클릭 해봐. 인터페이스네.
	
}
