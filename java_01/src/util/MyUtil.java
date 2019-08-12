package util;

public class MyUtil {

	public static long add(int a, int b) {
		return a + b;
	}

	public static double add(double a, double b) {
		return a + b;
	}

	public static double add(double a, double b, int c) {
		return a + b + c;
	}

	// 가변인자, 제일 마지막 위치만 허용
	public static double add(double... nums) { // []로 처리
		double sum = 0;
		for (double data : nums) {
			sum += data;
		}
		return sum;
	}
	// 배열과 가변인자의 차이: 배열은 넣어주는 값도 배열로 넣어줘야하므로 가변인자 쪽이 더 편하다.
	/*
	 * public static double add(double[] a) { //[]로 처리 double sum = 0; for (double
	 * data :a) { sum += data; } return sum; }
	 */

	/*
	 * public static double add(double a, double b, int c, double d) { return
	 * a+b+c+d; }
	 */

	public String leftPad(String str, int size, char padChar) {
		/* 여기에 프로그램을 완성하십시오. */
		if (size <= str.length()) {
			return str;
		}
		while (size > str.length()) {
			str = padChar + str;
		}
		return str;
	}

	public static String rightPad(String str, int size, char padChar) {
		/* 여기에 프로그램을 완성하십시오. */
		if (size <= str.length()) {
			return str;
		}
		while (size > str.length()) {
			str = str + padChar;
		}
		return str;
	}

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

				if (i != min) {
					int temp = sorted[i];
					sorted[i] = sorted[min];
					sorted[min] = temp;

				}
			}
		}
		return sorted;
	}

	// 숫자를 넘겨 받아 그중 가장 큰 수를 리턴하는 함수 max
	public static int max(int... nums) {
		int max = Integer.MIN_VALUE;
		
		for(int data : nums) {
			if(max < data) {
				max = data;
			}
		}

		return max;
	}
}
