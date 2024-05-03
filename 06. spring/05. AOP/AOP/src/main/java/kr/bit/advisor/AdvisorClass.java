package kr.bit.advisor;

import org.aspectj.lang.ProceedingJoinPoint;

public class AdvisorClass {
	public void beforeMethod() {
		System.out.println("before");
	}
	public void afterMethod() {
		System.out.println("after");
	}
	public Object aroundMethod(ProceedingJoinPoint pj) throws Throwable{
		System.out.println("around1");
		
		Object obj = pj.proceed(); 
		
		System.out.println("around2");
		
		return obj;
	}
	public void afterReturningMethod() {
		System.out.println("afterReturn");
	}
}
