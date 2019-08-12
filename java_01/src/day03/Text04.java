package day03;

public class Text04 {

	public static void main(String[] args) {
		
		// for(초기값; 조건식; 증감식 )
		int i;
		for(i=0; i<10; i++) {
			System.out.println("Hello java"+i);
		}
		// System.out.println(i);
		
		int j=10;
		while(j>0) {
			System.out.println("while "+j);
			j--;
		}
		
		boolean flag = true;
		while(flag) {
			j++;
			System.out.println("~~~~~~~~~~~~"+j);
			if(j==5) flag = !flag;
		}
		System.out.println("j : "+j);
		
		while(i<5) {
			System.out.println("do while"); 
		}
		
		do {
			System.out.println("do while"); // 최소한번은수행
		}while(j<5);
		
	}
}
