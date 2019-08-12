package day08;

/**
 * 
 * @author KSH
 * @since 2019 07.16
 * @version 1.0
 *
 */
public class Employee {
	static String cName = "BIT";
	private String name;
	private String dept;
	private boolean single;
	
	public Employee() { 
		//기본생성자 = 디폴트 생성자
		this("사원이름","ooo 부서",true);
		//System.out.println("Employee() call");
		/*name = "사원이름";
		dept = "ooo부서";
		single = true;*/
	}
	public Employee(String name,String dept) { 
		//기본생성자 = 디폴트 생성자
		this(name,dept,false); //첫문장에서만 가능 super()가 안옴
		//System.out.printf("Employee(%s,%s) call%n",name,dept);
		//this.name = name;
		//this.dept = dept;
	}	
	public Employee(String name,String dept,boolean single) { 
		//기본생성자 = 디폴트 생성자
		//System.out.printf("Employee(%s,%s,%b) call%n",name,dept,single);
		this.name = name;
		this.dept = dept;
		this.single = single; 
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public boolean isSingle() {
		return single;
	}
	/**
	 * 
	 * @param single 미혼여부
	 */
	public void setSingle(boolean single) {
		this.single = single;
	}
	
	/**
	 * Employee 정보 출력
	 */
	public void print() {
		System.out.printf("사원명:%s, 근무부서:%s, single:%b]%n",name,dept,single);
		
		//System.out.println("회사명 : " + cName);
	}
}

