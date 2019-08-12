package day16;


public class Test05 {

	public static void main(String[] args) throws InterruptedException{
		System.out.println(" main start ");
		
		for(int i=0; i<10; i++) {
			System.out.println("hello ~~~ "+i);
			Thread.sleep(1000);
		}
		System.out.println(" main end ");
	}
}
