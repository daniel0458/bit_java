package day13_ex;

public class Parent {
	int x = 100;

	Parent() {
		this(200);
		System.out.println("1");
	}

	Parent(int x) {
		this.x = x;
		System.out.println("2");
	}

	int getX() {
		return x;
	}
}
