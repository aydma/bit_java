package day17;

public class Test01 {
	public static void main(String[] args) {
		Book1 b1 = new Book1("java", 900); // T => Object
		System.out.println(b1);
		
		Book1<Double> b2 = new Book1<Double>("sql", 700.0); 
//		Book<Double> b2 = new Book<Double>("sql", new Double(600)); int형 쓰려면 이렇게사용
		System.out.println(b2);
		
		Book1<Integer>  b3 = new Book1<Integer>("JSP", 5000);
		System.out.println(b3);
		
		
		
	}
}
