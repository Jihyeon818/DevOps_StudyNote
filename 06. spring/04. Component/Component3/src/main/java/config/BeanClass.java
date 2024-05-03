package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import beans.Data3;
import beans.Data4;
import beans.Data5;
import beans.Test3;

@Configuration
@ComponentScan(basePackages = "beans")
public class BeanClass {

	@Bean
	public Data3 component4() { //Test에는 있었지만 Data에 없어서 bean등록을 다시 해줘야함
		return new Data3();
	}
	
	@Bean
	public Data3 component5() {
		return new Data3();
	}

	@Bean
	public Test3 t3() {
		return new Test3(100,"java",new Data4(), new Data5()); //생성자로 값이 들어있는 상테에서 또 넣을 경우
	}
}
