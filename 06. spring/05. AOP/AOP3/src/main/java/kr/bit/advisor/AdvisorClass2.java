package kr.bit.advisor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class AdvisorClass2 {
	
	@Around("execution(* m1())")
	public Object test1(ProceedingJoinPoint pj) throws Throwable{
		System.out.println("around one");
		
		Object obj = pj.proceed();
		System.out.println("around two");
		return obj;
	}
	@After("execution(* m1())")
	public void test2() {
		System.out.println("after");
	}
	
}
