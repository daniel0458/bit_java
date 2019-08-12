package day03;

public class Test06 {
	public static void main(String[] args) {
		
		//1~100합
		int sum =0;
		int sum4 = 0;
		int i;
		for(i = 1;i <=100; i++) {
			sum += i;
			if (i%4 == 0) {
				sum4 += i;
			}
		}
		System.out.println(sum);
		System.out.println(sum4);
	}
}
