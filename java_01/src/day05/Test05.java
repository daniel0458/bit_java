package day05;

import java.util.Arrays;

public class Test05 {
	public static void main(String[] args) {
		
		int[][] t1 = new int[3][2];
		
		t1[0][0] = 1;
		t1[0][1] = 2;
		t1[1][0] = 3;
		t1[1][1] = 4;
		t1[2][0] = 5;
		t1[2][1] = 6;
		
		System.out.println(Arrays.toString(t1[0]));
		System.out.println(Arrays.toString(t1[1]));
		System.out.println(Arrays.toString(t1[2]));
		
		System.out.println("------------------------------");
		
		int[][] t2 = {
				{1,2},{3,4},{5,6}
		};
		System.out.println(Arrays.toString(t2[0]));
		System.out.println(Arrays.toString(t2[1]));
		System.out.println(Arrays.toString(t2[2]));
		
	}
	 
}
