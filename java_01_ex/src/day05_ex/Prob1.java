package day05_ex;

import java.util.Arrays;

public class Prob1 {

	public static void main(String[] args) {
		int[] num = new int[6];

		for (int i = 0; i < num.length; i++) {
			num[i] = (int) (Math.random() * 45 + 1);
			for (int j = 0; j < i; j++) {
				
				if(num[j] == num[i]) {
					i--;
					break;
				/*if (i != j) {
					
					while (num[i] == num[j]) {
						num[i] = (int) (Math.random() * 45 + 1);
						j = 0;
					}*/
				}
			}
			//System.out.println(Arrays.toString(num));

		}
		System.out.println(Arrays.toString(num));
		System.out.println("=========중복처리=========");

		int i, j, temp, tempLoc;
		for (i = 0; i < num.length - 1; i++) {

			tempLoc = i;

			for (j = i + 1; j < num.length; j++) {

				if (num[tempLoc] > num[j]) {
					tempLoc = j;
				}

			}

			if (tempLoc != i) {
				temp = num[tempLoc];
				num[tempLoc] = num[i];
				num[i] = temp;
			}
		}
		System.out.println(Arrays.toString(num));
		System.out.println("==========정렬 후==========");
	}
}
