package day19_ex;


import javax.swing.JOptionPane;

/**
 * 
 * @author user
 *
 */
public class BookApp {
	public static void main(String[] args) {
		
		BookMgr booklist = new BookMgr(10);
		String button;
		String work = null;
		String yn;
		String pricestr;
		
		while (true) {
			System.out.println("*******  명령 선택   *******");
			System.out.println("1. insert(등록)\n");
			System.out.println("2. delete(삭제)\n");
			System.out.println("3. 목록 출력\n");
			System.out.println("4. search(검색)\n");
			System.out.println("5. quit(종료)\n");
			System.out.println("*************************\n");
			System.out.println("수행할 명령을 선택하세요!");
			button = JOptionPane.showInputDialog("\"1 2 3 4 5 중 하나를 선택하세요.. _\"");
			if(button == null) { 
				return;
			}
			switch (button) {
			case "1":
				String title;
				int price;
//				isbn = Integer.parseInt(JOptionPane.showInputDialog("ISBN번호를 입력하세요:"));
//				System.out.println(isbn);
//				if(isbn == 0) {
//					break;
//				}
				title = JOptionPane.showInputDialog("제목을 입력하세요: ");
				if(title == null) {
					break;
				}
				pricestr = JOptionPane.showInputDialog("가격을 입력하세요: ");
				if(pricestr == null) {
					break;
				}
				price = Integer.parseInt(pricestr);
				
				work = "등록";
				booklist.addBook(new Book(title, price));
				break;
			case "2":
				work = "삭제";
				title = JOptionPane.showInputDialog("삭제할 책의 제목을 입력하세요: ");
				booklist.deleteBook(title);
				break;
			case "3":
				work = "목록 출력";
				booklist.printBookList();
				break;
			case "4":
				work = "검색";
				title = JOptionPane.showInputDialog("검색할 책의 제목을 적으세요");
				booklist.searchTitleBook(title);
				break;
			case "5":

				yn = JOptionPane.showInputDialog("정말 종료하시겠습니까? Y/N").trim();
				if (yn.equals("Y") || yn.equals("y")) {
					System.exit(0);
				} else {
					break;
				}
			default:
				continue;
			}

			System.out.printf("%s 작업을 수행합니다.%n", work);

		}

	}
}

