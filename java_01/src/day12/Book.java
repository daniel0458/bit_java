package day12;

public class Book {
	String title;
	int price;
	
	
	public Book() {
		
	}
	public Book(String title, int price) {
		super();
		this.title = title;
		this.price = price;
	}
	
	public Book(int price,String title) {
		super();
		this.title = title;
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
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
		StringBuilder stb = new StringBuilder();
		
		stb.append("[Book제목: ");
		stb.append(title);
		stb.append("/가격: ");
		stb.append(price);
		stb.append("]");
		return stb.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Book)) {
			return false;
		}
		if(this.price == ((Book)obj).price) {
			return this.title.equals(((Book)obj).title);
		}
		return false;
	}
	
	@Override
	protected void finalize() throws Throwable {
		//객체가 소멸되기 직전에 호출되는 메소드이지만 자바에서는 사용안하고
		//별도의 자원반납 기능을 만들어 사용한다. ex)close()
		
		System.out.println("자원 반납 코드~~~~");
	}
	
	public void close() {
		System.out.println("===자원 반납 ===");
	}
}
