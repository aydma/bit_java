package day04;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		System.out.println("알파벳 아스키 코드 값 확인 ");
		
		char a = 'a';
		char A = 'A';
		
		for(int i=0; i<=25; i++) {
			System.out.println(a+" : "+(int)a++ +",\t\t" + A+" : "+(int)A++);
		}
				
		/*
		 *  변수 ch에 저장된 문자가 대문자 인 경우에만
		 *  소문자로 변경하는 코드를 완성합니다.
		 */	
		
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열을 입력하세요 : ");
		String msg = sc.nextLine();
		
		
		for(int i=0; i<msg.length(); i++) {
			char ch = msg.charAt(i); // charAt(i) 입력한 문자중 0번째값
			char s = (ch>='A' && ch<='Z') ? (char)(ch+32) : ch;
			//                              (형변환)문자+숫자=문자
			
			//System.out.println(ch + " => " + s);
			System.out.print(s);
		}
		
		System.out.println();
		System.out.println("======================과제===================");
		
		
		// 과제
		// 소문자 => 대문자
		// 대문자 => 소문자
		for(int i=0; i<msg.length(); i++) {
			char ch = msg.charAt(i); // charAt(i) 입력한 문자중 0번째값
			char ch1 = msg.charAt(i);
			char s = (ch>='A' && ch<='Z') ? (char)(ch+32) : (ch1>='a' && ch1<='z') ? (char)(ch-32) : ch;
			
			System.out.print(s);
		}


	}

}
