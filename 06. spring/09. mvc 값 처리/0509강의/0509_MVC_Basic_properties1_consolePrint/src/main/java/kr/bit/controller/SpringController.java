package kr.bit.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

// properties 파일을 콘솔에 출력하기 위해 값을 가져올 때 쓰는 어노테이션. (일종의 import 작업)
@PropertySources({
	@PropertySource("/WEB-INF/properties/data1.properties"),
	@PropertySource("/WEB-INF/properties/data2.properties")
})
/* properties : 애플리케이션 실행 중에 절대 변하지 않는 값들을 설정해야 할 때 properties 파일에 넣어주면 됨.
 예를 들어, DB 연결할 때 정보(url,id,pw같은거), 유효성 검사 정보 등
 이게 core 에서는 xml파일에 넣어놨었던걸로 기억하는데 MVC에서는 그런 기능이 없다고 함. 그래서 properties 파일 만들어서 쓰는거임.
 properties 파일에는 (어노테이션.클래스명.필드명 = 값) 이런 식으로 적는다.
 근데 지금 내 이클립스가 이상한지 properties 에서 한글쓰면 깨지는데... 출력은 또 잘 됨..
*/
public class SpringController {

	//@Value : 설정파일(properties 파일이나 스프링코어면 xml파일)에 작성한 값을 주입시켜주는 어노테이션.
	@Value("${aaa.a1}")
	private int a1;
	
	@Value("${aaa.a2}")
	private String a2;
	
	@Value("${bbb.b1}")
	private int b1;
	
	@Value("${bbb.b2}")
	private String b2;
	
	@Value("${ccc.c1}")
	private int c1;
	
	@Value("${ccc.c2}")
	private String c2;
	
	@Value("${ddd.d1}")
	private int d1;
	
	@Value("${ddd.d2}")
	private String d2;
	
	//-----------------------------------------------------------------------------------
	
	@GetMapping("/t1")
	public String t1() {
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(d1);
		System.out.println(d2);
		
		return "test1";
	}
}