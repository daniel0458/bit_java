package day14_ex;

public abstract class Shape {
	private int numSides;

	public Shape() {
		super();
	}

	public Shape(int numSides) {
		super();
		this.numSides = numSides;
	}

	public int getNumSides() {
		return numSides;
	}

	public void setNumSides(int numSides) {
		this.numSides = numSides;
	}
	
	abstract double getArea();
	
}
