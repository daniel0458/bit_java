package day11;

import day10.Animal;
import day10.Dog;

public class AnimalTest {
	public static void main(String[] args) {
		Animal d = new Dog("진돗개","쭁이");
		if(d instanceof Dog) {
			((Dog) d).dogPrint(); {
		}
		
		Dog dd =(Dog) d;
			
		}
		d.breath();
		
		Animal f = new Fish("연어","살몬");
		if (f instanceof Fish) {
			((Fish) f).fishPrint();
		}
		f.breath();
		((Fish)f).breath(); 
	}
}
