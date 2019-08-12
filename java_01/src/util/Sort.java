package util;

import java.util.Arrays;

public class Sort {
	public static int[] sort(int[] nums) {
		// 배열 원본은 변경이 되지 않도록 하고 
		// 오름차순으로 정렬된 int[] 을 리턴한다.
		
//		int[] copy = Arrays.copyOf(nums, nums.length);
		int[] copy = new int[nums.length];
		System.arraycopy(nums,0,copy,0,nums.length);		
		
		int temp=0;
		int min=0;
		for(int i=0; i<copy.length-1; i++) { 
			min=i;
			for(int j=i+1; j<copy.length; j++) { 
				if(copy[min] > copy[j]) {
					min=j;
				}
			}
			temp=copy[min]; 
			copy[min] = copy[i]; 
			copy[i]=temp; 
		}
		return copy;
	}

}
