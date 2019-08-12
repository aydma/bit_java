package day02;

public class Test02 {
	
	public static void main(String[] args) {
		int num1 = 99;
		int num2 = 1;
		char a = 'a';
		
		int abc = a+num1; // char타입은 int로 자동 형변환 char타입은 아스키코드있음 a=97
		char bc = (char) (a+num1); // int타입은 캐스팅변환이필요함
		
		System.out.println(abc);
		System.out.println(bc);
		System.out.println(num1+num2);
		System.out.println(num1+a);
		
		
		String name = "홍길동";
		System.out.println(name.charAt(0)+"**"); //0번째 홍 1번째 길 2번째 동
		
		String address = new String("비트교육센터");
		System.out.println(address+" : "+address.length()); // length 문자열의사이즈 6
		
		long number = 999999999999999999L;
		System.out.println(number);
		
		System.out.println('A'+":"+(int)'A'); // 아스키코드값
		System.out.println('Z'+":"+(int)'Z');
		System.out.println('a'+":"+(int)'a');
		System.out.println('z'+":"+(int)'z');
		System.out.println('0'+":"+(int)'0');
		System.out.println('9'+":"+(int)'9');
	}

}