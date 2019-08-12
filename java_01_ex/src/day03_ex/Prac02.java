package day03_ex;


public class Prac02 {
	public static void main(String[] args) {
		
		char check =args[0].charAt(0);
		System.out.println(check);
		
		if ('0' <= check && check <= '9') {
			System.out.println("숫자");
		} else if ('A' <= check && check <= 'Z') {
			System.out.println("대문자");
		} else if ('a' <= check && check <= 'z') {
			System.out.println("소문자");
		}
	}
}
