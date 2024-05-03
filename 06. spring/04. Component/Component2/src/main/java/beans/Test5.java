package beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Test5 {
	public Test5() {
		System.out.println("Test5 생성자");
	}

	@PostConstruct //생성자 호출 이후 자동으로 호출될 메서드
	public void init() {
		System.out.println("init");
	}
	
	@PreDestroy //객체 소명될 때 자동으로 호출될 메서드
	public void destroy() {
		System.out.println("destroy");
	}
}
