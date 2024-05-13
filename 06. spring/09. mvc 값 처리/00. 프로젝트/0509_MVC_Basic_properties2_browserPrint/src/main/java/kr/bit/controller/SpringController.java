package kr.bit.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringController {

	//properties 값들을 jsp파일에 출력하기 위한 작업.
	// 1. ServletAppContext.java 에 빈 등록
	// 2. 위 java파일에서 등록한 빈을 자동주입
	@Autowired
	ReloadableResourceBundleMessageSource res;
	
	@GetMapping("/t1")
	public String t1(Model model, Locale locale) {
		
		String str1 = res.getMessage("aaa.a1", null, null); //뒤에 null null 왜붙이는지 ㅈㄴ대충설명하고 넘어가서 뭔지 모르겠으ㅜㅁ
		String str2 = res.getMessage("bbb.b1", null, null);
		
		Object[] args = {30,"seoul"};
		String str3 = res.getMessage("aaa.a2", args, null);
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		model.addAttribute("args", args);
		
		return "test1";
	}
}