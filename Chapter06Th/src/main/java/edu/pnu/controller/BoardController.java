package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.service.BoardService;

@SessionAttributes("member") // 세션에다가 멤버라는 키 이름의 저장소 만들겠다.("member", null) 밸류는 null이고.
@Controller
//@RequestMapping("/api") 이거 넣으면 localhost:8080/api/login 순서로 된다. 공통적인거 이렇게 하나만 적으면
//밑에 하위 주소가 다 달라붙어.
public class BoardController {

	@ModelAttribute("member")
	public Member setMember() {
		return new Member(); // 아무도 없으면 redirect로. 로그인창으로 돌아가게 해주는거.
		// 로그인 컨트롤러에서 model.addAttribute("member", findMember); 여기서 세션에 사용자 저장한다.
		// 빈 객체 만들어 리턴. 안에 데이터 아무것도 안들어 있는 인스턴스가 하나 들어간다.
		// ("member", m(빈객체)) //빈걸 왜? 왜 필요하나?
		// 아래
	} // 골뱅이 모델 어트리뷰트. 세션에 저장되어있는 멤버객체를 저기다 넣어준다.
		// null이면 저기서 에러가 난다.

	@RequestMapping("/getBoardList") // post 호출이든 get이든 상관없이. 둘다 다됨.
	public String getBoardList(@ModelAttribute("member") Member member/* 저기 */, Model model, Board board) {
		if (member.getId() == null) {
			return "redirect:login";
		}
//		List<Board> boardList = boardService.getBoardList(board);
		model.addAttribute("boardList", boardService.getBoardList());
		return "getBoardList";
	}

//	@RequestMapping("/getBoardList")
//	public String getBoardList(Model model) {
//		List<Board> boardList = new ArrayList<>();		
//		for (int i = 1; i <= 10 ; i++) {
//			boardList.add(Board.builder()
//					.seq((long)i)
//					.title("title" +i)
//					.writer("writer"+i)
//					.content("content"+i)
//					.createDate(new Date())
//					.cnt(0L).build());
//		}
//		model.addAttribute("boardList", boardList);	 //키값, 밸류값. 키값을 getBoardList.jsp에서 받으니까. 키값통일	
//		return "getBoardList"; //보드에 담에서 뷰 이름에 리턴
//	}

	@Autowired
	private BoardService boardService;

//	@GetMapping("/getBoardList") // 위에는 임의로 우리가 데이터를 만들었고.
//	public String getBoardList(Model model) { // 서비스 객체로부터 데이터를 받아서 모델에다가 담아두는거
//		model.addAttribute("boardList", boardService.getBoardList());
//		boardService.getBoardList();
//		return "getBoardList"; // 서비스에서 findAll로 다 가져와서. 이건 DB에서 100개 가져오겠지. 페이져블도 해봐.
//	}

	@GetMapping("/insertBoard") // post 안쓰고 일반적으로 쓰는거 쓴다. post 해도돼
	public String insertBoard(@ModelAttribute("member") Member member) {
		if (member.getId() == null) {
			return "redirect:login";
		}
		return "insertBoard"; // insertBoard.jsp를 호출하라고 했다. insertBoard.jsp 가봐. 뷰로 호출.
	}

	@PostMapping("/insertBoard")
	public String insertBoardPost(@ModelAttribute("member") Member member, Board board) {
		if (member.getId() == null) {
			return "redirect:login";
		}

		boardService.insertBoard(board);
		return "redirect:getBoardList"; // 리다이렉트 안해주면 default가 foward url조차 바꿀라고. url에 insertBoard가 그대로 뜸.
	} // insertBoard가 url인 그대로에 새글등록하면 원래 getBoardlist 화면이 나온다. url 안바뀌고. url 일치시켜주려고
		// 리다이렉트.

	@GetMapping("/getBoard") // getBoard?seq=1 이부분이 넘어가는겨. 그냥 /getBoard 치면 당근 안되지 seq가 안넘어가는데.
	// public String getBoard(Board board) { //board.seq 1개 넘어오는거다.
	public String getBoard(@ModelAttribute("member") Member member, Long seq, Model model) { // 혹은 이렇게 seq 1개만 넘겨 받게끔 하면
																								// 된다.똑같다 위랑.
		if (member.getId() == null) {
			return "redirect:login";
		}

		Board board = boardService.getBoard(Board.builder().seq(seq).build());
		model.addAttribute("board", board);
		// jsp에선 ${board.seq} //EL표현식.
		return "getBoard"; // 이제 겟보드도 서비스
	}

	@PostMapping("/updateBoard")
	public String updateBoard(@ModelAttribute("member") Member member, Board board) {
		
		if (member.getId() == null) {
			return "redirect:login";
		}

		
		
		boardService.updateBoard(board);
		return "redirect:getBoardList"; // 이거 리다이렉트 해야
	}

	@GetMapping("/deleteBoard")
	public String deleteBoard(@ModelAttribute("member") Member member, Board board) {
		
		if (member.getId() == null) {
			return "redirect:login";
		}

		boardService.deleteBoard(board);
		return "forward:getBoardList";
	}
}
