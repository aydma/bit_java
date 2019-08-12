package day17;

public class Test02 {

	public static void main(String[] args) {
		Book b1 = new Book("java", 900); // 생략하면 => <Object, Object>
		System.out.println(b1);
		
		if(b1.getTitle() instanceof String) // 형이 맞는지 확인
		System.out.println(((String)(b1.getTitle())).charAt(0)); 
		// b1.getTitle()는 Object형이라 charAt객체가 없어서 다운캐스팅해야한다.
		
		Book<String, Integer> b2 = new Book<String, Integer>("SQL", 400);
		System.out.println(b2);
		System.out.println(b2.getTitle().charAt(0)); 
		// b2.getTitle()는 String형이라서 charAt객체 있음
				
		//Object[] obj = {1,2,3};
		Book<?, Integer> b3 = new Book<String, Integer>("Spring", 4400);
		// ?라고 쓰면 Object을 의미한다.
		System.out.println( b3.getTitle() ); // ?=>b3.getTitle()=>Object
		
		Book<?, ? extends Number> b4 = new Book<String, Integer>("Spring", 4400);
		System.out.println( b4.getPrice()); // Number의 자식 // 뒤의 ? = > Number type
		
		Book<String, ? super Number> b5 = new Book<String, Object>("Spring", 400);
		System.out.println(b5.getPrice()); // Number의 부모 //뒤의 Object로 바인딩해서 ? => Object 
		
		
		
	}
}
