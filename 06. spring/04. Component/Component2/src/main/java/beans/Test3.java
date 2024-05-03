package beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy //객체 생성 시점: getBean 메서드 호출할 때 객체가 생성됨
public class Test3 {
	public Test3() {
		System.out.println("Test3 생성자");
	}

}
