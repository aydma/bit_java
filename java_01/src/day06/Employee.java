package day06;

public class Employee {
	// clasa = variable(특성)+method(기능)
	//같은 패키지에 있으면 import안함
	//데이타(변수)+기능(메소드)	
	
	private String name;  
	private String dept;
	private int age;   //201901
	//** 접근지정자
	// public: 어디있든지 import만 하면 접근가능
	// 접근지정자쓰지 않을때: 같은패키지내에서는 접근가능
	// private: 해당 클래스 내부에서만 접근가능 (캡슐화)
	
	boolean single;
	
	public void display() { // 리턴타입이 없으면 void => return뒤에 값이 없는것 
		System.out.printf("[나이:%-10s, 이름:%10s, 부서:%10s, 싱글:%10b]%n"
						   ,this.getAge(),this.getName(),this.getDept(),this.isSingle());
						   // this가 생략된것 멤버자원을 접근할때 this.을 쓴다.
		return;
	}
	
	public void setAge(int age) {
		if(!(age>0 && age<=100)) {
			System.out.println("age(나이) 정보가 올바르지X");
			return;
		}
		this.age = age;
		return;
	}
	
	public int getAge() {
		return this.age;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return this.dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public boolean isSingle() { // boolean타입은 get이 아니고 is임
		return this.single;
	}

	public void setSingle(boolean single) {
		this.single = single;
	}
	
	
	
	
}

