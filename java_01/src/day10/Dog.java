package day10;

public class Dog extends Animal{ // 사용하고싶은 변수?조건을 가지고 있는 클래스를 상속받는다.
	private String kind ="강아지 이름";
	private String name ="강아지 종류";
	
	
	public Dog() { 
		//super("Dog");   //  Animal의 파라미터1개짜리를 호출
		 super("강아지과");   
//		 super();   //  Animal()의 기본생성자를 호툴
	}
	public Dog(String kind, String name) {
		super("강아지과");
		this.kind = kind;
		this.name = name;
	}
	public Dog(String superkind, String kind, String name) {
		// super(); // 생략되어있음 부모영역에 갔다와서 초기화해주고옴
		// super.kind=superkind;
		super(superkind); 
		this.kind = kind;
		this.name = name;
	}
	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void dogPrint() {
		System.out.printf("[%s:%s:%s]%n",super.kind,this.kind,this.name);
	}
	
	@Override
	public void print() {
//		super.print();
//		System.out.printf(" : %s : %s %n",kind,name);
		dogPrint();
	}
	
	public String getSuperKind() {
		return super.kind;
	}
	
}
