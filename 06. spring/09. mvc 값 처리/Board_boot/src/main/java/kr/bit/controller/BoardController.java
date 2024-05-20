package kr.bit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.bit.entity.Board;
import kr.bit.mapper.BoardMapper;

@Controller
public class BoardController {

	@Autowired
	BoardMapper boardMapper;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/boardList")
	public @ResponseBody List<Board> boardList(){
		List<Board> list=boardMapper.getLists(); //xml파일에 있는 id가 getLists인 쿼리문 실행
		return list; //json 데이터 형식으로 변환해서 리턴하겠다
	}
	
	@RequestMapping("/boardInsert")
	public @ResponseBody void boardInsert(Board vo){ //반환형은 BoardMapper.java 참고
		boardMapper.boardInsert(vo); //Board 객체에 넣음
	}
	
	@RequestMapping("/boardDelete")
	public @ResponseBody void boardDelete(int idx) {
		boardMapper.boardDelete(idx);
	}
	
	@RequestMapping("/boardUpdate")
	public @ResponseBody void boardUpdate(Board vo) {
		boardMapper.boardUpdate(vo);
	}
}
