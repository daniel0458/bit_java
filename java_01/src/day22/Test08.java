package day22;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class Test08 {
	public static void main(String[] args) {
		FileReader fis = null;
		BufferedReader bis = null;
		
		try {
			fis = new FileReader("c:\\lib\\dbinfo.txt");
			
			String id = null;
			String pw = null;
			
			String read = null;
			
			bis = new BufferedReader(fis);
			
			while((read =bis.readLine()) != null) {
				String[] data = read.split("=");
				if(data[0].equals("user")) {
					id = data[1];
				}
				if (data[0].equals("pw")) {
					pw =  data[1];
				}
			}
			
			System.out.println("로그인 시도 " + id+ " / " + pw);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
		}
	}
}
