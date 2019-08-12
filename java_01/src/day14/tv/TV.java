package day14.tv;

interface TV {
	public  void poweron();
	public  void poweroff();
	
}

class STV implements TV {
	public  void poweron() {
		System.out.println("STV Poweron");
	}

	public  void poweroff() {
		System.out.println("STV Poweroff");
	}

}

class LTV implements TV {
	public  void poweron() {
		System.out.println("LTV Poweron");
	}

	public  void poweroff() {
		System.out.println("LTV Poweroff");
	}
}

class ITV implements TV{

	@Override
	public void poweron() {
		System.out.println("ITV Poweron");
	}

	@Override
	public void poweroff() {
		System.out.println("ITV Poweroff");
		
	}
	
}