package day04;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		/*
		 * System.out.println("알파벳 아스키 코드 값 확인"); char a = 'a'; char capA = 'A'; for(int
		 * i = 0;i < 26;i++ ) {
		 * 
		 * System.out.println(capA + " : " + (int)capA++ + ",\t" + a + " : " +
		 * (int)a++);
		 * 
		 * }
		 */

		/*
		 * 변수 ch에 저장된 문자가 대문자인 경우에만 소문자로 변경하는 코드를 완성
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열을 입력하세요");
		String msg = sc.nextLine();
		sc.close();
		sc = null;
		char ch,ch2,ch3;
		char s;
		for (int i = 0; i < msg.length(); i++) {

			// 대문자 -> 소문자
			/*ch = msg.charAt(i);
			s = ('A' <= ch && ch <= 'Z') ? (char) (ch + 32) : ch;
			System.out.print(s);
			*/
			
			//소문자 => 대문자
			/*ch2 = msg.charAt(i);
			s = ('a' <= ch2 && ch2 <= 'z') ? (char) (ch2 - 32) : ch2;
			System.out.print(s);
			*/
			
			
			//소문자 <=> 대문자
			ch3 = msg.charAt(i);
			if ('A' <= ch3 && ch3 <= 'Z' ) {
				ch3 += 32;
				System.out.print(ch3);
			} else if('a' <= ch3 && ch3 <= 'z') {
				ch3 -= 32;
				System.out.print(ch3);
			}	else {
				System.out.print(ch3);
			}
		}
	}
}
