package day14_ex;


public class ShapeTest {
	public static void main(String[] args) {

		Rectangle rtang = new Rectangle(5, 6);
		RectTriangle rtri = new RectTriangle(6, 2);
		Shape[] s = { rtang, rtri };
		for (Shape data : s) {
			System.out.printf("area: %.1f%n",data.getArea());
			/*if (data.getNumSides() == 4){				//기존에 생각한 방식
				((Rectangle)data).resize(0.5);*/
			if(data instanceof Resizable) { 			//다른사람의 방식에서 착안
				((Resizable)data).resize(0.5);
				System.out.printf("new area: %.1f%n", data.getArea());
			}
		}
	}
}
