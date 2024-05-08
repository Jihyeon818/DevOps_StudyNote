package kr.bit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.bit.beans.Data;

@Controller
public class SpringController {

	@GetMapping("/t1")
	public String t1(Data data) { //경로매핑 후에 필드에 값 세팅
		data.setStr1("str1");
		data.setStr2("str2");
		data.setStr3("str3");
		data.setStr4("str4");
		
		return "test1";
	}
}
