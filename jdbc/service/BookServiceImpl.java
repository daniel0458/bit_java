package service;

import java.util.List;

import dao.BookDao;
import dao.BookDao2;
import vo.BookVO;

public class BookServiceImpl implements BookService{
	BookDao2 dao = new BookDao2();
	
	
	

	public BookDao2 getDao() {
		return dao;
	}

	public void setDao(BookDao2 dao) {
		this.dao = dao;
	}

	@Override
	public List<BookVO> booklist() {
		
		return dao.getBookRec();
	}

	@Override
	public int addBook(BookVO vo) {
		return dao.insertBook(vo);
	}

	@Override
	public int deleteBook(int bookid) {
		return dao.deleteBook(bookid);
	}

	@Override
	public int updateBook(BookVO vo) {
		return dao.updateBook(vo);
	}
	
}
