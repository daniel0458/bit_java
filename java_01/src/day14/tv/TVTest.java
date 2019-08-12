package day14.tv;

public class TVTest {
	public static void main(String[] args) {

		play(new STV());
		play(new LTV());
		play(new ITV());
//		TV user = new STV();
//		user.poweron();
//		user.poweroff();
//		
//		user = new LTV();
//		user.poweron();
//		user.poweroff();
	}
	
	public static void play(TV tv) {
		tv.poweron();
		tv.poweroff();		
	}
}
