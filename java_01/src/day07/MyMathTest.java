package day07;

import java.util.Arrays;

import util.MyUtil;

public class MyMathTest {

	public static void main(String[] args) {
		System.out.println(MyUtil.add(33, 99));
		System.out.println(MyUtil.add(33.3, 99.4));
		
		System.out.println(MyUtil.add(33.3, 99.4, 90));
		System.out.println(MyUtil.add(33.3, 99.4, 90,55.9));
		System.out.println(MyUtil.add(1,2,3,4,5,6,7,8,9,10));
		
		//매개변수 double[] nums를 썼을때는 호출하는 쪽이 반드시 배열이여야한다.
		//가변인자(ex.double ... nums)은 이것도 처리가능
		System.out.println(MyUtil.add(new double[]{1,2,3,4,5,6,7,8,9,10}));
		double[] d = new double[] {1,2,3,4,5,6,7,8,9,10};
		
		System.out.println(Arrays.toString(d));
		int i =100; 
//		Integer li = new Integer(100);
		Integer li = i; 
		// 기본형(int,boolean,char등)과 wqpper클래스는 타입이 왔다갔다함  -> 이과정이 오토박싱,언박싱
		// 기본형에 주소넣어도 잘됨
		System.out.println(i+"    "+i);
	}
	

}
