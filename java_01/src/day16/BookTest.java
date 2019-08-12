package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BookTest {
	public static void main(String[] args) {
		Scanner sc = null;

		try {
			sc = new Scanner(new File("sample.txt"));
			while (sc.hasNextLine()) {
				String[] data = sc.nextLine().replace('_', '/').split("/");
				Book book = null;
				try {
					
				book = new Book(data[0], Integer.parseInt(data[1]));				
				} catch (Exception e) {
					// TODO: handle exception
				}	
				System.out.println(book);
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
		
		Book book2 = null;
		try {
			book2 = new Book("java1", -90000);
			System.out.println(book2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
