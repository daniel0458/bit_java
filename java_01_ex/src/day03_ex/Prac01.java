package day03_ex;

import java.util.Scanner;

public class Prac01 {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력해 주세요: ");
		int age = sc.nextInt();
		sc.close();
		sc = null;
		System.out.println((age/10)+"0대");
	}
}
