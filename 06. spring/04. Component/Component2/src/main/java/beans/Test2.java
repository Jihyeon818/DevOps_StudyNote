package beans;

import org.springframework.stereotype.Component;

@Component("component2")
public class Test2 {
	public Test2() {
		System.out.println("Test2 생성자");
	}
}
