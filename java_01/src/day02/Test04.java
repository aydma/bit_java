package day02;

public class Test04 {
	
	public static void main(String[] args) {
		System.out.println("byte type max value =>"+Byte.MAX_VALUE);
		System.out.println("int type max value =>"+Integer.MAX_VALUE);
		System.out.println("long type max value =>"+Long.MAX_VALUE);
		
		System.out.println(Math.PI);
		
		char c = '5';
		System.out.println(c + "는 숫자니? " +Character.isDigit(c)); 
		// isDigit숫자인지 확인함수(t/f), Character클래스결과반환 c가 char라서 Character
		
		String ss = "1"+"1";
		System.out.println(ss);
		
		int s1 = Integer.parseInt("1") + Integer.parseInt("1");
		System.out.println(s1);
		
		Double s2 = Double.parseDouble("1.6") + Double.parseDouble("1.7");
		System.out.println(s2);
		
	}

}
