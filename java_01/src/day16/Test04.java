package day16;

import java.io.IOException;

public class Test04 {
	public static void main(String[] args) {
		System.out.println(" main start ");
		int jumsu = 900;
		try {
			 if(!(jumsu >=0 && jumsu <= 100)) {
				 throw new IOException(" jumsu가 유효하지 않습니다."); //괄호안의 문자열이 메세지다
			 }
		} catch (IOException e) {
			System.out.println(e.getMessage()); //에러메세지가 클라이언트 application화면에 출력되야한다.
			//e.printStackTrace();
		} catch (Exception e) {
			
		} finally {
			System.out.println();
		}
		
		System.out.println(" main end ");
	}
}
//throw new RuntimeException(" ~~~ 문제 발생 ~~~");
