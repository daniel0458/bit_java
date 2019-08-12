package day14;

public class InterfaceCircleTest {
	public static void main(String[] args) {
		Circle c1 = new Circle(new Point(4,4),3);
		Rectangle r1 = new Rectangle(3, 7, new Point(11,11));

//		System.out.println(c1);
//		System.out.println(r1);
//		c1.move(1);
//		r1.move(3);
//		System.out.println(c1);
//		System.out.println(r1);
//		System.out.println(r1.area());
//		c1.draw();
//		r1.draw();
		
		Shape[] s = {c1,r1};
		for (Shape data:s) {
			System.out.println(data);
			System.out.println(data.area());
			((Movable)data).move(1);
			((Drawable)data).draw();
			System.out.println(data);
		}
	}
}
