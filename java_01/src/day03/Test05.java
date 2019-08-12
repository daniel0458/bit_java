package day03;

public class Test05 {
	public static void main(String[] args) {
		
		int i;
		for (i = 0; i < 10; i++) {
			
			System.out.printf("Hello java %d\n",i+1);
		}
		
		int j = 10;
		while(j > 0 ) {
			System.out.println("while" + j);
			j--;
		}
		
		boolean flag = true;
		while(flag) {
			j++;
			System.out.println("~~~~~~~~~" + j);
			if(j == 5) flag = !flag;
		}
		System.out.println("j : " + j);
		
		while(j<5) {
			System.out.println("do while"); //동작x
		}
		
		do {
			System.out.println("do while");
			
		} while(j<5); 
		
		
	}
}
