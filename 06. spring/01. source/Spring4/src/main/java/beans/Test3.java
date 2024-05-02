package beans;

public class Test3 {
	public Test3() {
		System.out.println("Test3");
	}
	
	public void default_init() {
		System.out.println("Test3_init");
	}
	public void default_destroy() {
		System.out.println("Test3_destroy");
	}
	
	public void Test3_init() {
		System.out.println("Test3_init");
	}
	public void Test3_destroy() {
		System.out.println("Test3_destroy");
	}
}
