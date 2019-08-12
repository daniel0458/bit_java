package day14;

public class Circle extends Shape implements Cloneable{
	int radius;
	public Point p;
	
	
	
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
		
		return "Circle [radius=" + radius + " " + p.toString() + "]";
	}


	@Override
	public double area () {
		return radius * radius * Math.PI;
	}

	@Override
	public void draw() {
		System.out.println(getClass().getName() + " 그리기");
	}

	@Override
	public void move(int m) {
		
		p.setX(p.getX()+m);
		p.setY(p.getY()+m);
	}
	
	@Override
	public Circle clone() throws CloneNotSupportedException {
		Circle c1 = (Circle)super.clone();
		c1.p = c1.p.clone();
		return c1 ;
	}
}
interface DrawAndMove extends Drawable,Movable {
	
}

interface Drawable {
	public abstract void draw();
}

interface Movable {
	void move(int m);
}

abstract class Shape implements DrawAndMove{
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