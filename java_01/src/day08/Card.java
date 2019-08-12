package day08;

public class Card {
	
	final static int WIDTH=100; 
	// 공유해서 관리하고 싶은 변수는 static을 붙인다.
	// final = 상수화시킨다. 수정불가능
	// final시킨 변수는 보통 대문자로 사용함
	final static int HEIGHT=250;
	String kind = "다이아몬드";
	int number;
	
	
	public static void main(String[] args) {
		// Card.WIDTH = 0; //final변수는 수정불가능
		System.out.println(WIDTH+" * "+HEIGHT);
		// System.out.println(kind); //kind변수쓰려면 주소가 필요하다.
		System.out.println(new Card().kind);
	}
	
	
	
}
