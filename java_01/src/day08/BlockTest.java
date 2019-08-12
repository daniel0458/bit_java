package day08;

public class BlockTest {
	public static void main(String[] args) {
		Block b1 = new Block();
		Block b2 = new Block();
		Block b3 = new Block();
		Block b4 = new Block();
		b1.print();
		b2.print();
	}
}

class Block {
	static String name;
	int i, j;
	static {
		// System.out.println("static { }");
		name = "~~~";
	}

	{
		this.j = 99;
		// System.out.println("{ }");
	}

	public Block() {
		// System.out.println("생성자");
	}

	public Block(int i) {
		// System.out.println("생성자");
		this.i = i;
	}

	public void print() {
		System.out.printf("i=%s,j=%s,name=%s", i, j, name);
	}
}