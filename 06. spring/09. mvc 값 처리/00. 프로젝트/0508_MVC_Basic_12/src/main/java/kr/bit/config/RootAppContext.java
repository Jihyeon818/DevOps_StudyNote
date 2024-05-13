package kr.bit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import kr.bit.beans.Data;
import kr.bit.beans.Data2;

@Configuration	//bean설정 파일임을 명시
public class RootAppContext {	//root-context.xml과 동일
	@Bean
	@RequestScope //요청이 발생할 때마다 Bean객체가 생성되며 자동으로 주입됨
	public Data data() {
		return new Data();
	}
	@Bean("request2")
	@RequestScope 
	public Data2 data2() {
		return new Data2();
	}
	
}
