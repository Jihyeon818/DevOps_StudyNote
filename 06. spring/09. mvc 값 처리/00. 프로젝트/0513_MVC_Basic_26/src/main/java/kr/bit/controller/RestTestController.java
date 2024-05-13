package kr.bit.controller;

import java.util.ArrayList;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.bit.beans.Data;

@RestController
public class RestTestController {
	
	@GetMapping("/t2")
	public ResponseEntity<ArrayList<Data>> t2(){
		Data d1 = new Data("spring", 100, 1.1, false);
		Data d2 = new Data("java", 200, 2.2, true);
		Data d3 = new Data("mvc", 300, 3.3, false);

		ArrayList<Data> li = new ArrayList<Data>();
		li.add(d1);
		li.add(d2);
		li.add(d3);
		
		ResponseEntity<ArrayList<Data>> en = new ResponseEntity<ArrayList<Data>>(li,HttpStatus.OK);
		return en;
	}
	
}