package day10_ex;

public class PersonTest {
	public static void main(String[] args) {

		Student std = new Student("홍길동", 20, 200201);
		Teacher tch = new Teacher("이순신", 30, "JAVA");
		Employee emp = new Employee("유관순", 40, "교무과");
		
		Person p1 = std;
		Person p2 = tch;
		Person p3 = emp;
		
		((Student)p1).printA();
		((Student)p2).printA();
		((Student)p3).printA();
//		std.printA();
//		tch.printA();
//		emp.printA();
		
	}
	
}
