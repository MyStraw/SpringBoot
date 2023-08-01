package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;
@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepo;
	 
	public List<Board> list() {		
		return boardRepo.findAll();
	}
	
	@PreAuthorize("hasAnyRole('MANAGER', 'ADMIN')")
	public Board create(Board board) {		
		return boardRepo.save(board);
	}

	 @PreAuthorize("hasAnyRole('MANAGER', 'ADMIN')")
	public Board update(Integer id, Board board) {
		Board updateboard = boardRepo.findById(id).orElseThrow(); // 예외 처리 필요
		updateboard.setTitle(board.getTitle());
		updateboard.setAuthor(board.getAuthor());
		updateboard.setContent(board.getContent());       
        return boardRepo.save(updateboard);		
	}

	@PreAuthorize("hasRole('ADMIN')")
	public void delete(Integer id) {
		boardRepo.deleteById(id);
	}

}
