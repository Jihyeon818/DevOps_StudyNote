package beans;

public class Test2 {
	public Test2() {
		System.out.println("Test2");
	}
	//객체 관리 주기 확인(프레임워크가 관리함)
	public void default_init() {
		System.out.println("Test2_init");
	}
	public void default_destroy() {
		System.out.println("Test2_destroy");
	}
}
