package day22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test06 {
	public static void main(String[] args) {
		System.out.println(" 파일 복사 .txt");
	
		String src = "c:\\lib\\sample.txt";
		
		FileReader fr = null;
		FileWriter fw = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			fr = new FileReader(src);
			fw = new FileWriter("c:\\lib\\samplecopy.txt");
			
			String read = null;
			
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			
			while((read = br.readLine()) != null) {
				bw.write(read+"\r\n"); // \r\n이 줄바꿈문자이다
			}
			bw.flush();
			System.out.println("파일 기록완료");
		} catch (FileNotFoundException e) {
			System.out.println(src + "파일(복사원본) 확인해주세요");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) {
					br.close();
					br = null;
				}
				if(bw != null) {
					bw.close();
					bw = null;
				}
				if(fr != null) {
					fr.close();
					fr = null;
				}
				if(fw != null) {
					fw.close();
					fw = null;
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
}
