package day02_ex;

public class Prob2 {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		System.out.println(++a); // 11
		System.out.println(++a + b++); //12+20
		System.out.println((++a%3) + (a*++b)); //13%3 + 13 * 22
		
		/*숫자 앞에 ++이있으면 1을 더해준후  연산을 하고 ++이 숫자뒤에 있을경우 연산을 하고 1을 더해준다
		그래서 첫출력에는 10에 1이 더해진 값인 11이 출력되고 a에는 11이 저장된다.
		두번째 출력에는 11인 a값에 1이 더해진 12와 b의 값인20의 합인 32가 출력되고 a에는 12,b에는 21이저장된다.
		세번째 출력에는 13을 3으로 나눈 나머지인 1과 13과 22를 곱한값인 286의 합인 287이 출력된다.*/ 
	}
}
