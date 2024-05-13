package kr.bit.controller;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.bit.beans.Data;

@Controller
public class SpringController {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@GetMapping("/input_test")
	public String input_test() {
		return "input_test";
	}

	@PostMapping("/input_proc")
	public String input_proc(Data data) {
								//namespace.id 값
		sqlSessionTemplate.insert("test.insert_data",data);
		return "input_proc";
	}
	
	
	@GetMapping("/read_test")
	public String read_test(Model model) {
		List<Data> li = sqlSessionTemplate.selectList("test.select_data");
		model.addAttribute("li",li); //model에 담아서 출력
		return "read_test";
	}
}