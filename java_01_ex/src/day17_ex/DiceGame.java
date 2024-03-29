package day17_ex;

class Dice {
	int size;

	Dice(int size) {
		this.size = size;
	}

	int play() {
		int number = (int) (Math.random() * size) + 1;
		return number;
	}
}

public class DiceGame {
	public static void main(String[] args) {
		DiceGame game = new DiceGame();

		int result1;
		try {
			result1 = game.countSameEye(10);
			System.out.println("면의 개수가 8개인 주사위 2개를 던져서 같은" + "눈이 나온 횟수 : " + result1);
		} catch (CountException e) {
			System.out.println("음수 안돼");
		}

		int result2;
		try {
			result2 = game.countSameEye(-10);
			System.out.println("면의 개수가 8개인 주사위 2개를 던져서 같은" + "눈이 나온 횟수 : " + result2);
		} catch (CountException e) {
			System.out.println("음수 안돼");
		}
	}

	int countSameEye(int n) throws CountException {
		int count = 0;
		Dice d1 = new Dice(8);
		Dice d2 = new Dice(8);
		if (n < 0) {
			throw new CountException();
		}
		for (int i = 0; i < n; i++) {
			if (d1.play() == d2.play()) {
				count++;
			}
		}
		return count;
	}

}
