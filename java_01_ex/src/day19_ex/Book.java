package day19_ex;

public class Book extends Object implements Comparable<Book> {
	private int isbn;
	private String title;
	private int price;
	
	
	
	public Book() {
		super();
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", price=" + price + "]";
	}

	public Book(String title, int price) {
		super();
		this.title = title;
		this.price = price;
	}

	public Book(int isbn, String title, int price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
	}
	public int getISBN() {
		return this.isbn;
	}
	
	public void setISBN(int isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title == null) {
			return;
		}
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public void print() {
		System.out.printf("Book[%10d : %15s : %7d]",isbn,title,price);
	}

	@Override
	public int compareTo(Book o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
