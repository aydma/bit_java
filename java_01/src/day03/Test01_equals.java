package day03;

public class Test01_equals {
	public static void main(String[] args) {
		// == | 기본형의 값이 같은지 비교,
		// equals() : 참조와 데이터가 같은지 비교
		
		int num1 = 99;
		int num2 = 99;
		
		String name1 = "홍길동";
		String name2 = "홍길동";
		
		String msg1 = new String("Hello");
		String msg2 = new String("Hello java");
		
//		System.out.println("num1==num2 => "+ num1==num2); 제일먼저 +를 연산해서 String과 int를 더하려고해서 오류남
		System.out.println("num1==num2 => "+ (num1==num2)); 
		System.out.println("name1==name2 => "+ name1==name2); // 객체에서 ==는 주소를 비교하는것
		System.out.println("name1.equals(name2) => "+ name1.equals(name2)); // 참조형은 무조건 equals로 비교한다.
		System.out.println("msg1.equals(msg2) => "+ msg1.equals(msg2));
		
		msg1 = msg2; // 2의주소를 1에넣음
		
		
		
		
		
		
		
	}
}
