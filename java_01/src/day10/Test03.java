package day10;

public class Test03 {
	public static void main(String[] args) {
		Time t1 = new Time(13,20,20);
		
	}
}

class Time{
	int hour;
	int minute;
	int second;
	
	// source - Generate Constructor using Fields
	public Time() {
//		super(); // 부모 생략되어있음
	}
	public Time(int hour, int minute, int second) {
//		super(); // 부모
		// 지워도 부모를 부름 생성자 함수는 자동으로 부모를 호출한다.
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}




	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		
		this.second = second;
	}
	
	
	
	
	
	
}