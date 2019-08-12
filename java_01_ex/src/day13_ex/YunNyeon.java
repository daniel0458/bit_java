package day13_ex;

public class YunNyeon {
	public static void main(String[] args) {
		int year = 1700;
		if(year%400 == 0 || year%100 !=0 && year%4 ==0) {
			System.out.println("윤년");		
		}
	}
}
