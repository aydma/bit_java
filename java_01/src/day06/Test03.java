package day06;

public class Test03 { 

	public static void main(String[] args) {
		//int num;
		//String name;
		Employee emp1 = new Employee(); // 객체생성 == 인스턴스생성 // 새로운 데이터 타입이 만들어짐
		//System.out.println(emp1.number +":" + emp1.name+":" +emp1.dept);
		emp1.display();  // display가 void라서 값이 들어가지않고 호출만함
		
		Employee emp2 = new Employee();
		//emp2.age = 201901;
		emp2.setAge(-201901);
		emp2.setName("홍길동");
		emp2.setDept("인사부");
		emp2.setSingle(false);
		emp2.display();
		
		Employee emp3 = new Employee(); // 객체(Object)=(instance)
		//emp3.age = 201902;
		emp3.setAge(201902);
		emp3.setName("고길동");
		emp3.setDept("홍보부");
		emp3.setSingle(true);
		emp3.display();
		
		//데이타(변수)+기능(메소드)	
		// 클래스는 틀같은 역할 
		// 클래스를 만들면 새로운 데이터 타입이 만들어짐
		// 만들어진 클래스로 객체생성한다. 
		// 객체 생성 = 인스턴스생성 
		// 인스턴스 변수 <-> Math.random(),Math.PI:항상똑같은행위를함
		// 인스턴스 변수 -> 값을 담을수있는 변수,변할수있음......... 
		// ex)Employee의 name,age,dept등
		// this => 어떤 객체가 힙영역에 생성되었을때 그안에서만 쓰이는 키워드 힙영역에서만 쓰임
		//         메모리에 객체생성됐을때 나의 영역을 지칭하는 것
	}

}
