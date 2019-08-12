package day17;

import day16.Book;

public class BookTest {
	public static void main(String[] args) {
		
		Book b1 = new Book();
		b1.setTitle("java");
		try {
			b1.setPrice(-9000);
		} catch (PriceException e) {
			System.out.println(e.getMessage());
			System.err.println(e.getMessage()); ///out과 다른 스트림사용해서 랜덤한 위치에 출력된다.
		}
		System.out.println(b1);
		System.out.println("=================================================");
		
		Book b2 = null;
		try {
			b2 = new Book("jsp", -99900);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		System.out.println(b2);
		
	}
}
