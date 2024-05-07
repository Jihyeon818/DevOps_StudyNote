package kr.bit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //스프링에서는 bean이 아니라 controller로 bean 등록
public class SpringController {
	@RequestMapping(value="/spring1", method=RequestMethod.GET)
	public String spring1() {
		return "spring1"; //경로와 접두사는 ServletAppContext에서 지정. spring1.jsp화면 이동
				
	}
	@RequestMapping(value="/spring2", method=RequestMethod.GET)
	public String spring2() {
		return "spring2"; //파일넘기는건 문자열이여야 함
				
	}
	
}
