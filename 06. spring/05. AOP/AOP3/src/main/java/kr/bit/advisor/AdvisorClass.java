package kr.bit.advisor;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect //advisor역할을 할 bean을 지정, xml에서 Aspect를 가져오는 작업을 진행해야 함
@Component
@Order(1) //첫번째로 실행
public class AdvisorClass {
	//aspectj 라이브러리를 pom.xml에 넣어서 어노테이션 가능
	@Before("execution(* m1())") //관심사 함수 호출 이전, execution에 있는게 관심사 함수
	public void test1() {
		System.out.println("before");
	}
	@AfterReturning("execution(* m1())")
	public void test2() {
		System.out.println("return");
	}
	
	@AfterThrowing("execution(* m1())") //예외처리 후에
	public void test3() {
		System.out.println("throw");
	}
}
