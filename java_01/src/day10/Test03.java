package day10;

public class Test03 {
	public static void main(String[] args) {
		Time t1 = new Time(13,20,20);
		
	//	System.out.println(arr);
	}
}

class Time{
	private int hour;
	private int minute;
	private int second;
	
	public Time(int hour, int minute, int second) {
		super();
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		if(hour>=0 && hour <= 24)
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		if(hour>=0 && hour <= 60)		
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		if(hour>=0 && hour <= 60)		
		this.second = second;
	}
	
	
}
