package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Board;
import edu.pnu.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/create")
    public Board create(@RequestBody Board board) { //Board board가 이미 받아온 json이다. Board 타입의 board 객체. 
    	//Requestbody가 client에서 보내온 json 정보이다. 
        return boardService.create(board);
    }

    @GetMapping("/list")
    public List<Board> list() {
        return boardService.list();
    }

    @PutMapping("/update/{id}")
    public Board update(@PathVariable Integer id, @RequestBody Board board) {
        return boardService.update(id, board);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        boardService.delete(id);
        return "게시글 삭제 성공";
    }
}


