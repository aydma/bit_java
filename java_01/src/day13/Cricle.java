package day13;
//interface Shape{
//	public abstract double area();
//}
//interface는 추상메소드나 final메소드만 있을때 사용할수있다.
//접근지정자는 부모의 접근지정자보다 자식의 접근지정자의 범위가 더 커져야 한다.
abstract class Shape{
	abstract double area();
}

interface Drawable { // 자바에서는 클래스 뒤에 able가 붙어있으면 다 인터페이스다.
//	void draw(); // public abstract 생략가능
	public abstract void draw();
}

public class Cricle extends Shape implements Drawable{ // extends 뒤에 implements
	// is a관계 // 가장 중요한 기능하고 연관된 클래스를 상속받고 나머지는 has a를 한다.
//public class Cricle implements Shape{ 
	Point p;  //has a 관계
	int r;
	
	public Cricle() {
		super();
	}
	public Cricle(Point p, int r) {
		super();
		this.p = p;
		this.r = r;
	}
	
	@Override
	public double area() {
		return r*r*Math.PI; 
	}
	@Override
	public void draw() { //Drawable 추상메소드 구현하기
		System.out.println(getClass().getName()+" 그리기");
	}
	
	@Override
	public String toString() {
		return "Cricle [p=" + p + ", r=" + r + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((p == null) ? 0 : p.hashCode());
		result = prime * result + r;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cricle other = (Cricle) obj;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;
		if (r != other.r)
			return false;
		return true;
	}
	
	
	
}

