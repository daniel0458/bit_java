package day03_ex;

public class Prac4 {
	public static void main(String[] args) {
		int i,j,k;
		for (i=0; i<5; i++) {
			for (j = 5;j > i+1;j--) {
				System.out.print(" ");
			}
			for (k = 0;k < j;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
