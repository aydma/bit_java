package day12;

import java.lang.reflect.Array;

public class Book extends Object{
	
	private String title;
	private int price;

	public Book() {
		super();
	}
	
	public Book(String title, int price) {
		super();
		this.title = title;
		this.price = price;
	}
	public Book(int price, String title) { // 파라미터의 순서가 다른것도 오버라이딩가능
		super();
		this.title = title;
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Book 정보/ title:");
		sb.append(title);
		sb.append("/ 가격: ");
		sb.append(price);
		
//		return sb;  // sb가  문자열이 아니라서 리턴안되서 문자열로 바꿔주어야한다.		 new String(sb)/sb.toString()
		
		return new String(sb);
//		return sb.toString();
		
//		return "Book 정보/ title: "+title+"/ 가격: "+price;  // append로 표현하는게 좋다.
	}
	
	@Override
	public boolean equals(Object obj) { 
		boolean flag = false;
		if( obj == null || !(obj instanceof Book)) { // 넘어온 obj 북타입이면 다운캐스팅 아니면 다운캐스팅 안함
			return false;
		}
		Book data = (Book)obj;  // 넘어온 b2를 obj으로 받는다
		if(price == data.price && title.equals(data.title)) { // 내가 갖고있는것과 data가 갖고있는것 비교
			flag = true;
		}
		return flag;
	}
	
	@Override
	protected void finalize() throws Throwable {  //finalize 자원반납 
		// 객체가 소멸되기 직전에 호출되는 메소드이지만 자바에서는 사용안하고 별도의 자원반납 기능을 만들어 사용한다.
		System.out.println("자원 반납 코드~~~");
	}
	
	public void close() { // 자원반납 메소드
		System.out.println("colse 자원 반납 코드 ~~~~");
	}


}
