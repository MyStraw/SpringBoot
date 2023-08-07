package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;
@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepo;
	
	 
	public List<Board> list() {		
		return boardRepo.findAll();
	}	
	
	public List<Board> listStationCode(int stationcode){
		return boardRepo.findBystationcode(stationcode);		
	}	
	
	
	public Board create(String authorizationHeader, Board board) {	
		String jwtToken = authorizationHeader.replace("Bearer ", "");
		String username = JWT.require(Algorithm.HMAC256("edu.pnu.jwtkey")).build().verify(jwtToken).getClaim("username")
				.asString();		
		board.setAuthor(username);		
		return boardRepo.save(board);
	}
	 
	public Board update(Integer id, Board board) {
		Board updateboard = boardRepo.findById(id).orElseThrow(); // 예외 처리 필요
		updateboard.setTitle(board.getTitle());		
		updateboard.setContent(board.getContent());       
        return boardRepo.save(updateboard);		
	}
	
	public void delete(Integer id) {
		boardRepo.deleteById(id);
	}
}
