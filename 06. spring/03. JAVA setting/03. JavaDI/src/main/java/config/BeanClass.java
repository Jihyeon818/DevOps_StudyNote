package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import beans.Test;

@Configuration
public class BeanClass {

	@Bean(initMethod = "init", destroyMethod="destroy")
	@Lazy
	public Test test1() {
		return new Test();
	}

}
