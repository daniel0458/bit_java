package day11;

import day10.Animal;
import day10.Dog;

public class AnimalTest2 {
	public static void main(String[] args) {
		Animal[] animals = {
				new Dog("진돗개","쫑이"),
				new Fish("물고기","구피"),
				new Dog("시베리안허스키","케리")
		};
		for(Animal data: animals) {
			callD(data);
			data.print();
		}
		Dog a1 = new Dog("진돗개","쫑이");
		Fish f1 = new Fish("물고기","구피");
				 
//		callD(a1);
//		callD(f1);
//		callD(animals[0]);
	}
	
//	public static void callD(Dog d) {
//		d.breath();
//	}
//	
//	public static void callD(Fish d) {
//		d.breath();
//	}
	public static void callD(Animal d) {
		d.breath();
	}
}
