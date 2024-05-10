package kr.bit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import kr.bit.beans.Data;
import kr.bit.beans.Data2;


@Configuration
@ComponentScan("kr.bit.beans")
public class RootAppContext {  //root-context.xml

	@Bean
	@SessionScope
	//브라우저가 서버에 최초로 요청을 보낼 때 bean 객체가 주입된다.
	public Data bean() {
		return new Data();
	}
	
	@Bean("session2")
	@SessionScope
	public Data2 bean2() {
		return new Data2();
	}
	
}
