package day05;


public class Test06 {
	
	public static void main(String[] args) {
		
		int[][] t1 = new int[4][];
		t1[0] = new int[4];
		System.out.println(t1[0]);
		System.out.println(t1[0][0]);
		
		int[][] t2 = {{1,2,3,4,5},{44,66,77,99,99,55,66},{11,22}};
		
		for(int i = 0;i < t2.length; i++) {
			for(int j = 0;j < t2[i].length;j++) {
				System.out.print(t2[i][j]+" ");
			}
			System.out.println();
		}
		
		char[][] s = {
				{'x','x','x','x','x','x','x','x','x'},
				{'x','x','x','x','x','x','x','x','x'},
				{'x','x','x','o','x','x','x','x','x'},
				{'x','x','x','x','o','x','x','x','x'},
				{'x','x','x','x','x','x','x','x','x'},
				{'x','x','x','x','x','x','x','x','x'},
				{'x','x','x','x','x','x','x','x','x'},
		};
		
		for(int i = 0;i < s.length; i++) {
			for(int j = 0;j < s[i].length;j++) {
				if(s[i][j] == 'o') {
					System.out.println((i+1)+"행"+(j+1)+"열은 예약석입니다" );
				}
			}
		}
	}
}