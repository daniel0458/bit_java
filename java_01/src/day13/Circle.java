package day13;

public class Circle extends Shape implements Drawable{
	int radius;
	Point p;
	
	
	
	public Circle() {
		super();
	}

	public Circle(Point p, int radius) {
		super();
		this.radius = radius;
		this.p = p;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + radius;
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
		Circle other = (Circle) obj;
		if (radius != other.radius)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}


	@Override
	public double area () {
		return radius * radius * Math.PI;
	}

	@Override
	public void draw() {
		System.out.println(getClass().getName() + " 그리기");
	}
}
interface Drawable {
	/*public abstract*/ void draw();
}
abstract class Shape {
	abstract double area();
}
//public class Circle implements Shape{
//	int radius;
//	
//	public double area () {
//		return radius * radius * Math.PI;
//	}
//}
//
//interface Shape {
//	public double area();
//}