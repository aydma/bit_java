package day06;

public class Animal {
	boolean live;
	int age;
	String name;
	
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void print() {
		System.out.println(name+": " +age+": "+live+": ");

	}
	
	public static void main(String[] args) {
		Animal a = new Animal();
		a.name="~~~"; // 인스턴스변수 => 주소가  꼭 있어야 함
		a.print();    // 인스턴스메소드=> 주소가 있어야만 작동가능한 메소드 
		           
		
	}

}