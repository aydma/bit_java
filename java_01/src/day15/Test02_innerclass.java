package day15;

/*
어떤 특정데이터의(어떤 클래스의) 기능과 변수에 가장 손쉽게 접근하는 방법은 이너클래스이다.
A$B.class -> B는 A(outer class)의 inner class이다.
A클래스에서 B가 가진 메소드를 사용하고 싶으면 inner class 객체생성 해야 함
outer class가 inner class메소드 사용하려면 inner class객체생성하기
B를 쓰고싶으면 B만 쓰면 인식이 안됨 
A.B의 형태로 사용하기  A.B b = new A().new B();


inner class가 outer class메소드 사용하려면 
outer class를 메모리에 생성해야한다. 사용하고자 하는 outer class의 주소가 있어야한다.
A a = new A(), new B()로 쓰기 

클래스가 분리가되어있으면 상속, has a관계로 가야하는데 이너클래스로 있으면 접근가능한 방법이 있다.*/

public class Test02_innerclass {
	public static void main(String[] args) {
		A a = new A(); // 아우터클래스 A객체생성
//		a.p(); // B 객체생성후 프린트메소드 실행
		
		A.B b = new A().new B(); // A.B타입의 b // B에 접근하려면 A의 주소가 꼭 필요하다
		b.print();  // 이너클래스는 재활용하는데 문제 없다.
		
//		A.C c = new A().new C();
//		c.print();
		
		A.C.print(); // static은 인스턴스 자원사용못하는데 인스턴스자원이 아니면 이너클래스여도 바로 접근가능해서 아우터클래스로 객체생성할 필요없다.
		
		
	}
}

//class A{
//	String name ="A";
//}
//
//class B{
//	void print() {
//		System.out.println("B"+a.name); // A의 name
//	}
//}

class A{
	
	String name ="A";
	
	public A() {}
	public A(String name) { //통로 만들어주기 생성자
		super();
		this.name = name;
	}
	void p() {	
		System.out.println("A에서 호출");
		new B().print(); // B의 함수호출하려면 먼저 이너클래스 B 객체생성해야함
	}
	
	class B{
		String name ="B";
		void print() {
			System.out.println(this.name); // B의 name
			System.out.println(A.this.name); // A의 name
		}
	}

	static class C{ //static 은 멤버변수, 기능에 붙임 class에는 못붙임 // inner class에만 static을 허용한다. // static은 this사용못함
		// static은 인스턴스 자원사용못하는데 인스턴스자원이 아니면 이너클래스여도 바로 접근가능해서 아우터클래스 주소 필요없다
		// this. 해서 자원찾기는 불가능하다.
		static void print() {
			System.out.println("~~~~~~~~~~~");
		}
		
	}
	
	class D{
		void P() {
			class E{ // 로컬이너클래스 => 이너클래스안에 이너클래스 만들수있다.
				
			}
		}
	}
	
}


