package day11;

public class Test04 {
	public static void main(String[] args) {
		String msg1 = "hello";
		String msg2 = "hello";
		System.out.println(msg1); // 자동으로 오토컴퍼팅이 됨 msg1.toString() 이렇게
		System.out.println(msg2.toString());
//		System.out.println(msg1.toString());
		
		Book b1 = new Book("JAVA", 700);
		Book b2 = new Book("JAVA", 700);
		System.out.println(b1.toString());
		System.out.println(b2.toString());
	}
}

class Book extends Object{  // Object에서 물려받은 toString과 equals메소드
	String title;
	int price;
	
	public Book() {}
	public Book(String title, int price) {
		super();
		this.title = title;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "[Book 제목: "+title+"/가격:"+price+"]";
	}
	
	
	
	
}
