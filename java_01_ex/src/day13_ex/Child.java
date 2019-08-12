package day13_ex;

public class Child extends Parent {
	int x = 3000;

	Child() {
		this(1000);
		System.out.println("3");
	}

	Child(int x) {
		this.x = x;
		System.out.println("4");
	}
}
