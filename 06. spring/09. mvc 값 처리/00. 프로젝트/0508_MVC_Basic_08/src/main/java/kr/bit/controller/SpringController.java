package kr.bit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.bit.beans.Data;

@Controller
public class SpringController {

	@PostMapping("/t1")
	public String t1(@ModelAttribute Data bean) {
		return "test1";
	}
	
	@PostMapping("/t2")
	public String t2(@ModelAttribute("test") Data bean) {
		return "test2";
	}
	
}
