package day11;

public class Test03 {
	public static void main(String[] args) {
		// is a관계  Student,Employee,Teacher는 Person이다
		Person p = new Person("고길동", 22);  // p는 다운캐스팅 불가능

		Person s = new Student("홍길동", 20, 2019001); // s는 Student에 Person이 있어서 다운캐스팅 가능 
		Employee e = new Employee("유관순", 40, "교무과");
		Object o = new Teacher("이순신", 30, "JAVA");
		Object msg = new String("hello java ");
		
		
		
	}

}
