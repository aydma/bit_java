package day04;

public class Test02_star {
	public static void main(String[] args) {
		
		// *로 삼각형 찍기
		for(int j=0; j<5; j++) {
			//System.out.println("j="+j);
			for (int i = 0; i <= j; i++) {
				//System.out.print("i="+i);
				System.out.print('*');
			}
			System.out.println();
		}
		
		System.out.println(" ");
		
		// *로 역삼각형 찍기
		for(int j=0; j<5; j++) {			
			for (int i = 5; i > j; i--) {
				System.out.print('*');
			}
			System.out.println();
		}
		
		
	}
}
