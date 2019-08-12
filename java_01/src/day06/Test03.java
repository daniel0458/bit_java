package day06;

public class Test03 {
	public static void main(String[] args) {
		//int num;
		//String name;
		
		Employee emp1 = new Employee();
		emp1.display();
		
		//new Employee(); 템퍼러리객체
		//객체 = object = instance
		Employee emp2 = new Employee(); //객체생성 
				
		emp2.setAge(31);
		emp2.setName("홍길동");
		emp2.setDept("인사부");
		emp2.setSingle(false);
		emp2.display();	
		
		//this로 자기자신을 의미하여 쓸 수 있다. 
		//this키워드는 heap영역에서만 사용가능
		  
		Employee emp3 = new Employee();
		
		emp3.setAge(27);
		emp3.setName("고길동");
		emp3.setDept("영업부");
		emp3.setSingle(true);
		emp3.display();
	}
}
