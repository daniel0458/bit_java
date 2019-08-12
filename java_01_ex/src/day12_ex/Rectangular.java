package day12_ex;

public class Rectangular extends Shape{
	private double width;
	private double hight;
	
	
	
	public Rectangular() {
		super();
	}



	public Rectangular(String name, double width, double hight) {
		super(name);
		this.width = width;
		this.hight = hight;
	}



	public double getWidth() {
		return width;
	}



	public void setWidth(double width) {
		this.width = width;
	}



	public double getHight() {
		return hight;
	}



	public void setHight(double hight) {
		this.hight = hight;
	}



	@Override
	public void calculationArea() {
		super.area = width * hight;
	}
	
	
}
