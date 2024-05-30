package kr.bit.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.bit.entity.Student;
import kr.bit.mapper.StudentMapper;

@Controller
public class StudentController {

    @Autowired
    StudentMapper studentMapper;

    @ResponseBody
    @GetMapping("/{num}")
    public Student studentFind(@PathVariable("num") int num) {
    	Student vo = studentMapper.studentFind(num);
		return vo;
	}

    @ResponseBody
    @PutMapping("/update")
	public void studentUpdate(@RequestBody Student vo) {
    	studentMapper.studentUpdate(vo);
	}
    
    @ResponseBody
    @DeleteMapping("/{num}")
	public void studentDelete(@PathVariable("num") int num) {
    	studentMapper.studentDelete(num);
	}
    
    @ResponseBody
    @GetMapping("/serch/{name}")
    public List<Student> search(@PathVariable("name") String name) {;
    	return studentMapper.search(name);
	}
    
    @ResponseBody
    @PostMapping("/insert")
	public void studentInsert(Student student){
    	studentMapper.studentInsert(student);
	}
}
