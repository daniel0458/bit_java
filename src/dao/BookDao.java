package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.Book;
import util.JDBCUtil;

public class BookDao {
	
	//Book 테이블의 모든 레코드 정보
	public List<Book> getAllBookRec() {
		String sql = "select * from Book";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Book> list = new ArrayList<Book>();
		try {
			con = JDBCUtil.getConnection();
			System.out.println(" ******* con 할당 ******* ");
			ps = con.prepareStatement(sql);
			
			//? 세팅
			//ps.setString(1, x);
			
			//실행및 결과값 핸들링
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Book(rs.getInt("bookid"), 
						rs.getString("bookname"), 
						rs.getString("publisher"),
						rs.getInt("price")
						));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtil.close(con, ps, rs);
			System.out.println(" ******* con 반납 ******* ");
		}
		return list;
	}
	
	public List<Book> getBooknameBookRec(String bookname) {
		String sql = "select * from Book where lower(bookname) like lower('%'||?||'%')";;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Book> list = new ArrayList<Book>();
		try {
			con = JDBCUtil.getConnection();
			System.out.println(" ******* con 할당 ******* ");
			ps = con.prepareStatement(sql);
			
			//? 세팅
			ps.setString(1, bookname);
			
			//실행및 결과값 핸들링
			rs = ps.executeQuery();

			System.out.println("책이름에 (" + bookname + ")가 포함되는 책의 목록");
			while (rs.next()) {
				list.add(new Book(rs.getInt("bookid"), 
						rs.getString("bookname"), 
						rs.getString("publisher"),
						rs.getInt("price")
						));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtil.close(con, ps, rs);
			System.out.println(" ******* con 반납 ******* ");
		}
		return list;
	}
	
	public List<Book> getPublisherBookRec(String publisher) {
		String sql = "select * from Book where lower(publisher) like lower('%'||?||'%')";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Book> list = new ArrayList<Book>();
		try {
			con = JDBCUtil.getConnection();
			System.out.println(" ******* con 할당 ******* ");
			ps = con.prepareStatement(sql);
			
			//? 세팅
			ps.setString(1, publisher);
			
			//실행및 결과값 핸들링
			rs = ps.executeQuery();
			System.out.println("출판사에 (" + publisher + ")가 포함되는 책의 목록");
			while (rs.next()) {
				list.add(new Book(rs.getInt("bookid"), 
						rs.getString("bookname"), 
						rs.getString("publisher"),
						rs.getInt("price")
						));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtil.close(con, ps, rs);
			System.out.println(" ******* con 반납 ******* ");
		}
		return list;
	}
	
	public int insertBook(Book book) {
		String sql = "insert into Book(bookid,bookname,publisher,price) values(?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			//? 세팅
			ps.setInt(1, book.getBookid());
			ps.setString(2, book.getBookname());
			ps.setString(3, book.getPublisher());
			ps.setInt(4, book.getPrice());
			
			//실행및 결과값 핸들링
			//rs = ps.executeQuery();
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result; 
	}
	
	public int updateBook(int bookid) {
		String sql = "update book set price=5000 where bookid = ?";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);

			// ? 세팅
			ps.setInt(1, bookid);
			// ps.setString(1, x);

			// 실행및 결과값 핸들링
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}
	
	public int deleteBook(int bookid) {
		String sql = "delete from book where bookid = ?";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);

			// ? 세팅
			ps.setInt(1, bookid);
			// ps.setString(1, x);

			// 실행및 결과값 핸들링
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}
}
