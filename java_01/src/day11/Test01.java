package day11;

public class Test01 {
	public static void main(String[] args) {
		
//		new Student("홍길동", 20, 2012001).print();
//		new Teacher("이순신", 30, "JAVA").print();
//		new Employee("유관순", 40, "교목과").print();
		
//		Student s = new Student("홍길동", 20, 2012001);
//		Teacher t = new Teacher("이순신", 30, "JAVA");
//		Employee e =new Employee("유관순", 40, "교목과");
		
//		Object s = new Student("홍길동", 20, 2012001); // 모든 객체의 데이터 타입은 부모가 될 수 있다.
		Person s = new Student("홍길동", 20, 2012001); // 모든 객체의 데이터 타입은 부모가 될 수 있다.
		Person t = new Teacher("이순신", 30, "JAVA");
		Person e =new Employee("유관순", 40, "교목과"); 
		
//		s=t; // 형제들끼리는 호환이 안됨
		
		Person p = null;
		p= s; // 부모는 자식을 받을 수 있다.
//		p= s; // Object가 부모가 되었기 때문에 오류남
//		p.print(); // 자식영역에 있는 메소드 호출불가

		//p.printA(); // 가능
		((Student)p).print(); // 다운그레이드 하면 사용가능
		
		p=t;
		((Teacher)p).print();
		
		p=e;
		((Employee)p).print();
		
		
	}
}

class Person {
	private String name;
	private int age;
	
	public Person() {
		super();
	}
	public Person(String name, int age) { // 생성자에 관여하면 기본생성자 생성안됨
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void printA() {
		//super.printB() 하면 Person클래스 내부에 메소드가 생성된다.
		System.out.printf("이 름 : %s, 나 이 : %2d, ",this.getName(),this.getAge());
	}
}

class Student extends Person{ 
	// Person의 생성자에 관여하면 Person기본생성자가 만들어지지 않아서 오류가 남
	// Sudent의 생성자가 Person의 기본생성자를 호출하기때문이다.
	
	private int id;
	
	public Student() {
		super();
	}
	
	public Student(String name, int age, int id) {
		super(name,age);
//		this.setName(name); // 부모클래스변수받기 //유효성 검사 할 수 있어서 이 방법이 더 정확함
//		this.setAge(age);
//		super.setName(name);
//		super.setAge(age);
		this.id = id;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void print() {
		super.printA(); // super키워드쓰지않으면 내가 나를 호출하는 재귀호출이 됨
		System.out.printf("학 번 : %s %n",id);
	}
}

class Teacher extends Person{
	private String subject;
	
	public Teacher() {
		super();
	}
	
	public Teacher(String name, int age, String subject) {
		super(name, age);
		this.subject = subject;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void print() {
		super.printA(); 
		System.out.printf("과 목 : %s %n",subject);
	}
}

class Employee extends Person{
	private String dept;
	
	public Employee() {
		super();
	}
	
	public Employee(String name, int age) {
		//super(name, age, null); // super()랑this()는 둘다 맨위의 자리에 있어야하기때문에 동시에 못씀
		this(name,age,null); // 밑의 파라미터 3개짜리를 호출
		
	}
	
	public Employee(String name, int age, String dept) {
		super(name, age);
		this.dept = dept;
		
	}
	public Employee(String dept) {
		super();
		this.dept = dept;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public void print() {
		super.printA(); 
		System.out.printf("부 서 : %s %n",dept);
	}
}

