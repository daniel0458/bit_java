package day04_ex;

public class Prob3 {

	public static void main(String[] args) {
		String sourceString = 
		"everyday we have is one more than we deserve";
		String encodedString = "";
		
		// 프로그램을 구현부 시작.	
		// 참고 : 문자 'a'의 정수값은 97이며, 'z'는 122입니다. 
		for(int i =0; i < sourceString.length();i++) {
			char source = sourceString.charAt(i);
			
			if(source >= 'a' && source <= 'w') {
				encodedString += (char)(source + 3);
				
			} else if('x' <= source && source <= 'z') {
				encodedString += (char)(source -23);
				
			} else {
				encodedString += source;				
			}
		}// 프로그램 구현부 끝.
		
		System.out.println("암호화할 문자열 : " + sourceString);
		System.out.println("암호화된 문자열 : " + encodedString);
		
		System.out.println("==========================================================");
		int sum = 0;
		for(int i = 1; i <= 10; i++) {
			
			for(int j = 1; j <= i; j++) {
				sum += j;
			}
		}
		System.out.println("1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+10)= "+sum);
 	}
}
