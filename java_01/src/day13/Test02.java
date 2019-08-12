package day13;

public class Test02 {

	public static void main(String[] args) {
		Point p = new Point(3,3);
		System.out.println(p); // p.toString() //toString()을 만들었기때문에  Point [x=3, y=3]이렇게 나옴
		
		Circle2 c1 = new Circle2();
		c1.setP(p);
		System.out.println(c1); // c1.toString()
		
		Circle2 c2 = new Circle2(new Point(7,7),5);
		System.out.println(c2);
		

	}

}
