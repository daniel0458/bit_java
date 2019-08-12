package day07;

public class Calc {
	//class 변수
	static int data = 0;
	
	//class method
	public static long add(int a,int b) {
		System.out.println(Calc.data);
		System.out.println(Math.random() );
		return a + b;
	}
	public static long subtract(int a,int b) {
		
		return a - b;
	}

	public static long multify(int a,int b) {
		
		return a * b;
	}
	
	
	public static double divide(int a,int b) {
		if(b == 0) {return 0;}
		return a / b;
	}
	
	
}
