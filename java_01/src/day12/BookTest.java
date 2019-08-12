package day12;

public class BookTest {

	public static void main(String[] args) {
		String msg1 = "hello";
		String msg2 = "hello";
		System.out.println(msg1.toString());
		System.out.println(msg1.equals(msg2));
		System.out.println(msg2);
		
		Book b1 = new Book("java", 2200);
		Book b2 = new Book("java", 2200);
		System.out.println(b1.toString());
		System.out.println(b1.equals(b2)); // 객체비교/주소비교 equals -> object가 적용하는 메소드 
										   // equals는 반드시 오버라이딩이 필요하다. 그래야 중복제거 가능함.
		System.out.println(b2);
		
		System.out.println(b1.equals(null));
		
		b1.close(); // finalize을 사용하지 않고 close()을 사용하여 자원반납을 한다.
		b2.close(); // b1 = null; 전에 자원반납해줌
		
		b1 = null;  // null로 사인을 해야 가비지가 작동함
		b2 = null;
		
		// System.gc(); // 얘만 하면 자원반납하지 않아서 미리 b1 = null;해야한다. 그래서 close()를 사용함
		
		
		
		System.out.println("=== main end ===");
		
	}	

}
