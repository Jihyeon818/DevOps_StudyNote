package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import beans.Test;
import beans.Test2;
import beans.Test3;
import config.BeanClass;

public class MainClass {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanClass.class);
		//자바빈을 로딩하는 작업
		
		Test t1 = ctx.getBean("test1", Test.class);
		System.out.println(t1);
		
		Test t2 = ctx.getBean("test1", Test.class);
		System.out.println(t2); //싱글톤이라 같은 주소값 가져옴, 생성자도 같이 호출되어 "test 생성자" 두 번 출력
		
		System.out.println("--------@bean으로 name 변경--------");
		/*Test t3 = ctx.getBean("test11",Test.class);
		System.out.println(t3);*/ //name값을 바꿔서 없는 이름!
		
		Test t4 = ctx.getBean("test2",Test.class);
		System.out.println(t4); //주소값이 달라짐
		
		System.out.println("--------Lazy 확인--------");
		Test2 t5 = ctx.getBean("test3", Test2.class);
		System.out.println(t5);
		
		Test2 t6 = ctx.getBean("test3", Test2.class);
		System.out.println(t6); //Lazy를 줘서 객체 생성시점 확인(주소값 같음, 호출 시 생성자 호출을 막음)
		
		System.out.println("--------Scope 확인--------");
		Test3 t7 = ctx.getBean("test4", Test3.class);
		System.out.println(t7);
		
		Test3 t8 = ctx.getBean("test4", Test3.class);
		System.out.println(t8); //주소값이 다름
	}
}


