package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.English;
import beans.Korea;
import beans.Lang;

public class MainClass {
	public static void main(String[] args) {
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config/beans.xml");
	//xml 파일 로딩
	Lang lang = (Lang)ctx.getBean("hi"); //다운캐스팅, 아이디 값을 가져옴
	call(lang);
	}
	public static void call(Lang lang) {
		lang.hi();
	}
}

