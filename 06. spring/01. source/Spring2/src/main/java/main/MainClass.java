package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import beans.Test;

public class MainClass {
	public static void main(String[] args) {
		test1();
		test2();
	}
	
	//1. classxml 사용
	public static void test1() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config/beans.xml"); //패키지 안의 파일 로딩
		
		Test t1 = ctx.getBean("test1", Test.class);
		System.out.println(t1);
		Test t2 = ctx.getBean("test1", Test.class);
		System.out.println(t2); //싱글톤이라 주소값 같음
	}
	public static void test2() {
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml"); //파일 자체를 가져옴
		
		Test t1 = ctx.getBean("test2", Test.class);
		System.out.println(t1);
		Test t2 = ctx.getBean("test2", Test.class);
		System.out.println(t2); //싱글톤이라 주소값 같음
	}
}

