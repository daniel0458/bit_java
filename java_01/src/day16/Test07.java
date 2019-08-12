package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Test07 {
	public static void main(String[] args) {
		System.out.println("main start");
		Scanner sc = null;
		
		try {
			sc = new Scanner(new File("c:\\lib\\sample.txt"));
			while(sc.hasNextLine()) {
				String[] data = sc.nextLine().replace('_','/').split("/");				
				System.out.println(Arrays.toString(data));
			}
		} catch (FileNotFoundException e) {
			System.out.println("예외 발생" + e.getMessage());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (sc != null) {
				sc.close();
				sc = null;
			}
			System.out.println("자원반환");
		}
		
		System.out.println("main end");
	}
}
