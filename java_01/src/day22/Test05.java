package day22;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test05 {
	public static void main(String[] args) {
		String src = "c:\\lib\\Ben.mp3";
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		System.out.println(" 파일복사 ");
		try {
			fis = new FileInputStream(src);
			//append여부를 정해주면 파일을 덮어쓸지 원본을 유지한채 추가할지 정할 수 있다
			//buffer는 용량이 꽉차면 저장하고 비워지게 된다. 하지만 마지막에서는 꽉차지 않기때문에 저장이 안된다.
			fos = new FileOutputStream("c:\\lib\\copy5.mp3",false);
			
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			int read = 0;
			int count = 0;
			
			while((read = bis.read()) != -1) { 
				bos.write(read);
				count++;
			}
			bos.flush();

			
			
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
