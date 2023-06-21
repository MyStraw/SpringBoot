package edu.pnu.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@RestController
public class BoardController {

	@Autowired
	BoardRepository boardRepo;

	@GetMapping("/getBoardLists")
	public List<Board> getBoardLists() {
		return boardRepo.findAll();
	}

	// Create
	@PostMapping("/board")
//	public Board insertBoard(String title, String content, String writer) {
//  이렇게 파라미터로 해도 되는데 board 객체 이용하는게 더 편하징
	public Board insertBoard(Board board) {
		if(board.getCreateDate() == null)
			board.setCreateDate(new Date());
		return boardRepo.save(board);
	}	

	
	@PostMapping("/boardjson")
	public Board insertJsonBoard(@RequestBody Board board) {
		if(board.getCreateDate() == null)
			board.setCreateDate(new Date());
		return boardRepo.save(board);
	}

	// Read
	@GetMapping("/board")
	public Board getBoard(Long id) {
		return boardRepo.findById(id).get();
	}

	// Update
	@PutMapping("/board")
	public Board updateBoard(Board board) {
		return boardRepo.save(board);
	}

	// Delete
	@DeleteMapping("/deleteBoardList")
	public String deleteBoard(Long id) {
		boardRepo.deleteById(id);
		return String.format("seq가 %d인 데이터가 삭제되었습니다.", id);
	}
	
//	//title에 "1"이 포함되는 데이터 출력
//	@GetMapping("/board2")
//	public  List<Board> findBoard(String title) {		
//		return boardRepo.findByTitleLike("%"+title+"%"); //like 뒤에 와야할 글자를 그대로 쳐줭	
//	}
	
	@GetMapping("/board3")
	public  List<Board> findBoardCnt(String title, Long cnt) {		
		return boardRepo.findByTitleLikeAndCntGreaterThan("%"+title+"%", cnt); //like 뒤에 와야할 글자를 그대로 쳐줭			
	}	
	
	@GetMapping("/findbytitlelike")
	public  List<Board> findByTitleLike(String title) {	
		Pageable page = PageRequest.of(0, 5); //5개로 분할해서 0번째꺼, 페이징 기능
		return boardRepo.findByTitleLike("%"+title+"%", page); //like 뒤에 와야할 글자를 그대로 쳐줭	
	}
	
	@GetMapping("/findpage")
	public  List<Board> findPage(@Param("pm")Integer pagenum, Integer size) {	
		Pageable paging = PageRequest.of(pagenum, size);
		Page<Board> page = boardRepo.findAll(paging);		
		return page.getContent();
	}
	
//	@GetMapping("/findpage")
//	public  List<Board> findPage(Integer pagenum, Integer size) {	
//		Pageable paging = PageRequest.of(pagenum, size);
//		Page<Board> page = boardRepo.findAll(paging);		
//		return page.getContent();
//	}
	
}
