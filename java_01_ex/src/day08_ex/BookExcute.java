package day08_ex;

import java.util.Scanner;

public class BookExcute {
	public static void main(String[] args) {
		BookMgr blist = new BookMgr(100);
		Scanner sc = new Scanner(System.in);
//		System.out.println("책의 이름과 값을 입력해 주세요:");
//		blist.addBook(new Book(sc.nextLine(),sc.nextInt()));
//		sc.nextLine();
//		System.out.println("책의 이름과 값을 입력해 주세요:");
//		blist.addBook(new Book(sc.nextLine(),sc.nextInt()));
		blist.addBook(new Book("JAVA Program",25000));
		blist.addBook(new Book("JSP Program",37000));
		blist.addBook(new Book("SQL Fundamentals",22000));
		blist.addBook(new Book("JDBC Program",18000));
		blist.addBook(new Book("EJB Program",30000));
		blist.printBookList();
		System.out.println();
		blist.printTotalPrice();
		
		sc.close();
		sc = null;
	}
}
