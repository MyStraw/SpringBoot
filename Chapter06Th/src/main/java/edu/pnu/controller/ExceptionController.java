package edu.pnu.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pnu.exception.BoardNotFoundException;
import edu.pnu.exception.UsernameNotFoundException;

@Controller
public class ExceptionController {

	
	@RequestMapping("/boardError") //리퀘스트니까 겟이든 포스트든 풋이든 뭐든 다 받아
	public String boardError() {
		throw new BoardNotFoundException("검색된 게시글이 없습니다.");
		
	}
	
	@RequestMapping("/illegalArgumentError") //리퀘스트니까 겟이든 포스트든 풋이든 뭐든 다 받아
	public String illegalArgumentError() {
		throw new IllegalArgumentException("부적절한 인자가 전달되었습니다.");
		
	}
	@RequestMapping("/sqlError") //리퀘스트니까 겟이든 포스트든 풋이든 뭐든 다 받아
	public String sqlError() throws SQLException {
		throw new SQLException("SQL 구문에 오류가 있습니다.");
		
	}
	
	@RequestMapping("/loginError") //리퀘스트니까 겟이든 포스트든 풋이든 뭐든 다 받아
	public String usernameNotFoundException() throws UsernameNotFoundException {
		throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");		
	}
	
}
