package beans;

public class Test {
	public Test() {
		System.out.println("Test 생성자");
	}
	
	public void init() {
		System.out.println("Test init");
	}
	
	public void destroy() {
		System.out.println("Test destroy");
	}
}
