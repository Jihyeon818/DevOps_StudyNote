package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import beans.Data;
import beans.Data2;
import beans.Test;
import beans.Test2;

@Configuration
public class BeanClass {

	@Bean
	public Test test1() {
		return new Test();
	}
	
	@Bean
	public Data data1() {
		return new Data();
	}
	
	///////////qualifier 이름 설정한거랑 똑같은 이름으로 메서드를 성정해야 자동주입됨
	@Bean 
	Data2 obj1() {
		return new Data2();
	}
	
	@Bean
	Data2 obj2() {
		return new Data2();
	}

	////////////Test2 Bean 등록
	@Bean
	public Test2 test2() {
		return new Test2();
	}
	
	public Test2 test3() {
		return new Test2();
	}
}
