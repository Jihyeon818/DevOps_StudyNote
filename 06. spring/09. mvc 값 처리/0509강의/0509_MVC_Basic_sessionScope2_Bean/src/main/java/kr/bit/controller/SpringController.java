package kr.bit.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.bit.beans.Data;
import kr.bit.beans.Data2;
import kr.bit.beans.Data3;

@Controller
public class SpringController {

	//RootAppContext 에 빈으로 등록한 Data 객체의 주소값을 자동주입 받는다.
	
	//타입이 같을 때 자동주입 방법
	@Autowired
	Data data1;
	
	//이름이 같을 때 자동주입 방법
	@Resource(name = "session2")
	Data2 data2;
	
	@Autowired
	Data3 data3;
	
	//---------------------------------------------------------
	
	@GetMapping("/t1")
	public String t1() {
		//객체들은 전부 sessionScope 이다.
		//t1 a태그를 클릭하면 아래의 값들이 Bean에 주입된다.
		data1.setStr1("aa");
		data1.setStr2("bb");
		
		data2.setStr3("cc");
		data2.setStr4("dd");
		
		data3.setStr5("ee");
		data3.setStr6("ff");
		
		return "test1";
	}
	
	// t1에서 sessionScope 로 설정한 객체들을 requestScope 로 바꿔보는 작업 
	// Model 객체는 request 영역까지만 동작하기 때문에, 아래와 같이 코드를 짜면 requestScope로 바뀌어버린다.
	@GetMapping("/s1")
	public String s1(Model model) {

		model.addAttribute("data1", data1);
		model.addAttribute("data2", data2);
		model.addAttribute("data3", data3);
		
		return "spring1";
	}
	
}