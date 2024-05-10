package kr.bit.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.bit.beans.Data;

@Controller
public class SpringController {

	@GetMapping("/t1")
	public String t1(Data data) {
		return "test1";
	}
	
	@PostMapping("/test1_proc")
	public String test1_proc(@Valid Data data, BindingResult result) {
		if(result.hasErrors()) {
			return "test1"; //입력폼으로 다시 돌아가서 브라우저 에러메시지 띄울거임.
		}
		return "test2"; //유효성 검사 통과했으니 내가 입력한 값을 브라우저에 띄울거임.
	}

}