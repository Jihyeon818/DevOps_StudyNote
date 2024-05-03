package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import beans.Test2;


@Configuration
@ComponentScan(basePackages = "beans")
public class BeanClass {

	@Bean
	public Test2 test() {
		return new Test2(); //객체가 있긴 하지만 이름으로 등록(component2)된 상태라 새로 만듬
	}

}
