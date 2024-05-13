package kr.bit.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.bit.beans.Data;

@Controller
public class SpringController {

	@GetMapping("/t1")
	public String t1(Data data) {
		return "test1";
	}
	
	@GetMapping("/t2")
	public String t2(Data data) {
		return "test2";
	}

	@GetMapping("s1/t3")
	public String t3(Data data) {
		return "test3";
	}
	
	@GetMapping("s1/t4")
	public String t4(Data data) {
		return "test4";
	}
	
}