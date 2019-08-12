package day24_ex;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//bookmgr을 collection기반으로 만들어서 curd되게 구현 
public class BookMgr {

//arraylist,set,map중에 아무거나
	// Book[] 관리 , 리스트타입으로 선언하면 제어권이 컬렉션으로 넘어갔다.
	List<Book> booklist = new ArrayList<Book>();
	String fileName;

	public BookMgr() {
		this("book.dat");
	}

	public BookMgr(String fileName) {
		this.fileName = fileName;
		booklist = (List<Book>) MyFile.load(fileName);
		if (booklist == null) {
			booklist = new ArrayList<Book>();
		}
	}

	public List<Book> getBooklist() {
		return booklist;
	}

	public void setBooklist(List<Book> booklist) {
		this.booklist = booklist;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "BookMgr [booklist=" + booklist + ", fileName=" + fileName + "]";
	}

	// CURD
	public void add(Book data) {
		booklist.add(data);
	}

	public boolean delete(String title) {
		boolean result = false;
		Iterator<Book> it = booklist.iterator();
		while (it.hasNext()) {
			Book data = it.next();
			if (data.getTitle().equals(title)) {
				it.remove();
				result = true;
			}
		}
		return result;
	}

	public void save() {
		MyFile.save(fileName, booklist);
	}

	public List<Book> search(String title) {
		List<Book> result = new ArrayList<Book>();
		Iterator<Book> it = booklist.iterator();
		if(!title.equals("")) {
			while(it.hasNext()) {
				Book data = it.next();
				if(data.getTitle().contains(title)) {
					result.add(data);
				}
			}
		}
		return result;
	}
}