package APP;

import service.BookService;

public class BookApp {	
	public static void main(String[] args) {
		//dao는 db연동에 관한 코드를 가지고있기때문에 직접적으로 쓰면안된다.
		
		BookService service = null;
//		service.addBook(vo);
		
		service.booklist().forEach(i->System.out.println(i));
	}
}
