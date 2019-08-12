package day06;

public class Test02 {
	public static void main(String[] args) {
		//int num;
		//String name;
		
		Employee emp1 = new Employee();
		//System.out.println(emp1.age+":"+emp1.name+":"+emp1.dept);
		
		//객체 = object = instance
		Employee emp2 = new Employee(); //객체생성 
		
		//new Employee(); 템퍼러리객체
		
		emp2.setAge(22);
		emp2.setName("홍길동");
		emp2.setDept("인사부");
		emp2.setSingle(true);
		System.out.println(emp2.getAge()+":"+emp2.getName()+":"+emp2.getDept()+":"+emp2.isSingle());
		//this로 자기자신을 의미하여 쓸 수 있다.
		
		Employee emp3 = new Employee();
		
		emp3.setAge(24);
		emp3.setName("고길동");
		emp3.setDept("영업부");
		emp3.setSingle(false);
		System.out.println(emp3.getAge()+":"+emp3.getName()+":"+emp3.getDept()+":"+emp3.isSingle());

	}
}
