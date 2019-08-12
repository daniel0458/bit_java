package day12;

public class BookTest {
	public static void main(String[] args) {
		String msg1 = "he ll o";
		String msg2 = "hello";
		System.out.println(msg1);
		System.out.println(msg2);
		
		System.out.println(msg1.equals(msg2));
		
		Book b1 = new Book("java",2200);
		Book b2 = new Book("java",2200);
		System.out.println(b1);
		System.out.println(b2);
		//System.out.println(b1.equals(b2));
		
		b1 = null;		//close메소드를 자원반납한 후 null로 바꿔주면 언젠가 gc가 작동하면서 처리함
		b2 = null;		//null로 안바꿔주면 gc를 돌려도 반납이 안되고 메모리를 먹는다
		System.gc();	//가비지 콜렉터 호출함수
		
		System.out.println("=== main end ====");
	}
	
	
}
