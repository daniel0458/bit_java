package day11_ex;

public class DuckTest {
	public static void main(String[] args) {

		Duck[] d = { new Duck("일반오리","꽥"), new HomeDuck("집오리", "꽉"), new ToyDuck() };

		for (Duck data : d) {
			data.quackquack();
		}
	}

}