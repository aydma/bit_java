package day11;

import day10.Animal;
import day10.Dog;

public class AnimalTest2 {

	public static void main(String[] args) {
		Animal[] animals = {
				new Dog("진돗개", "쫑이"), 
				new Fish("구피"),
				new Dog("시베리안허스키", "케리")
		};
		
//		for(Animal data: animals) {
//			data.breath();
//			data.print();
//		}
		Dog a1 = new Dog("진돗개", "쫑이");
		Fish f1 = new Fish("구피");
//		callD(f1); // ->callD(Fish d) 호출
		callD(animals[0]);
		callD(animals[1]);
	}
	
//	public static void callD(Dog d) {
//		d.breath();
//	}
//	public static void callD(Fish d) {
//		d.breath();
//	}
	public static void callD(Animal d) { // d가 Fish타입인지 Dog타입인지에 따라 호출하는 breath()가 다름
		d.breath();
	}
}
