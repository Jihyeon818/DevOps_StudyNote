package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import beans.Test;
import beans.Test2;
import beans2.Test3;


@Configuration
@ComponentScan(basePackages = "beans2")
@ComponentScan(basePackages = "beans3")
//@ComponentScan어노테이션이 있는 beans2, beans3 패키지 검사(체크)한다
//어노테이션이 있는지 확인(@component, @repository, @controller, @service...)
public class BeanClass {

	//Test 3,4,5는 위에 @ComponentScan으로 가져와서 bean으로 등록하지 않아도 됨
	
	@Bean
	public Test test1() {
		return new Test();
	}
	
	@Bean
	public Test2 test2() {
		return new Test2();
	}

	@Bean
	public Test3 test3() {
		return new Test3();
	}
}
