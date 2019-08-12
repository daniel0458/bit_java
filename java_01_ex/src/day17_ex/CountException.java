package day17_ex;

public class CountException extends Exception{
	
	public CountException() {
		super("Counter Error");
	}
	public CountException(String msg) {
		super(msg);
	}
}
