package util;

import java.util.Arrays;

public class Sort {

	public static int[] sort(int[] nums) {
		int[] sorted = new int[nums.length];
		/*
		 * for(int i = 0; i < nums.length; i++) { sorted[i] = nums[i]; //sorted[i]++; }
		 */
		System.arraycopy(nums, 0, sorted, 0, nums.length);

		for (int i = 0; i < sorted.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < sorted.length; j++) {
				if (sorted[i] > sorted[j]) {
					min = j;
				}
				
				if( i != min) {
					int temp = sorted[i];
					sorted[i] = sorted[min];
					sorted[min] = temp;
		
				}
			}
		}
		return sorted;
	}
}
