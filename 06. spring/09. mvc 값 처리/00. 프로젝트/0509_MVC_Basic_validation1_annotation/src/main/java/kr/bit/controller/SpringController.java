package kr.bit.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.bit.beans.Data;

@Controller
public class SpringController {

	@GetMapping("/t1")
	public String t1() {
		return "test1";
	}
	

	@PostMapping("/test1_proc")
	public String test1_proc(@Valid Data data1, BindingResult result) {
		
		//@Valid : 메서드의 파라미터로 설정한 클래스(Data)에 유효성 검사를 실시하겠다 라는 선언.
		//@modelAttribute 가 생략되어 있음. (클래스 이름이 같으면 필드에 값을 자동 주입한다. 주입과정이 없는데 바로 쓸 수 있는 이유는 요놈이 생략되어 있기 때문이다..)
		//BindingResult : 유효성 검사 결과가 저장되는 인터페이스.
		
		//유효성 검사 결과를 콘솔로 확인
		System.out.println(data1.getNum1());
		System.out.println(data1.getNum2());
		System.out.println(result);
		
		//result 결과에 에러가 있으면,
		if(result.hasErrors()) {
			//모든 에러 결과를 obj 에 넣는다.
			for(ObjectError obj : result.getAllErrors()) {
				System.out.println("에러 코드 : " + obj.getCode()); //에러가 발생한 어노테이션 이름을 출력
				System.out.println("에러 메시지 : " + obj.getDefaultMessage()); //내가 어노테이션에서 설정한 메시지내용을 출력
				System.out.println("에러 클래스 이름 : " + obj.getObjectName()); //에러가 발생한 클래스명(근데 맨앞글자가 소문자임)
				
				//에러코드를 배열로 받아 출력하면 모든 에러코드가 다 출력됨.
				String[] str = obj.getCodes(); 
				for(String s : str) {
					System.out.println(s);
				}
				//이렇게 에러메시지를 수동으로 추가해볼수도 있따. 참고... ㅎ
				if(str[0].equals("Size.data.num2")) {
					System.out.println("num2 글자수가 잘못되었습니다. 다시 입력해주세요. (4글자~10글자 사이로 작성)");
				} else if(str[0].equals("Max.data.num1")) {
					System.out.println("num1 값이 잘못되었습니다. 다시 입력해주세요. (숫자는 100을 넘길 수 없습니다)");
				}
			
			}
			
			return "test1"; //오류가 발생했다면 다시 test1.jsp 로 간다.
			
		}
		
		//유효성 검사 통과했으면(오류 없으면) test2.jsp 로 이동해서 내가 입력한 값을 브라우저에 출력하자.
		return "test2";
	}

}