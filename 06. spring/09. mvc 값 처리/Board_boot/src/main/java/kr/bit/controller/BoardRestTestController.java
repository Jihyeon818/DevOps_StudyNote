package kr.bit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.bit.entity.Board;
import kr.bit.mapper.BoardMapper;

@RequestMapping("/board")
@RestController
public class BoardRestTestController {

	@Autowired
	BoardMapper boardMapper;
	
	@GetMapping("/list")
	public @ResponseBody List<Board> boardList(){
		List<Board> list=boardMapper.getLists(); //xml파일에 있는 id가 getLists인 쿼리문 실행
		return list; //json 데이터 형식으로 변환해서 리턴하겠다
	}
	
	@PostMapping("/create")
	public void boardInsert(@RequestBody Board vo){ //반환형은 BoardMapper.java 참고
		boardMapper.boardInsert(vo); //Board 객체에 넣음
	}
	
	//post, get, delete(삭제), put(업데이트)
	@DeleteMapping("/{idx}")
	public void boardDelete(@PathVariable("idx") int idx) {
		boardMapper.boardDelete(idx);
	}
	
	@PutMapping("/update")
	public void boardUpdate(@RequestBody Board vo) {
		boardMapper.boardUpdate(vo);
	}
	
	@GetMapping("/{idx}")
	public Board boardContent(@PathVariable("idx") int idx) {
		Board vo = boardMapper.boardContent(idx);
		return vo;
	}
	
	@PutMapping("/count/{idx}")
	public Board boardCount(@PathVariable("idx") int idx) {
	    boardMapper.boardCount(idx);
	    Board vo = boardMapper.boardContent(idx);
	    return vo;
	}
}
