package day13_ex;

import java.util.StringTokenizer;

public class Token {
	public static void main(String[] args) {
		String str = "홍길동 _ 이순신_김유신 /박철 ";
		//str = str.replaceAll(" ", "");
		StringTokenizer st = new StringTokenizer(str,"_/ ");
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.print(token.charAt(0));
			for(int i = 1;i < token.length(); i++) {
				System.out.print("*");
			}
			System.out.print(" ");
		}
		
	}
}
