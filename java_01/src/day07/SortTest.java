package day07;

import java.util.Arrays;

import util.Sort;

public class SortTest {
	public static void main(String[] args) {
		int num[] = {3,2,5,1};
		
		System.out.println("정렬된 배열:"+Arrays.toString(Sort.sort(num)));
		System.out.println("원본:"+Arrays.toString(num));
		
	}
}
