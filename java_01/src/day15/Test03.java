package day15;

import day14.Point;

public class Test03 {
	public static void main(String[] args) {
		Outer.Inner i = new Outer().new Inner(); // Outer의 주소를 알아야해서 Outer()주소생성한후에 Inner()주소생성
		i.print();
	}
}

class Outer{
	Point p = new Point(3, 3);
	
	class Inner{
//		Outer o = new Outer(); //has a
		
		void print() {
//			System.out.println(o.p);
			System.out.println(p);
		}
	}
}

