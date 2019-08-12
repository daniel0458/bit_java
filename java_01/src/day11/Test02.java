package day11;

public class Test02 {
	public static void main(String[] args) {
		Object[] p = { new Student("홍길동", 20, 200201), new Teacher("이순신", 30, "JAVA")
				, new Employee("유관순", 40, "교무과"),"~~~~~","oooooo" };
		
		
		for (Object data : p) {
			//data.printA();		//부모 Person() 영역의 자원을 접근할때는 바로 접근 가능 
			System.out.println();
		}

		System.out.println("===========================================");

		for (Object data : p) {
			//자식 영역의 자원을 접근할 때는 다운캐스팅 필요
			//반드시 하단부에 어떤 객체가 바인딩 되어있는지 타입체크 필요
			if(data instanceof Student)((Student)data).printA();
			if(data instanceof Teacher)((Teacher)data).printA();
			if(data instanceof Employee)((Employee)data).printA();
			if(data instanceof String) System.out.println((String)data);
		}

//		Person p1 = std;
//		Person p2 = tch;
//		Person p3 = emp;
//		
//		((Student)p1).printA();
//		((Teacher)p2).printA();
//		((Employee)p3).printA();
//		std.printA();
//		tch.printA();
//		emp.printA();
	}
}
