package day07;

public class Calc {
//	int data=0;
	
	static int data=0; // class 변수
	
	// class method  class이름으로 접근하기때문
	public static long add(int a, int b) { // static 처리하면 객체생성 안해도 메모리에 뜸		
		//System.out.println(data); 
		// static있어서data에 접근불가능 
		// (this.)data라서 인스턴스변수
		// 인스턴스변수=>new해서(선언) 메모리에 띄어야 사용가능하기때문에
		// 메모리에 바로 올라가는 static메소드 안에서는 사용불가능
		
//		System.out.println(data); // Calc를 생략해도 나의 데이터기때문에 자동처리됨
		System.out.println(Calc.data); 
		System.out.println(Math.random()); 
		return a+b;
	}
	
	public static long sub(int a, int b) {
		return a-b;
	}
	
	public static long mul(int a, int b) {
		return a*b;
	}
	
	public static long div(int a, int b) {
		if(b==0) return 0;
		return a/b;
	}
	

}
