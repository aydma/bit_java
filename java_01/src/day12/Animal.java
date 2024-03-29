package day12;

public abstract class Animal { // 추상클래스 : 상속을 전제로 만들어진 클래스
	protected String kind = "동물의 종류"; 
	
	public Animal() {}
	public Animal(String kind) {
		super();
		this.kind = kind;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public abstract void breath(); // 추상 메소드
	
	public void print() {		
		System.out.printf("Animal kind : %s", kind);
	}
}