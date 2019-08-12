package day05;

import java.util.Arrays;

public class Test04 {

	public static void main(String[] args) {
		// 난수발생
		
//		System.out.println(Math.random()); // 0<=double형<1
//		System.out.println((int)Math.random()); // 항상 0이나옴
//		System.out.println(Math.random()*10); 
//		String[] n = {"5"};
//		String[] args = {};
		
		if(args.length == 0) { // 배열이 비어있으면
			System.out.println("배열의 사이즈 정보를 실행 매개변수 넘겨주세요..");
			System.out.println("실행_예) java day05.Test04 5");
			return;
		}
		
		int[] nums = new int[Integer.parseInt(args[0])]; 
		// 도스창에서  Java day05.Test04 6하면 숫자6개들어옴 7하면 7개들어옴 배열 args가 통로라서
		for(int i=0; i< nums.length; i++) {
			nums[i]= (int)((Math.random()*45)+1);  // 1~45사이의 정수 Math.random() 이용  //0.99*45=44.xxxx		
			// 중복제거
			// int[] num = new int[6] 배열 num에 정수 1~45 사이의 난수를 집어넣는다. 중복제거한다. 정렬후 화면에 출력한다.
			for(int j=0; j<i; j++) {
				if(nums[i]==nums[j]) { 
					i = i--;
				}
			}
		}
		
		System.out.println(Arrays.toString(nums));  
		// 정렬 내림차순 SORT
		System.out.println("------  정렬   ------");		
		int count = 0;
		int temp = 0;
		for(int i=0; i<nums.length-1; i++) { // 바꿀대상
			for(int j=i+1; j<nums.length; j++) { // 비교대상
				if(nums[i] > nums[j]) {
					temp=nums[i];
					nums[i] = nums[j];
					nums[j]=temp;
//					count++;
				}
			}//---------------for j
		}//---------------for i
		
		// 과제 스와핑 작업을 최소화 수행하게 코드 수정합니다.
//		System.out.println(Arrays.toString(nums));  		
//		System.out.println("count = > " +count);
		System.out.println("----- 스와핑 작업을 최소화 정렬 -----");
		int min=0;
		for(int i=0; i<nums.length-1; i++) { 
			min=i;
			for(int j=i+1; j<nums.length; j++) { 
				if(nums[min] > nums[j]) {
					min=j;
				}
			}//---------------for j
			temp=nums[min]; 
			nums[min] = nums[i]; 
			nums[i]=temp; 
			count++;
		}//---------------for i
		
		System.out.println(Arrays.toString(nums));
		System.out.println("count = > " +count);
		
	}

}
