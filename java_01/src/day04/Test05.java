package day04;

import java.util.Arrays;

public class Test05 {
	public static void main(String[] args) {
		//배열 선언,생성,초기화 동시
		int[] scores = {88,99,100,22,56,88,99};
		String[] names = {"홍길동","김길동","고길동","박길동","최길동","이길동"};
		
		System.out.println(Arrays.toString(scores));
		System.out.println(Arrays.toString(names));
		
		if(names.length > 6) System.out.println(names[6]);
		System.out.println("===================================================");
		
		for(String data :names) {
			System.out.println("**"+data.charAt(data.length()-1));
		}
		
		double sum = 0.0;
		for(int data:scores) {
			sum += data;
		}
		System.out.printf("avg = %.2f %n",sum/scores.length);
	}
}
