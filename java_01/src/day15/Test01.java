package day15;

import day14.Circle;
import day14.Point;

public class Test01 {

	public static void main(String[] args) throws Exception {
		Point p1 = new Point(5,5);
		Point p2 = p1.clone(); // 서로 다른 주소  // 데이터복사
		 
		Point p3 = p2; // 서로 같은 주소 // 주소복사
		
		p2.setX(0);
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
		System.out.println("======================================");
		
		
		Circle c1 = new Circle(new Point(7,7),2);
		Circle c2 = c1.clone(); // 포인트 복제 가능하도록 만들어 보세요
		
		
		c2.r = 0;
		c2.p.setX(0); // Circle안에 있던 Point는 복제가 안되서 주소를 공유한다.
		System.out.println(c1);
		System.out.println(c2);
		
	}
}
