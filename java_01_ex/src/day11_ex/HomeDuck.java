package day11_ex;

public class HomeDuck extends Duck{
	String quack;

	public HomeDuck(String kind, String quack) {
		super(kind,quack);
	}
	
	public String getQuack() {
		return quack;
	}

	public void setQuack(String quack) {
		this.quack = quack;
	}
	
	
}
