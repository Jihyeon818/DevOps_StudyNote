package kr.bit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sub2")
public class Sub1Controller {
	@RequestMapping(value="/spring5", method=RequestMethod.GET)
	public String spring5() {
		return "sub2/spring5"; //sub폴더에 잇는 Spring.jsp로 이동
	}
	@RequestMapping(value="/spring6", method=RequestMethod.GET)
	public String spring6() {
		return "sub2/spring6"; //sub폴더에 잇는 Spring.jsp로 이동
	}
}
