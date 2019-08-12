package day08;

import day07.Employee;

public class EmployeeTest {
	public static void main(String[] args) {
		Employee emp1 = new Employee("고길동","영입부",false);
		emp1.print();
		Employee emp2 = new Employee("김길동","영업부");
		emp2.print();		
		Employee emp3 = new Employee("최길동","기술부",false);
		emp3.print();
		Employee emp4 = new Employee();
		emp4.print();
		
	}
}
