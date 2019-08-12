package day09;

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

	public int getBookCount() {
		return bookCount;

	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;

	}

	public void addBook(Book book) {
		if (bookCount > booklist.length - 1) {
			Book[] copy = new Book[booklist.length * 2];
			System.arraycopy(book, 0, copy, 0, booklist.length - 1);
			booklist = copy;
			System.out.println("배열이 꽉찼습니다.");
			return;

		}
		booklist[bookCount] = book;
		bookCount++;

	}

	public void deleteBook(String title) {

		for (int i = 0; i < bookCount; i++) {
			if (booklist[i].getTitle().equals(title)) {

				System.arraycopy(booklist, i + 1, booklist, i, bookCount - i - 1);
				
				booklist[--bookCount] = null;
				System.out.println("삭제되었습니다.");

			}

		}
	}

	public void printBookList() {
		StringBuffer buf = new StringBuffer();

		System.out.println("=== 책 목록 ===");
		for (int i = 0; i < bookCount; i++) {
			System.out.println(booklist[i].getTitle());
		}
		buf.append("총");
		buf.append(bookCount);
		buf.append("권");

		System.out.println(buf);
		System.out.println("============");

	}

	public void searchTitleBook(String title) {
		String comp = title.toLowerCase();
		// System.out.println(comp);
		System.out.println(title + "검색");
		for (Book data:booklist) {
			if(data == null) {
				return;
			}
			
			if (data.getTitle().toLowerCase().contains(comp)) {
				System.out.println("제목 :" + data.getTitle());
//				System.out.println("가격 " + data[i].getPrice());
			}
		}

//		for (int i = 0; i < bookCount; i++) {
//			if (booklist[i].getTitle().toLowerCase().contains(comp)) {
//				System.out.println("제목 " + booklist[i].getTitle());
//				//System.out.println("가격 " + booklist[i].getPrice());
//			}
//		}
	}

	/*
	 * public void printTotalPrice() { int sum = 0; for (int i = 0; i < bookCount;
	 * i++) { sum += booklist[i].getPrice(); }
	 * System.out.println("=== 책 가격의 총합 ==="); System.out.println("전체 책 가격의 총합 : " +
	 * sum); }
	 */

}
