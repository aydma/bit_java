package day10;

public class Animal { // 모든 객체의 DATA TYPE은 부모가 될 수 있다.
	protected String kind = "동물의 종류"; // 접근지정자없으면 같은 패키지내에서 접근가능
	// 접근지정자 protected : 같은 클래스,같은 패키지, 서브클래스라면 다른패키지에 있어도 접근가능
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
	public void breath() {
		System.out.println(kind+" : 폐로 숨쉬기 ~~~~~~");
	}
	public void print() {		
		System.out.printf("Animal kind : %s", kind);
	}
}