package beans;

public class Test {
	public Test() {
		System.out.println("Test");
	}
	//객체 생성 주기 확인(프레임워크가 관리함)
	public void Test_init() {
		System.out.println("Test_init");
	}
	public void Test_destroy() {
		System.out.println("Test_destroy");
	}
}
