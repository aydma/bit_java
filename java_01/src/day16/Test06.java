package day16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test06 {

	public static void main(String[] args){
		System.out.println(" main start ");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("c://lib//sample.txt");
			// 파일의 경로지정을 하지않으면 dos창에서 실행하면 이클립스에서찾음, 이클립스에서는 실행하면 프로젝트에서 찾음
			// 파일 io작업하기 // 파일의 정확한 위치(절대경로) 지정해주기
			System.out.println("파일 준비 완료 ~~~");
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("sample.txt 파일을 확인해 주세요 ");
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 예외발생해도 자원반납은 함
			
			try {
				if(fis != null) { 
					fis.close(); 
					fis = null;
				}
				System.out.println("자원 반납 ok"); 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		System.out.println(" main end ");
	}

}
