package day13;

public class SingletonTest {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance(); // Singleton객체를 생성해주는 getInstance()메소드로 객체생성
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = Singleton.getInstance();
	}
}

class Singleton{
	private static Singleton s = new Singleton();
	
	private Singleton(){	
		System.out.println("Singleton() 생성");
	}
	
	public static Singleton getInstance() { // Singleton객체 만들어주는 getInstance()메소드
		//return new Singleton();			// private 로 외부에서 Singleton객체 생성을 막아놔서 
											// 외부에서 Singleton객체 사용하려면 getInstance()메소드 호출해야함
											// 객체를 여러개 생성하지 않고 하나를 가지고 계속 이용 static
		if(s==null) s=new Singleton();
		return s;
	}
	
}