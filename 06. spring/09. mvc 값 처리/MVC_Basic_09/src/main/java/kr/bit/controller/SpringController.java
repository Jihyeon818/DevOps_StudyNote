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
	public String t1(Data bean) { //경로매핑 후에 필드에 값 세팅
		bean.setName("지현");
		bean.setId("hyeon");
		bean.setPw("1234");
		bean.setAdr1("Seoul");
		bean.setAdr2("kumcheon");
		
		return "test1";
	}

	@GetMapping("/t2")
	public String t2(Data bean) {
		bean.setName("수정");
		bean.setId("kim");
		bean.setPw("1234");
		bean.setAdr1("Seoul");
		bean.setAdr2("gangnam");
		
		return "test2";
	}
	
	@GetMapping("/t3")
	public String t3(@ModelAttribute("modelBean") Data bean) {
		bean.setName("화연");
		bean.setId("hong");
		bean.setPw("1234");
		bean.setAdr1("Seoul");
		bean.setAdr2("gangnam");
		
		return "test3";
	}
	
	@GetMapping("/t4")
	public String t4(Model model) {
		Data bean = new Data();
		bean.setName("비트");
		bean.setId("hong");
		bean.setPw("1234");
		bean.setAdr1("Seoul");
		bean.setAdr2("gangnam");
		
		model.addAttribute("modelBean",bean);
		
		return "test4";
	}
}
