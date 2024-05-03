package kr.bit.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.bit.beans.Test;

public class MainClass {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/bit/config/beans.xml");
		
		Test t1 = ctx.getBean("test1", Test.class);
		t1.m1();
		t1.m1(10); 
		t1.m1("spring");
		t1.m1(10, 15); //*이 하나뿐이라 매개변수가 2개인 경우 위빙이 안됨(before함수 호출 안됨!)
		t1.m1(10,"spring");
		
		ctx.close();

	}
}
