package day17;

public class DiceGame {
	public static void main(String[] args) {
		DiceGame game = new DiceGame();
		
		int result1=0;
		int result2=0;
		try {
			result1 = game.countSameEye(10);
			result2 = game.countSameEye(-10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("면의 개수가 8개인 주사위 2개를 던져서 같은 눈이 나온 횟수 : "+result1);		
		System.out.println("면의 개수가 8개인 주사위 2개를 던져서 같은 눈이 나온 횟수 : "+result2);		
	}
	
	int countSameEye(int n) throws Exception{
		if (n < 0) throw new DiceException();
		Dice d1 = new Dice(8);
		Dice d2 = new Dice(8);
		int count = 0;
		
		for(int i=0; i<n; i++) {
			int a = d1.play();
			int b = d2.play();
			if(a==b) {
				System.out.print(a);
				System.out.println(b);
				count++;
			}
		}
		return count;
	}
}

class DiceException extends Exception{ 
	public DiceException() {	
		super("DiceException : 음수 허용 안됨 ");
	}
	public DiceException(String msg) {
		super(msg);
	}
	
}
