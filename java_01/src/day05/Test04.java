package day05;

import java.util.Arrays;

public class Test04 {

	public static void main(String[] args) {
		// 난수 생성
		// System.out.println((int)(Math.random()*10));
		if (args.length == 0) {
			System.out.println("배열의 사이즈 정보를 실행 매개변수로 념겨주세요");
			System.out.println("실행예) java day05.Test04 5");
			return;
		}

		int[] nums = new int[Integer.parseInt(args[0])];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 45) + 1;
		}
		System.out.println(Arrays.toString(nums));
		// 정렬 오름 sort

		System.out.println("------   정렬   --------");
		int sorted[] = new int[nums.length];
		System.arraycopy(nums, 0, sorted, 0, nums.length);
		
		/*for (int i = 0; i < nums.length - 1; i++) {

			for (int j = i + 1; j < nums.length; j++) {
				int temp;

				if (sorted[i] > sorted[j]) {
					temp = sorted[i];
					sorted[i] = sorted[j];
					sorted[j] = temp;
				}

			}
		}

		System.out.println(Arrays.toString(sorted));*/
		
		
		////////////////////////////////////////////////////
		// 과제 sort 연산 swap횟수 최소화(한자리 연산에 최대 한번만 일어나게하기)
		////////////////////////////////////////////////////
		int i,j,temp ,tempLoc,count=0;
		for (i = 0; i < nums.length - 1; i++) {
			
			tempLoc = i;
			
			for (j = i + 1; j < nums.length; j++) {
				
				if (sorted[tempLoc] > sorted[j]) {
					tempLoc = j;
				}
				
			}
			
			if(tempLoc != i) {
				temp = sorted[tempLoc];
				sorted[tempLoc] = sorted[i];
				sorted[i] = temp;
				count++;
			}
		}
		System.out.println(Arrays.toString(sorted));
		System.out.println("count="+count);
	}
}
