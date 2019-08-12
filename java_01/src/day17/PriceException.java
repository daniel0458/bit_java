package day17;

public class PriceException extends Exception{
	
	//사용자 정의 예외를 생성할때엔 IOException이나 Exception을 상속받는다
	public PriceException() {
		super("PriceException : 음수 허용 안됨");
	}
	public PriceException (String msg) {
		super(msg);
	}

}
