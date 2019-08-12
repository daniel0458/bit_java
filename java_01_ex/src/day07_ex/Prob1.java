package day07_ex;

public class Prob1 {
	public static void main(String args[]) {
		Prob1 prob1 = new Prob1();
		
		System.out.println( prob1.leftPad("bit", 6, '#') );
		System.out.println( prob1.leftPad("bit", 5, '$') ); 
		System.out.println( prob1.leftPad("bit", 2, '&') ); 
		System.out.println( prob1.rightPad("bit", 6, '#') );
		System.out.println( prob1.rightPad("bit", 5, '$') ); 
		System.out.println( prob1.rightPad("bit", 2, '&') ); 
	}
	public String leftPad(String str, int size, char padChar) {
		/*  여기에 프로그램을 완성하십시오. */
		if (size <= str.length()) {
			return str;
		}
		while(size > str.length()) {
			str = padChar + str;
		}
		return str;
	}
	
	public String rightPad(String str, int size, char padChar) {
		/*  여기에 프로그램을 완성하십시오. */
		if (size <= str.length()) {
			return str;
		}
		while(size > str.length()) {
			str = str + padChar;
		}
		return str;
	}
}