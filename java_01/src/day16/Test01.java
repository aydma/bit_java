package day16;
public class Test01 {
	public static void main(String[] args) {
		System.out.println(" main start ");
		int a = 10, b = 0;
		
		try {
			System.out.println(1);
			System.out.println(a / b); // throw new ArithmeticException() 예외 발생
			System.out.println(2);
		}catch (ArithmeticException e) { // 예외발생시 수행
			System.out.println("예외 발생 : "+e.getMessage());
			e.printStackTrace(); // 에러가 발생했을 때 예외정보만을 찍어주는 메소드
			System.out.println(3);
		}finally { //예외발생 관계없이 항상 수행
			System.out.println("finally{  항 상 수 행    }");
		}
		
//		System.out.println("--------------------------");
//		if(b!=0) System.out.println(a/b); 
		System.out.println(" main end ");
		
		
	}
}


//ArithmeticException ss;
//NullPointerException nn;
//IndexOutOfBoundsException ii;