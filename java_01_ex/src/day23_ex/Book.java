package day23_ex;

import java.io.Serializable;

public class Book implements Comparable<Book>, Serializable{
	private int isbn;
	private String title;
	private int price;
	
	
	
	public Book() {
		super();
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
	
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", price=" + price + "]";
	}

	public void print() {
		System.out.printf("Book[%10d : %15s : %7d]",isbn,title,price);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + isbn;
		result = prime * result + price;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (isbn != other.isbn)
			return false;
		if (price != other.price)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Book o) {
		return title.compareTo(o.title);
	}
	
}
