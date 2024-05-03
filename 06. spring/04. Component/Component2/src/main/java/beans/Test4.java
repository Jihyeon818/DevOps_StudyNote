package beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Test4 {
	public Test4() {
		System.out.println("Test4 생성자");
	}

}
