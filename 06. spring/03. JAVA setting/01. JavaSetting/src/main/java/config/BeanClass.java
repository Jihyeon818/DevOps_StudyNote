package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import beans.Test;
import beans.Test2;
import beans.Test3;

@Configuration
// 현재 자바 파일이 빈 등록(객체등록)을 하기 위한 자바파일명을 알리는 어노테이션
public class BeanClass {

	@Bean	//pom.xml에 라이브러리 등록을 하였기에 사용 가능 
	public Test test1() { //메소드 이름이 bean의 이름(주소값)이 됨. id값
		Test t1 = new Test();
		return t1;
	}
	//xml로 작성 시 : <bean id="test1" class="beans.Test"/> 와 같음 
	
	@Bean(name="test2")  //따로 설정 가능. 우선순위가 높음
	public Test test11() {
		Test t1 = new Test();
		return t1;
	}
	
	@Bean
	@Lazy
	public Test2 test3() {
		Test2 t2 = new Test2();
		return t2;
	}
	
	@Bean
	@Scope("prototype") //싱글톤이 아니게 됨
	public Test3 test4() {
		Test3 t3 = new Test3();
		return t3;
	}
}
