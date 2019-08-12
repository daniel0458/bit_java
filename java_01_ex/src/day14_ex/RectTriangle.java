package day14_ex;

public class RectTriangle extends Shape{

	double width;
	double height;
	
	
	public RectTriangle() {
		super(3);
	}


	public RectTriangle(double w, double h) {
		super(3);
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
	double getArea() {
		
		return width * height/2;
	}

}
