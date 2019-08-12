package day12;

public abstract class Shape {
	private String name;
	protected double area;
	
	public Shape() {
//		this("~~~"); // this는 밑의 생성자를 호출한다.
	}
	public Shape(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void print() {
		System.out.println(name+" 의 면적은 " +area);
	}
	
	public abstract void calculationArea();
	

}
