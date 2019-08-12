package day10;

public class AnimalTest01 {
	public static void main(String[] args) {
		
		Animal a1 = new Animal();
		a1.breath();
		
		Animal a2 = new Animal("Dog");
		a2.breath();
		
		Dog d1 = new Dog("시베리안 허스키","케리");
		d1.breath();
		d1.dogPrint();

		Dog d2 = new Dog("Dog","진돗개","쫑이");
		d2.breath();
		d2.dogPrint();
		
		String animalKind = d2.getSuperKind();
		System.out.println(animalKind);
	}
}
