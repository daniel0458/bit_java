package day06;

public class Employee {
	// 데이터(변수) +기능(메소드)

	private String name; // 주소가 저장
	private String dept; // 주소가 저장
	private int age; // 201901 값이 저장

	private boolean single;

	public void setAge(int age) {
		if (!(age > 0 && age <= 100)) {
			System.out.println("age(나이)정보가 올바르지 않습니다.");
			return;
		}
		this.age = age;
		return;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		if(name.length() < 2) {
			System.out.println("다시 입력하세요");
			return;
		}
		
		this.name = name;
		return;
	}

	public String getName() {
		return name;
	}

	public void setDept(String dept) {
		this.dept = dept;
		return;
	}

	public String getDept() {
		return dept;
	}

	public void setSingle(boolean single) {
		this.single = single;
	}

	public boolean isSingle() {
		return single;
	}

	public void display() {
		System.out.printf("[나이:%-10d,이름:%10s,부서:%10s,싱글 :%b]%n", getAge(), getName(), getDept(),isSingle());
		return;
	}
}
