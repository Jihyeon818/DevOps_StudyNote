package kr.bit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.bit.beans.Data;
import kr.bit.database.MapperInterface;

@Controller
public class SpringController {
	
	@Autowired
	MapperInterface mapper;
	
	@GetMapping("/input_test")
	public String input_test() {
		return "input_test";
	}
	
	@PostMapping("/input_proc")
	public String input_proc(Data data) {
		mapper.insert_data(data); //db에 저장
		return "input_proc";
	}
	
	@GetMapping("/read_test")
	public String read_test(Model model) {
		List<Data> li = mapper.select_data();
		model.addAttribute("li",li);
		return "read_test";
	}
}