package day14_ex;

public class Rectangle extends Shape implements Resizable{
	double width;
	double height;
	
	
	public Rectangle() {
		super(4);
	}

	public Rectangle(double w, double h) {
		super(4);
		this.width = w;
		this.height = h;

	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public void resize(double s) {
		this.width = width * s;
		this.height = height * s;
	}
	
	@Override
	double getArea() {
		return width * height;
	}
	
}
