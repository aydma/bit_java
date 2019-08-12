package day14;

public class Point implements Cloneable{ // 나를 복제할 수 있음 Test02에서  clone()사용하려면 implements Cloneable해줘야한다.
	// implements Cloneable하면 복제능력을 가진 객체가 된다.
	private int x;
	private int y;
	
	public Point() {
		super();
	}
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	@Override
	public Point clone() throws CloneNotSupportedException { 
		// Point클래스를 복제해주는거니까 리턴타입 Point로 바꿈
		// throws CloneNotSupportedException -> 나 복제하다문제발생할수있다 라는걸 알려주는거임
		return (Point) super.clone();
	}
	
}
