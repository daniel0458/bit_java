package day19_ex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

//bookmgr을 collection기반으로 만들어서 curd되게 구현 
public class BookMgr {

//arraylist,set,map중에 아무거나
	private Map<Integer,Book> booklist;
	int isbn = 1;
	
	public BookMgr() {
		this(10);
	}

	public BookMgr(int size) {
		booklist = new HashMap<Integer,Book>(size);
	}


	public Map<Integer,Book> getBooklist() {
		return booklist;
	}

	public void setBooklist(Map<Integer,Book> booklist) {
		this.booklist = booklist;
	}

	public void addBook(Book book) {
		Set<Integer> set = booklist.keySet();
		book.setISBN(isbn++);
		booklist.put(isbn, book);
	}

	public void deleteBook(String title) {
		Set<Integer> set = booklist.keySet();
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			int data = it.next(); 
			Book book = booklist.get(data);
			if(book.getTitle().equals(title)) {
				booklist.remove(book);
				System.out.println("삭제되었습니다.");
			}
		}
	}

	public void printBookList() {
		System.out.println("=== 책 목록 ===");
		booklist.forEach((t,u) -> System.out.println(u));
		System.out.println("============");
	}

	public void searchTitleBook(String title) {
		String comp = title.toLowerCase();
		Set<Integer> set = booklist.keySet();
		Iterator<Integer> it = set.iterator();
		System.out.println(title + "검색");
		while(it.hasNext()) {
			int data = it.next();
			Book book = booklist.get(data);
			if(book.getTitle().toLowerCase().equals(comp)) {
				System.out.println("ISBN : " + book.getISBN());
				System.out.println("제목 : " + book.getTitle());
				System.out.println("가격 : " + book.getPrice());
			}
		}
	}
}
