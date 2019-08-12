package day04;

import java.util.Arrays;

public class Test04_array {

	public static void main(String[] args) {
		// Array : 배열은 항상 위치인덱스를 따라다닌다.
		
		int[] scores; //배열선언
		scores = new int[5]; // 배열 생성
		
		
		for(int i=0; i<5; i++) {
			System.out.print(scores[i] + "      ");
		}
		System.out.println();
		
		String[] names =new String[5];
		for(int i=0; i<5; i++) {
			System.out.print(names[i]+"   ");
		}
	
		System.out.println();
		System.out.println("======================================");
		
		scores[0] = 99;
		scores[1] = 31;
		scores[2] = 34;
		scores[3] = 96;
		scores[4] = 78;
		
		names[0] = "홍길동";
		names[1] = "김둘리";
		names[2] = "서뽀삐";
		names[3] = "두까미";
		names[4] = "까망이";
		
		double avg = 0.0;
		double sum = 0;
		for(int i=0; i<scores.length; i++) {
			sum += scores[i];
		}
		avg = sum/scores.length;
		
		System.out.println(Arrays.toString(scores)); // 배열 안의 내용 보여주기
		System.out.println(Arrays.toString(names));
		
		System.out.println("평균 : "+avg);
		System.out.println("========================================");
		
		// 홍** 99 평균이상
		
		/*
		 * for(int i=0; i<scores.length; i++) { if(scores[i]>avg) {
		 * System.out.println(names[i]+" "+ scores[i]+ "평균이상"); }else {
		 * System.out.println(names[i]+" "+ scores[i]+ "평균이하"); } }
		 */
		for(int i=0; i<names.length; i++) {
			System.out.println(names[i].charAt(0)+"**   "+ scores[i]+ 
					          (scores[i] >= avg?"   평균이상":"   평균미달"));
			// charAt(i) 입력한 문자중 i번째값
		}
		
		

	}

}
