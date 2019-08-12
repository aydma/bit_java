package day03;

import java.util.Scanner;

public class Test03_if {

	public static void main(String[] args) {
		int jumsu;
		Scanner sc = new Scanner(System.in);
		System.out.println("jumsu는 몇점입니까?");
		
//		jumsu = sc.nextInt();
// 		sc.nextLine();
		
		jumsu = Integer.parseInt(sc.nextLine());  // nextLine() 자원이 남아있는 경우를 대비하여 초기화한다.(입력한 뒤에 남아있는 엔터도 초기화)				
		sc.close(); // 자원반납
		sc = null;
		
		if(!(jumsu>=0 && jumsu < 100)) {
			System.out.println("유효하지 않은 점수입니다.");
			return; // 현재 수행중인 점수를 종료하고 호출한 자리로 돌아가는 문항-> 메인함수의종료
		} 
		System.out.println("점수: "+jumsu);
/*		
		if( jumsu>=80 ){
			System.out.println("Pass");
		} else {
			System.out.println("NO Pass");
		}
*/
		String result = jumsu >= 80 ? "PASS" : "NO PASS";
		System.out.println("점수: " + jumsu+ ":" + result);
		
		// A,B,C,D,F 등급처리
		String grade = "F";
		if(jumsu >= 90) {
			grade = "A";
		}else if(jumsu >= 80) {
			grade = "B";
		}else if(jumsu >= 70) {
			grade = "C";
		}else if(jumsu >= 60) {
			grade = "D";
		}
		System.out.println("점수: "+jumsu+", 결과: "+result+", "+grade+"등급");
		
		System.out.printf("점수: %d, 결과: %s, %s등급 %n",jumsu,result,grade);
		
		// 과제: 삼항 연산자로 처리 
		
		String result1 = jumsu >= 90 ? "A" : jumsu >= 80 ? "B" : jumsu >= 70 ? "B" : "D";
		System.out.println(result1);
		
		
		// 등급 처리 switch 로
		System.out.println("====================등급처리 switch==========================");
		char c = ' ';
		
		switch (jumsu/10) {
		case 10:
			c='A';
			break;
		case 9:
			c='B';
			break;
		case 8:
			c='C';
			break;
		case 7:	
			c='D';
			break;
		default:
			c='F';
			break;
		}
		
		System.out.println("등급: "+ c);

		return;
		
		
		
	}

}
