package day03_ex;

public class Prac03 {
	public static void main(String[] args) {
		
		for (int i = 1; i < 10; i++) {
			
			for (int j = 2; j < 10; j++) {
				
				//System.out.printf("%d*%d=%d\t",j,i,j*i);
				System.out.print(j + "*" + i +"=" + i*j+"\t");
			}
			System.out.println("\n");
		}
	}
}
