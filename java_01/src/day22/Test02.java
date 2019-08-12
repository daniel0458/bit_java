package day22;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Test02 {
	public static void main(String[] args) {
		String src = "c:\\lib\\Ben.mp3";
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		System.out.println(" 파일복사 ");
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream("c:\\lib\\copy.mp3");
			
			int read = 0;
			int count = 0;
			
			while((read = fis.read()) != -1) /*읽을 값이 없다면 */{
				fos.write(read);
				count++;
			}
			System.out.println("I/O횟수 : " + count);
			System.out.println(" 파일복사완료 ");
			
		} catch (FileNotFoundException e) {
			System.out.println("원본파일을 확인해주세요");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
}
