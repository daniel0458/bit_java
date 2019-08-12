package day08_ex;


public class BookMgr {
	private Book[] booklist;
	private int bookCount = 0;
	
	public BookMgr(int size) {
		booklist = new Book[size];
	}
	
	public Book[] getBooklist() {
		return booklist;
	}

	public void setBooklist(Book[] booklist) {
		this.booklist = booklist;
	}

	public void addBook(Book book) {
		if(bookCount > booklist.length-1) {
			Book[] copy = new Book[booklist.length*2];
			System.arraycopy(book, 0, copy, 0, booklist.length-1);
			booklist = copy;
			System.out.println("배열이 꽉찼습니다.");
			return;
		}
		booklist[bookCount] = book;
		bookCount++;
	}
	
	public void printBookList() {
		System.out.println("=== 책 목록 ===");
		for (int i = 0; i < bookCount; i++) {
			System.out.println(booklist[i].getTitle());
		}
	}
	public void printTotalPrice() {
		int sum = 0;
		for (int i = 0; i < bookCount; i++) {
				sum += booklist[i].getPrice();
		}
		System.out.println("=== 책 가격의 총합 ===");
		System.out.println("전체 책 가격의 총합 : " + sum);
 	}
}
