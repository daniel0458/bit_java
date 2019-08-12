package day14;

public class Rectangle extends Shape {
	double hight;
	double width;
	Point p;
	
	
	

	public Rectangle() {
		super();
	}

	public Rectangle(double hight, double width, Point p) {
		super();
		this.hight = hight;
		this.width = width;
		this.p = p;
	}

	public double getHight() {
		return hight;
	}

	public void setHight(double hight) {
		this.hight = hight;
	}

	public Point getP() {
		return p;
	}
	
	public void setP(Point p) {
		this.p = p;
	}
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public void move(int m) {
		p.setX(p.getX()+m);
		p.setY(p.getY()+m);
		
	}

	@Override
	public void draw() {
		System.out.println(getClass().getName() + " 그리기");
	}

	@Override
	double area() {
		return width * hight;
	}

	@Override
	public String toString() {
		return "Rectangle [hight=" + hight + ", width=" + width + ", p=" + p + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(hight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((p == null) ? 0 : p.hashCode());
		temp = Double.doubleToLongBits(width);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangle other = (Rectangle) obj;
		if (Double.doubleToLongBits(hight) != Double.doubleToLongBits(other.hight))
			return false;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
			return false;
		return true;
	}

	
	
}
