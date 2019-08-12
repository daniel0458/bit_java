package day15;

public class Test02 {
	public static void main(String[] args) {
		A a = new A();
		//a.p();
		
		A.B b= new A("AAA").new B();
		b.print();
		
		//A.C c =new A().new C();
		//c.print();
		A.C.print();
		
	
	}
}

class A {
	String name = "A";
 
	public A() {
		super();
	}

	public A(String name) {
	}

	void p() {
		System.out.println("A 에서 호출");
		new B().print();
	}
	
	class B {
		String name = "B";
		void print() {
			System.out.println("B " + name);
			System.out.println("B " + A.this.name);
		}
	}
	
	static class C {
		static void print() {
			System.out.println("~~~~~~~~~~");
		}
	}
	class D {
		void p() {
			class e {
				
			}
		}
	}
}
