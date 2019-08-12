package day02;

public class Test03 {
	public static void main(String[] args) {
		
		int x = 600, y = 700;
		int temp;
		double d1 = 99.1568, d2 = 77.34677;
		double tmp;
		
		//System.out.println("x=" + x + ", y=" + y ); 
		//string에서의 + 연산은 성능저하의 원인이 된다.
		System.out.printf("x=%d, y=%d %n",x,y);
		
		temp = x;
		x = y;
		y = temp;
		
		System.out.printf("x=%d, y=%d\n",x,y);
		
		System.out.printf("d1=%f d2=%f\n",d1,d2);
		
		tmp = d1;
		d1 	= d2;
		d2 	= tmp;
	}
}
