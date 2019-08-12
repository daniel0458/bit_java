package day11;

public class Student extends Person{
	private int id;
	
	public Student() {
		super();
	}

	public Student(String name, int age, int id) {
		super(name,age);
		this.id = id;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id; 
	}
	@Override

	public void printA( ) {
		super.printA();
		System.out.printf(" 학번 : %d%n",id);
	}
	
}
