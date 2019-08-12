package day08;
/**
 * 
 * @author sme
 * @since 2019 07 16
 * @version 1.0
 */
public class Employee {
	static String cName="BIT";
	private String name;
	private String dept;
	private boolean single;
	
	public Employee() { 
		// super(); // 생략되어있음 위치는 제일 맨위여야한다.
		this("사원이름","ooo부서",true); // this()는 나의 또다른 생성자함수를 호출하는 문장 -> 위치는 맨위여야한다.
		// 기본생성자의 역할 => 초기화 작업을 주로 한다.
		//System.out.println("Employee() call");
		//this.name = "사원이름";
		//this.dept="ooo부서";
		//this.single = true;
		
	}	
	public Employee(String name, String dept) { // 생성자함수는 리턴타입안씀		
		//super(); //위치는 제일 맨위여야하기 때문에 원래 없는 문장이다.
		this(name,dept,false); //this()의 위치는 맨위여야한다.
				
		//System.out.printf("Employee(%s,%s) call%n",name,dept); 
		//this.name = name;
		//this.dept = dept;
	}	
	public Employee(String name, String dept, boolean single) {
		//System.out.printf("Employee(%s,%s,%s) call%n",name,dept,single);
		this.name = name;
		this.dept=dept;
		this.single = single;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public boolean isSingle() {
		return single;
	}
	/**
	 * 
	 * @param single 미혼인지?
	 */
	public void setSingle(boolean single) {
		this.single = single;
	}
	/**
	 * Employee 정보 출력
	 */
	
	public void print() {
		//System.out.println("회사명 : "+cName);
		System.out.printf("[사원명:%s, 근무부서:%s, single:%b]%n"
				,this.getName(),this.getDept(),this.isSingle());
	}
	
	

}
