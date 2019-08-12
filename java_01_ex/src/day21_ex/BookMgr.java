package day21_ex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//bookmgr을 collection기반으로 만들어서 curd되게 구현 
public class BookMgr {
	

	

//arraylist,set,map중에 아무거나
	private List<Book> booklist = null;
	int isbn = 1;

	public BookMgr() {
		booklist = new ArrayList<Book>();
	}

	public BookMgr(int size) {
		booklist = new ArrayList<Book>(size);
	}

	public List<Book> getBooklist() {
		return booklist;
	}

	public void setBooklist(List<Book> booklist) {
		this.booklist = booklist;
	}

	public void addBook(Book book) {
//		Iterator<Book> it = booklist.iterator();
//		while(it.hasNext()) {
//			Book data = it.next(); 
//			if(data.getISBN() == book.getISBN())
//				System.out.println("이미 존재하는 번호입니다.");
//				return;
//		}
		book.setISBN(isbn++);
		booklist.add(book);
	}

	public void deleteBook(String title) {
		Iterator<Book> it = booklist.iterator();
		while (it.hasNext()) {
			Book data = it.next();
			if (data.getTitle().equals(title)) {
				it.remove();
				System.out.println("삭제되었습니다.");
			}
		}
	}

	public List<Book> printBookList() {		//리스트로 반환
		
		return booklist;
	}

	public List<Book> searchTitleBook(String title) {			//리스트로 반환
		List<Book> ret = new ArrayList<Book>();
		String comp = title.toLowerCase();
		Iterator<Book> it = booklist.iterator();
		
		while (it.hasNext()) {
			Book data = it.next();
			if (data.getTitle().toLowerCase().contains(comp)) {
				//System.out.println(data);
				ret.add(data);
			}	
		}
		return ret;
	}
}
