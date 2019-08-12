package day10;

public class Animal_Test01 {
	public static void main(String[] args) { // static영역에서는 super,this 키워드 사용불가능
		
		Animal a1 = new Animal("~~~");
		a1.breath();
		
		Animal a2 = new Animal("Dog");
		a2.breath();
		
		//Dog d1 = new Dog();
		Dog d1 = new Dog("시베리안허스키","케리");
		d1.breath(); // d1에 가서 breath()찾고 없으면 super()로가서 breath()찾아 실행한다.
		d1.dogPrint();
		Dog d2 = new Dog("Dog","진돗개","쫑이");
		d2.dogPrint();
		
		String animalKind = d2.getSuperKind(); 
		// Animal의 kind에 접근못하니까(private) 자식클래스에서 부모클래스의 kind를 받는 메소드를 만든다.
		System.out.println(animalKind);
		
	}
}
