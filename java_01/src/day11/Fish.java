package day11;

import day10.Animal;

public class Fish extends Animal{
	private String name;

	public Fish() {
		super("물고기");
	}

	public Fish(String name) {
		super("물고기");
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void fishPrint() {
		System.out.printf("[%s, %s]%n", kind, name);
	}
	
	@Override
	public void print() {
//		super.print();
//		System.out.printf(" : %s %n", name);
		fishPrint();
	}
	
	// 메소드 오버라이딩 => 부모로부터 물려받은 기능을 나의 성향에 알맞게 다시 재정의 하는 것
	@Override
	public void breath() { // 부모한테 있는 메소드를 다시 재정의함
		System.out.println(kind+" : 아가미로 숨쉬기 ~~~~~~");
	}
	
}
	
	
	



