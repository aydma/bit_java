package day05;

import java.util.Arrays;

public class Test02 {

	public static void main(String[] args) {
		
		int[] scores = {77,99,100,85,91};
		int[] sc = new int[scores.length*2];
		System.out.println(Arrays.toString(scores));
		System.out.println(Arrays.toString(sc));
		
		System.arraycopy(scores, 0, sc, 0, scores.length); // 주소는 object(소스),소스위치(어디부터카피할지), 목적지, 목적지위치(배열이0부터시작해서),수량
		
		System.out.println(Arrays.toString(scores));
		System.out.println(Arrays.toString(sc));
		
		String[] names = {"홍길동","박길동","고길동","최길동","김길동"};
		String[] names2 = new String[names.length*2];
		
		System.out.println(Arrays.toString(names));
		System.out.println(Arrays.toString(names2));
		
		System.arraycopy(names, 0, names2, names2.length-names.length, names.length); // names의 0번째데이터부터  name2의 0번째자리로 복사 names의 길이만큼
		
		System.out.println(Arrays.toString(names));
		System.out.println(Arrays.toString(names2));

	}

}
