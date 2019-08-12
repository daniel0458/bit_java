package day06_ex;

public class AnimalTest {
	public static void main(String[] args) {
		Animal am1 = new Animal();
		am1.setName("큰뿔소");
		am1.age = 3;
		am1.setLive(true);
		System.out.println("이름 :" + am1.getName() + ", 생존여부 :" + am1.isLive());
		
		am1.setName("펭귄");
		System.out.println("이름 :" + am1.getName() + ", 생존여부 :" + am1.isLive());
		
		/*Animal am2 = new Animal();
		am2.setName("펭귄");
		am2.age = 3;
		am2.setLive(true);
		System.out.println("이름 :" + am2.getName() + ", 생존여부 :" + am2.isLive());*/
	}
}
