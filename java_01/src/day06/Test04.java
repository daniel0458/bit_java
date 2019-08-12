package day06;


public class Test04 {
	public static void main(String[] args) {
		
		Employee emp1 = new Employee();
		
		Employee emp2 = new Employee(); //객체생성 
		emp2.setAge(31);
		emp2.setName("홍길동");
		emp2.setDept("인사부");
		emp2.setSingle(false);
		
		Employee emp3 = new Employee();
		emp3.setAge(27);
		emp3.setName("고길동");
		emp3.setDept("영업부");
		emp3.setSingle(true);

		Employee emp4 = new Employee();
		emp4.setAge(28);
		emp4.setName("김길동");
		emp4.setDept("영업부");
		emp4.setSingle(true);
		
		Employee[] emp = {emp1,emp2,emp3,emp4};
		System.out.println("== 영업부에 근무하는 사원 목록==");
		for(Employee data: emp) {
			if(data.getDept() != null && data.getDept().equals("영업부")) {
				data.display();
			} 
		}
		
		System.out.println("== 싱글인 사원 목록==");
		for(int i = 0;i < emp.length;i++) {
			if(emp[i].isSingle()) {
				emp[i].display();
			}
		}
	}
}
