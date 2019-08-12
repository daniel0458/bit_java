package day05_ex;

import java.util.Arrays;

public class Prob2 {
	
	public static void main(String[] args) {
		int[] num = new int[6];
		
		for(int i = 0;i < num.length; i++) {
			num[i] = (int)(Math.random()*6+1);
		}
		System.out.println(Arrays.toString(num));
		System.out.println("=========초기 배열==========");
		
		for(int i = 0; i < num.length-1;i++) {
			for(int j = i + 1; j < num.length;j++) {
				while(num[i] == num[j]) {
					num[j] = (int)(Math.random()*6+1);
				}
			}
		}
		System.out.println(Arrays.toString(num));
		System.out.println("=========중복값 대체=========");
		int i,j,temp ,tempLoc,count=0;
		for (i = 0; i < num.length - 1; i++) {
			
			tempLoc = i;
			temp = num[i];
			
			for (j = i + 1; j < num.length; j++) {
				
				if (num[tempLoc] > num[j]) {
					temp = num[j];
					tempLoc = j;
				}
				
			}
			
			if(tempLoc != i) {
				num[tempLoc] = num[i];
				num[i] = temp;
				count++;
			}
		}
		System.out.println(Arrays.toString(num));
		System.out.println("==========정렬 후==========");
	}
}
