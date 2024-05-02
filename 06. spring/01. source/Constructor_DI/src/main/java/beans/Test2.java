package beans;

public class Test2 {
	private Data d1;
	private Data d2;
	
	public Test2(Data d1, Data d2) {
		this.d1 = d1;
		this.d2 = d2;
	}
	public void show() {
		System.out.println(d1);
		System.out.println(d2);
	}

}
