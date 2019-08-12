package day07;

public class P139 {
	public static int increase(int n) { // 인스턴스메소드
		++n;
		return n;
	}
	
	public static void main(String[] args) {
		int var1 = 100;
		System.out.println(var1);
		
		int var2 = P139.increase(var1);
		System.out.println(var1);
		
//		생략가능(P139.)increase(var1); // increase 메소드에 static을 붙이면 호출가능
		
	}

}
