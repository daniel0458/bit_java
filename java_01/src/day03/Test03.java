package day03;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int jumsu;
		String result;
		String grade = "";

		System.out.println("점수를 입력해주세요: ");
		jumsu = Integer.parseInt(sc.nextLine());
		sc.close();
		sc = null;

		if (!(jumsu >= 0 && jumsu <= 100)) {

			System.out.println(("유효하지 않은 점수다."));
			return;
		}

		result = jumsu >= 80 ? "Pass" : "No Pass";

		/*
		 * if(90<= jumsu && jumsu <100 ) { grade = "A"; } else if(jumsu >= 80) { grade =
		 * "B"; } else if (jumsu >= 70) { grade = "C"; } else if (jumsu >= 60) { grade =
		 * "D"; } else if (jumsu >= 50) { grade = "E"; } else { grade = "F"; }
		 * System.out.printf("점수:%d,%s %s등급",jumsu,result,grade);
		 */

		// 삼항연산자로 처리하기-과제
		grade = 90 <= jumsu && jumsu < 100 ? "A"
				: jumsu >= 80 ? "B" : jumsu >= 70 ? "C" 
				: jumsu >= 60 ? "D" : jumsu >= 50 ? "E" : "F";
		System.out.printf("점수:%d,%s %s등급 %n", jumsu, result, grade);

		/*
		// 등급처리를 switch로
		switch (jumsu / 10) {
		case 10:
		case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		case 5:
			grade = "E";
			break;
		default:
			grade = "F";
			break;
		}
		System.out.printf("점수:%d,%s %s등급", jumsu, result, grade);*/
	}
}
