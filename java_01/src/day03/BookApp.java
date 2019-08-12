package day03;

import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String cmd = null;
		while (true) {
			
			System.out.println("*******  명령 선택   *********");
			System.out.println("1. insert(등록)");
			System.out.println("2. delete(삭제)");
			System.out.println("3. update(수정)");
			System.out.println("4. quit(종료)");
			System.out.println("************************* \n\n");
			System.out.println("수행할 명령을 선택하세요");
			System.out.println("1 2 3 4중 하나를 선택하세요");
			
			//cmd = sc.nextInt()+""; // int+""은 입력값이 String으로 바뀜
			//sc.nextLine(); 
			cmd = sc.nextLine().trim(); // trim공백제거  
			
			switch (cmd) { // cmd뒤에.trim() 넣어도됨
			case "1":
				System.out.println("insert 등록 작업을 수행하는 기능 호출");
				break;
			case "2":
				System.out.println("delete 삭제 작업을 수행하는 기능 호출");
				break;	
			case "3":
				System.out.println("update 수정 작업을 수행하는 기능 호출");
				break;
			case "4":
				System.out.println("정말 종료하려면 q/Q를 입력하세요");
				String quit = sc.nextLine().trim();
				if(quit.equals("q") || quit.equals("Q")) {
					System.out.println("App 종료");
					sc.close();
					sc=null;
				}				
				//return; // 현재의 함수 종료 의미
				//System.exit(0); // App 종료
			default:
				System.out.println("다시 입력하세요 _");
				break;
			}
			System.out.println("=====================================");
		}
	}

}
