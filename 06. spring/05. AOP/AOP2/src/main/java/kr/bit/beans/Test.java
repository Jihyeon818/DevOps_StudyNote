package kr.bit.beans;

public class Test {
	public void m1() {
		System.out.println("m1");
	}
	//weaving
	public void m1(int n1) {
		System.out.println("int m1");
	}
	public void m1(String n1) {
		System.out.println("String m1");
	}

	public void m1(int n1, int n2) {
		System.out.println("int, int");
	}

	public void m1(int n1, String n2) {
		System.out.println("int, String");
	}
	public void m2() {
		System.out.println("m2");
	}
	public int m3() {
		System.out.println("m3");
		return 1;
	}
}
