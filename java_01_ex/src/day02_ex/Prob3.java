package day02_ex;

public class Prob3 {
	public static void main(String[] args) {
		int a,b;
		a = b = 10;
		
		/*++a > b++ 은 11>10 은 true이므로 c는 true이고 여기서 or연산이 끝난다. 
		연산이 끝난후 각각 한번씩만 더해졌으므로 a,b에는 각각 11이 저장된다.*/ 
		boolean c = ++a > b++  || a++ >= ++b; 
		System.out.println(a+","+b);
		System.out.println("변수 c의 값:"+c);

	}
}
