package day23;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		String str = "1 and 2 and animal and lion and tiger";
		Scanner scan = new Scanner(str);
		scan = scan.useDelimiter("\\s*and\\s*"); // \\s*and\\s*의 의미는 and의 앞 뒤로 빈 공백인 \s가 0개 이상만큼이라는 의미이다
												// * : 0개이상, \s : 빈칸	 
		int firstToken = scan.nextInt();
		int secondToken = scan.nextInt();
		String thirdToken = scan.next();
		String fourthToken = scan.next();
		String fifthToken = scan.next();
		System.out.printf("%d,%d,%s,%s,%s",firstToken,secondToken,thirdToken,fourthToken,fifthToken);
		scan.close();
	}
}
