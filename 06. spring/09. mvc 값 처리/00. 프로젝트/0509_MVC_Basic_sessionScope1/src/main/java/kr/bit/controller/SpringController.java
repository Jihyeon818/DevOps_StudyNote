package kr.bit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.bit.beans.Data;

@Controller
@SessionAttributes({"sbean","sbean2"})
// sbean, sbean2 이건 뭐지? 맨밑 t5에서 modelAttribute 로 주입한 객체.
// modelAttribute로 주입하면 request 영역에 저장된다.
// 이걸 세션 영역에 저장하고 싶을 때 사용하는 어노테이션이다. 
public class SpringController {

	// @SessionAttributes 사용 시 주의할 점 ! 
	// @ModelAttribute 를 활용해 객체를 따로 생성해둬야지 session 영역으로 바꿀 수 있다.
	@ModelAttribute("sbean")
	public Data dbean() {
		return new Data();
	}
	
	@ModelAttribute("sbean2")
	public Data dbean2() {
		return new Data();
	}
	
	//----------------------------------------------------------------------
	
	@GetMapping("/t1")
	public String t1(HttpSession session) {
		session.setAttribute("data1", "spring1");	
		return "test1";
		//기본적인 사용. session.setAttribute 로 세션 영역에 값을 저장할 수 있다.
	}
	
	//----------------------------------------------------------------------
	
	@GetMapping("/t2")
	public String t2(HttpSession session) {
		session.setAttribute("data1", "spring2");
		return "redirect:/s1"; 
		// index.jsp 에 보면 's1' 이라는 a태그가 있음. 거기로 이동시킴.
		// redirect 로 전송했기 때문에 url 주소가 t2에서 s1 으로 변경됨.
	}
	
	@GetMapping("/t3")
	public String t3(HttpSession session) {
		session.setAttribute("data1", "spring3");
		return "forward:/s1";
	}

	@GetMapping("/s1")
	public String s1(HttpSession session) {
		String str = (String) session.getAttribute("data1");
		System.out.println(str);
		return "spring1";
	}
	
	
	//----------------------------------------------------------------------
	
	@GetMapping("/t4")
	public String t4(HttpSession session) {
		
		//Data 객체를 생성하여 값 저장.
		Data d = new Data();
		d.setStr1("spring4");
		d.setStr2("spring5");
		
		session.setAttribute("bean", d); 
		//값을 저장한 Data 객체를 session 영역에 담아 test4.jsp로 전송.
		//세션에는 객체를 넣을 수도 있다.
		
		return "test4";
	}
	
	@GetMapping("/s4")
	public String s4(@SessionAttribute("bean") Data d) {
		return "spring4";
		//어노테이션 @SessionAttribute : session 에 저장되어 있는 객체를 사용하고자 할 때 쓴다.
		//여기서는 t4 에서 session 영역에 Data 객체를 bean 이라는 이름으로 저장해두었기 때문에 쓸 수 있따.
		//근데 이게 동작하려면 t4 에 해당하는 a태그를 먼저 눌러야함. 그래야 세션 영역에 Data 객체가 담기기 때문...
	}
	
	//----------------------------------------------------------------------
	
	@GetMapping("/t5")
	public String t5(@ModelAttribute("sbean") Data dbean, @ModelAttribute("sbean2") Data dbean2) {
		//@ModelAttribute : 파라미터로 지정된 객체(Data)를 자동으로 생성하고 set메서드를 호출해서 값을 주입해준다.
		//이렇게 저장하면 request 영역에 저장된다.
		//이거를 session 영역으로 바꾸고 싶다면, 해당 페이지 맨 위 @SessionAttributes() 어노테이션 부분을 참고하자..
		dbean.setStr1("aa");
		dbean.setStr2("bb");
		
		dbean2.setStr1("cc");
		dbean2.setStr2("dd");
		
		return "test5";
	}
	
	@GetMapping("/s5")
	public String s5(@ModelAttribute("sbean") Data dbean, @ModelAttribute("sbean2") Data dbean2) {
		//s5 를 눌렀을 때, ModelAttribute 로 생성한 객체 sbean, sbean2 의 값이 spring5.jsp로 잘 넘어가는지 확인하고자 함.
		//원래대로라면 request 영역에 담기기 때문에 이런 식으로는 전송이 안되겠지..
		//다만 우리는 session 영역으로 옮겨놨기 때문에 이게 잘 동작하는지 보려는 것이다!
		return "spring5";
	}
	
}