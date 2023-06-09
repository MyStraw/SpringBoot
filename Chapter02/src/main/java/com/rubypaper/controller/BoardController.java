package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.BoardVO;

@RestController // 이거 붙이면 스프링 부트에서 컨트롤 클래스에서 사용을 하겠다.
//RestController과 Controller이 있다. url쳐서 들어오면 컨트롤러
public class BoardController {

	public BoardController() {// 생성자 생성.
		System.out.println("=".repeat(50));
		System.out.println("BordController가 생성되었습니다.");
		System.out.println("=".repeat(50));
	}

	@GetMapping("/hello") // 겟 메서드에 hello url 호출되면 여기로 온다
	// 포스트 매핑도 있겠지?
	public @ResponseBody String hello(String name) { //콘트롤러를 굳이 써야한다면  @ResponseBody 이걸 써.
		return "Get Hello : " + name;
	}// 실행하니까 콘솔에 객체 생성되었다고 나오네. 난 객체 생성 안했는데? 부트가 알아서 만들었다. 그럼 이건 어딘가에 저장해놓고 쓰겠는데...
		// 어디?
		// 이때 컨테이너에 저장해놓는다. 객체를 자동으로 만들어서 쓰는 장소를 컨테이너라고 한다. => @RestController 때문에 가능.

	// 디스패쳐 서블렛이 도와준다. RestController 이 객체 넘겨주면 자동으로 제이슨 데이터로 넘어간다.
	// 컨트롤러와 레스트 컨트롤러 차이.
	// 그냥 @Controller를 쓰면 부트는 view의 이름으로 판단. view는 display 해주는. 템플릿과 연결.

	@PostMapping("/hello") // 포스트맨에서 실행
	public String hello2(String name) {
		return "Post Hello : " + name;
	}

	@PutMapping("/hello")
	public String hello3(String name) {
		return "Put Hello : " + name;
	}

	@DeleteMapping("/hello")
	public String hello4(String name) {
		return "Delete Hello : " + name;
	}

	@GetMapping("/getBoard")
	public BoardVO getBoard() {
		BoardVO board = new BoardVO();
		board.setSeq(1);
		board.setTitle("테스트 제목");
		board.setWriter("테스트");
		board.setContent("테스트 내용입니다...");
		board.setCreateDate(new Date());
		board.setCnt(0);
		return board; // 세터로 값 집어넣기
	}

	@GetMapping("/getBoard1")
	public BoardVO getBoard1() { // 생성자로 값 집어넣기. 위랑 아래랑 동일.
		BoardVO board = new BoardVO(
				1,				
				"테스트 제목",
				"테스트",
				"테스트 내용입니다...",
				new Date(),
				0);
		return board;
	}

	@GetMapping("/getBoard2")
	public BoardVO getBoard2() {
		return BoardVO.builder()
				.seq(1)
				.title("테스트 제목")
				.writer("테스트")
				.content("테스트 내용입니다...")
				.createDate(new Date())
				.cnt(0)
				.build();
	}

	@GetMapping("/getBoardList")
	public List<BoardVO> getBoardList() {
		List<BoardVO> boardlist = new ArrayList<BoardVO>();
		for (int i = 0; i < 10; i++) {
			BoardVO board = new BoardVO(
					i, 
					"테스트 제목", 
					"테스트", 
					"테스트 내용입니다...", 
					new Date(), 
					i);
			boardlist.add(board);
		}

		return boardlist;
	}
	
	@GetMapping("/getBoardList1")
	public List<BoardVO> getBoardList1() {
		List<BoardVO> boardlist = new ArrayList<BoardVO>();
		for (int i = 0; i < 10; i++) {			
			boardlist.add(BoardVO.builder()
					.seq(i)
					.title("테스트 제목")
					.writer("테스트")
					.content("테스트 내용입니다...")
					.createDate(new Date())
					.cnt(i)
					.build());
		}
		return boardlist;
	}
	
	@GetMapping("/board") // 포스트맨에서 실행
	public @ResponseBody BoardVO board(@RequestBody BoardVO b) { //들어온 데이터 바로 리턴
		b.setCreateDate(new Date());
		//b.setCnt(100);
		System.out.println("Board:" + b);
		return b;
	}

}
