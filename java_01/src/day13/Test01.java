package day13;

import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Formatter;

public class Test01 {
	public static void main(String[] args) throws FileNotFoundException {
		
		Calendar c = Calendar.getInstance();
		System.out.println(c);
		System.out.println("2019년 " + Calendar.DAY_OF_YEAR + "일째");
		
		String date = String.format("현재시간은 %tk시 : %tM분 : %tS초 %n", c,c,c);
		System.out.println(date);
		
		System.out.printf("%f",Math.PI);
		String f = String.format("%f", Math.PI); //String.format이 데이터를  편하게 뽑아낼 수 있다.
		
		StringBuffer sb = new StringBuffer(); // 데이터를 차곡차곡 쌓아 저장이 가능
		//Formatter fm = new Formatter(sb);
		//Formatter fm = new Formatter();
		Formatter fm = new Formatter("sss.txt");
		fm.format("현재시간은 %tk시 : %tM분 : %tS초 %n", c,c,c); //스트링버퍼인 sb에 저장된다.
		fm.format("%f %n",Math.PI);
		System.out.println(sb);
		fm.flush(); //밀어내기
	}
}
