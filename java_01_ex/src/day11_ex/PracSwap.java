package day11_ex;

import java.util.Arrays;

public class PracSwap {
	public static void main(String[] args) {
		int[] numbers = new int [5];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random()*5+1); 
		}
		System.out.println(Arrays.toString(numbers));
		
		int[] newNum = delOverlap(numbers);
		System.out.println(Arrays.toString(newNum));
		
		int[] sorted = swap(newNum);
		System.out.println(Arrays.toString(sorted));
	}
	public static int[] delOverlap(int[] numbers) {
		for(int i = 0; i < numbers.length-1;i++) {
			for(int j = 0;j < numbers.length;j++) {
				if(i!=j && numbers[i] == numbers[j]) {
					numbers[i] = (int)(Math.random()*5+1); 
					j = -1;
				}
			}
		}
		
		return numbers;
	}
	
	public static int[] swap(int[] numbers) {
		int min;
		for(int i = 0;i < numbers.length-1;i++) {
			min = i;
			for(int j = i+1;j < numbers.length; j++) {
				if(numbers[min] > numbers[j]) {
					min = j;
				}
			}
			if(min != i) {
				int temp = numbers[i];
				numbers[i] = numbers[min];
				numbers[min] = temp;
			}
		}
		
		return numbers;
	}
}
