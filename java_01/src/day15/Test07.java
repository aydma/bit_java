package day15;

public class Test07 {

	public static void main(String[] args) {
		AAA a = new AAA() {
			@Override
			void exec() { // 강제성 있는 오버라이딩
				
			}
		};
			
		III i = new III() {
			@Override
			public void exec() { // 강제성 있는 오버라이딩
				
			}
		};
		CCC c = new CCC() {
			void exex() {} // 강제성 없는 오버라이딩
		};
	}
}

abstract class AAA{
	abstract void exec(); 
}

interface III{
	void exec();
}

class CCC{
	void exec() {	}
}