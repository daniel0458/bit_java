package day07;

public class CalcTest {
	public static void main(String[] args) {
		
		Calc c1 = new Calc();
		System.out.println(c1.add(11, 99));
		System.out.println(Calc.add(11, 99));
		System.out.println(Calc.add(11, 99));
		System.out.println(Calc.add(11, 99));
		/*System.out.println(Calc.subtract(11, 99));
		System.out.println(Calc.multify(11, 99));
		System.out.println(Calc.divide(11, 99));*/
	}
}
