package day22;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test04 {
	public static void main(String[] args) {
		String src = "c:\\lib\\Ben.mp3";
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		System.out.println(" 파일복사 ");
		try {
			fis = new FileInputStream(src);
			//append여부를 정해주면 파일을 덮어쓸지 원본을 유지한채 추가할지 정할 수 있다
			fos = new FileOutputStream("c:\\lib\\copy4.mp3",false);
			
			int read = 0;
			int count = 0;
			
			byte[] buffer = new byte[1024*1024];//파일크기만큼 버퍼를 만들어서 넣고 버퍼를 복사, 이 경우 용량이 너무 크면 시스템이 죽을 수 있다.
			
			while((read = fis.read(buffer)) != -1) /*읽을 값이 없다면 */{
				// fis.read 는 1byte씩 읽는다
				System.out.println("read :" + read);
				fos.write(buffer,0,read);
				count++;
			}
			System.out.println("I/O횟수 : " + count);
			System.out.println(" 파일복사완료 ");
			
		} catch (FileNotFoundException e) {
			System.out.println("원본파일을 확인해주세요");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) fis.close();
				if(fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
		System.out.println("main end");
	}
}
