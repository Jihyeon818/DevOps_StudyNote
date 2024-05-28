package kr.bit.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import kr.bit.beans.User;


@Configuration
@ComponentScan("kr.bit.beans")
public class RootAppContext {  //root-context.xml

	@Bean("loginBean")
	@SessionScope
	public User loginBean() {
		return new User();
	}

	
}
