package day11_ex;

public class Duck {
	String kind;
	String quack;
	
	public Duck() {
		super();
	}

	public Duck(String kind,String quack) {
		super();
		this.kind = kind;
		this.quack = quack;
	}

	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getQuack() {
		return quack;
	}
	public void setQuack(String quack) {
		this.quack = quack;
	}
	
	public void quackquack() {
		System.out.printf("%s는 %s하고 웁니다%n",kind,quack);
	}
}
