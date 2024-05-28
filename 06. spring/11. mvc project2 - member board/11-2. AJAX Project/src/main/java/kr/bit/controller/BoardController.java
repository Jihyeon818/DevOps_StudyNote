package kr.bit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController{	
	
	@RequestMapping("/MainBoard")
	public String mainBoard() {
		return "board/main"; 
	}
		
}