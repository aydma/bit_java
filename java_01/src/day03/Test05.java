package day03;

public class Test05 {

	public static void main(String[] args) {
		
		// 1 - 100 합
		// 1+2 3 4 5 6 
		int sum = 0;
		int sum2 = 0;
		for (int i =1; i<=100; i++) {
			sum = i+sum;
			if(i%4==0) { //4의배수합계
				sum2 +=i;
			}
		}
		System.out.println("1-100까지의 합 : "+sum);
		System.out.println("1-100까지 4의 배수의 합 : "+sum2);
		
	}
}
