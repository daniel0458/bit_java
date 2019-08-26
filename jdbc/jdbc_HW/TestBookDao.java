package jdbc_HW;

import dao.BookDao;
import test.Book;

public class TestBookDao {
	public static void main(String[] args) {
		BookDao bdao = new BookDao();
		Book book = new Book(3,"sql","hansung",4500);		
		int count;
//		
//		count = bdao.insertBook(book);
//		count = bdao.updateBook(3);
//		count = bdao.deleteBook(3);
//		System.out.println(count + " 완료 ");

		bdao.getAllBookRec().forEach(i->System.out.println(i));
		bdao.getBooknameBookRec("j").forEach(i->System.out.println(i));
		bdao.getPublisherBookRec("bi").forEach(i->System.out.println(i));
	}
}
