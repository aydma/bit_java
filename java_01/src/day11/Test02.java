package day11;

public class Test02 {
	public static void main(String[] args) {
//		Person[] p = {	new Student("홍길동", 20, 2012001),
//						new Teacher("이순신", 30, "JAVA"),
//						new Employee("유관순", 40, "교목과"),
//		};
		  
		Object[] p = {	
		// Object쓸때 equals랑 toString쓸게 아니라면 다운캐스팅 해야 한다.		
				new Student("홍길동", 20, 2012001),  
				new Teacher("이순신", 30, "JAVA"),
				new Employee("유관순", 40, "교목과"),
				"~~~~",
				"00000"
		};
		
//		for(Person data :p){
//			//data.printA(); // 부모 Person() 영역의 자원을 접근할때는 바로 접근 가능
//			System.out.println();
//		}
		
		for(Object data :p){
		//data.printA(); // 부모 Person() 영역의 자원을 접근할때는 바로 접근 가능
		System.out.println();
	}
		System.out.println("========================");
		
//		for(Person data :p) {
//			// 자식 영역의 자원을 접근할때는 다운 캐스팅 필요
//			// instanceof => 반드시 하단부에 어떤 객체가 바인딩 되어 있는지 타입 체크 필요
//			if(data instanceof Student) ((Student)data).print(); // instanceof => data의 타입이 Student라면  //Student로 다운캐스팅
//			if(data instanceof Teacher) ((Teacher)data).print();
//			if(data instanceof Employee) ((Employee)data).print();
//		}
		
		for(Object data :p) {
			// 자식 영역의 자원을 접근할때는 다운 캐스팅 필요
			// instanceof => 반드시 하단부에 어떤 객체가 바인딩 되어 있는지 타입 체크 필요
			if(data instanceof Student) ((Student)data).print(); // instanceof => data의 타입이 Student라면  //Student로 다운캐스팅
			if(data instanceof Teacher) ((Teacher)data).print();
			if(data instanceof Employee) ((Employee)data).print();
		}
		
	}

}
