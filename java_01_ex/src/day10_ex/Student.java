package day10_ex;

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
	
	public void printA( ) {
		super.printA();
		System.out.printf(" 학번 : %d%n",id);
	}
	
}
