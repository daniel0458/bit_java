package day11;

public class Test04 {
	public static void main(String[] args) {
		String msg1 = "hello";
		String msg2 = "hello";
		
		System.out.println(msg1.toString());
		System.out.println(msg2.toString());
		
		Book b1 = new Book("Java",700);
		Book b2 = new Book("Java",700);
		
		System.out.println(b1.toString());
		System.out.println(b2.toString());
		
	}
}

class Book extends Object{
	String title;
	int price;
	StringBuilder stb = new StringBuilder();
	public Book() {
		
	}
	
	public Book(String title,int price) {
		this.title = title;
		this.price = price;
	}
	
	public String toString() {
		stb.append("[Book제목: ");
		stb.append(title);
		stb.append("/가격: ");
		stb.append(price);
		stb.append("]");
		return stb.toString();
	}
	
}

