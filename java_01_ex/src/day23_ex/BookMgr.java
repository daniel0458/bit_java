package day23_ex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

//bookmgr을 collection기반으로 만들어서 curd되게 구현 
public class BookMgr extends Thread{

//arraylist,set,map중에 아무거나
	List<Book> booklist = null;
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
		book.setISBN(booklist.size() + 1);
		booklist.add(book);
	}

	public Boolean deleteBook(String title) {
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

	public List<Book> printBookList() { // 리스트로 반환

		return booklist;
	}

	public List<Book> searchTitleBook(String title) { // 리스트로 반환
		List<Book> ret = new ArrayList<Book>();
		String comp = title.toLowerCase();
		Iterator<Book> it = booklist.iterator();

		while (it.hasNext()) {
			Book data = it.next();
			if (data.getTitle().toLowerCase().contains(comp)) {
				// System.out.println(data);
				ret.add(data);
			}
		}
		return ret;
	}

}

class SaveLoad {
	public void saveListBook(Object object) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("c:\\lib\\Booklist.txt");
			oos = new ObjectOutputStream(fos);

//			Set<Book> copy = new HashSet<Book>((List<Book>) object);
			
//			oos.writeObject(copy);
			oos.writeObject(object);
			oos.flush();
			System.out.println(object);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
					fos = null;
				}
				if (oos != null) {
					oos.close();
					oos = null;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void loadListBook(List load) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		List<Book> list = null;
		try {
			fis = new FileInputStream("c:\\lib\\Booklist.txt");
			ois = new ObjectInputStream(fis);

			list = (List<Book>) ois.readObject();
			Iterator<Book> it = list.iterator();
			while (it.hasNext()) {
				Book data = it.next();
				load.add(data);
				System.out.println(data);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
					fis = null; 
				}
				if (ois != null) {
					ois.close();
					ois = null;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}