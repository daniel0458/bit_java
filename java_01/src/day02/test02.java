package day02;

public class test02 {
	public static void main(String[] args) {
		int num = 'A';
		char a1 = (char)num;
		char a2 = 'A';
		String name = "abc";
		String address = new String("비트교육센터");
		long number = 999999999999999999L;
		
		System.out.println(address.length());
		System.out.println(name.charAt(2));
		System.out.println('A' + 'B');
		System.out.println( a1+ " = " + num + "in ASCII");
		System.out.println((int)a2);
		System.out.println((char)90);
		
		System.out.println(number);
	}
}
