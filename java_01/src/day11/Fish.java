package day11;

import day10.Animal;

public class Fish extends Animal {

	private String name;

	public Fish() {
		super();
	}

	public Fish(String kind, String name) {
		super(kind);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void fishPrint() {
		System.out.printf("[%s : %s]%n", kind, name);
	}

	@Override
	public void breath() {
		System.out.printf("%s : 아가미로 숨쉬기~~~%n", kind);
	}

	@Override
	public void print() {
		super.print();
		System.out.printf("%s]%n",name);
	}
}
