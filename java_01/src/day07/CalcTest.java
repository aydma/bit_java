package day07;

public class CalcTest {
	public static void main(String[] args) {
//		Calc c1 = new Calc(); 
		// 메소드에 static을주면 객체생성안해도 메모리에 올라가니까 클래스를 직접 써주면됨 (Calc.java)
	
		// 인스터스 메소드
		Calc c1 = new Calc(); 
		System.out.println(c1.add(11, 99));
		
		//클래스 메소드
		System.out.println(Calc.sub(11, 99));
		System.out.println(Calc.mul(11, 99));
		System.out.println(Calc.div(11, 99));
		
		
		
		
		
	}
}
