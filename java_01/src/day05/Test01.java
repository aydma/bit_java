package day05;

import java.util.Arrays;

public class Test01 {

	public static void main(String[] args) {
		int num1 = 99;
		int num2 = num1;							 // 데이터 복사
		System.out.println("num1="+num1+", num2="+num2);
		num1 = 77;
		System.out.println("num1="+num1+", num2="+num2);
		
		int[] n1 = {11, 22, 33, 44, 55};
		int[] n2 = n1; 								// 주소복사
		
		int[] n3 = new int[n1.length];       // 배열 n1의 데이터를 복사하려고함
		for(int i=0; i<n1.length; i++) { 
			n3[i] = n1[i];   // array copy
		}
		
		System.out.println(Arrays.toString(n1));
		System.out.println(Arrays.toString(n2));
		System.out.println(Arrays.toString(n3));
		n1[2] = 0;
		System.out.println(Arrays.toString(n1)); // 배열은 가르키는 주소가 같아서 결과값이 같음
		System.out.println(Arrays.toString(n2)); 
		System.out.println(Arrays.toString(n3));
		
		// call by value, call by reference 차이점 알아두기
		
		
	}

}
