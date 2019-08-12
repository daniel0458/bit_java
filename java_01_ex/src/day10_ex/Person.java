package day10_ex;

public class Person {
	private String name;
	private int age;
	public Person() {
		super();
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void printA() {
		System.out.printf("이 름 : %s\t나이 : %d",name,age);
	}
	
}
