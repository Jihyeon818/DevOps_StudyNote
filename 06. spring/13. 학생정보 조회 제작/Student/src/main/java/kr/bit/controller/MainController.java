package kr.bit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.bit.entity.Student;
import kr.bit.mapper.StudentMapper;

@Controller
public class MainController {

	@Autowired
    StudentMapper studentMapper;
	
	@RequestMapping("/")
	public String home(Model model) {
		List<Student> studentList = studentMapper.getAllStudents();		
		model.addAttribute("studentList", studentList);
		return "home";
	}
	
}
