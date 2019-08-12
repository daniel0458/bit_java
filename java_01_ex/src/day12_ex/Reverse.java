package day12_ex;

public class Reverse {
	public static void main(String[] args) {
		System.out.println(reverse("Java Programming"));
	}
	
	public static String reverse(String str) {
		StringBuffer sb = new StringBuffer();
		String reversed;
			for(int i = str.length()-1;i >= 0; i--) {
				sb.append(str.charAt(i)); 
			}
		return sb.toString();
	}
}
