package day14.tv;

public class TVTest {
	public static void main(String[] args) { // 자바의 다형성이용 // 로우커플링(Low coupling)
		
		STV user = new STV();
		play(new STV());
		
		play(new LTV());
		
		play(new ITV());
		
		
	}
	public static void play(TV tv){  // 부모타입을 매개변수로 쓴다 => 로우커플링(Low coupling)
		tv.poweron();
		tv.poweroff();
	}
	
//	public static void play(STV tv){ 
//		tv.poweron();
//		tv.poweroff();
//	}
//	public static void play(LTV tv){
//		tv.poweron();
//		tv.poweroff();
//	}
}
