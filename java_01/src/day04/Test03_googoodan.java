package day04;

public class Test03_googoodan {

	public static void main(String[] args) {
		// 구구단
		OUT:for(int j=1; j<10; j++) {		
			 for (int i = 2; i <10 ; i++) { 
				//if(i==5) continue;	// 5단만 처리안됨 continue 루프로 다시 재진입
				if(i==5) break OUT; // OUT for반복문 빠져나감			
				System.out.printf("%d*%d=%2d|",i,j,(i*j));  // %2d는 2자리수를 위해서
			}
			System.out.println();
		}
		
		

	}

}
