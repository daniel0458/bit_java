package day16;

public class Test02 {
	public static void main(String[] args) {
		System.out.println(" main strat ");
		String msg = "xmlsfd";
		try {
			if(msg != null ) {
				System.out.println(msg.charAt(3));
				int num = Integer.parseInt(msg);
			}
		} catch (NullPointerException ne) {
			System.out.println("예외발생: " + ne.getMessage()); // null
		} catch (StringIndexOutOfBoundsException se) {
			System.out.println("예외발생: " + se.getMessage()); // String index out of range: 3
		} catch (NumberFormatException e) {
			System.out.println("예외발생: 숫자로 입력" );
		} catch (Exception e) {
			System.out.println("예외 발생: " + e.getMessage());
		} finally {
			System.out.println("finally {자원 반납 코드}");
		}
		System.out.println(" main end");
	}
}
