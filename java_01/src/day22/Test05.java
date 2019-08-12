package day22;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test05 {
	public static void main(String[] args) {
		String src = "c://lib//Ben.mp3"; // 이 파일원본 읽어서 복사하려고함
		FileInputStream fis = null; 
		FileOutputStream fos = null;
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		System.out.println("파일 복사 시작합니다.");
		
		
		
		try {
			fis = new FileInputStream(src); // src에서 데이터 읽음
			fos = new FileOutputStream("c://lib//copy5.mp3",false); // true는 append모드임  // false는 원본을 잃어버림  오버라이드됨
			
			bis = new BufferedInputStream(fis); // 버퍼 준비끝
			bos = new BufferedOutputStream(fos);
			
			int read = 0;
			int count = 0;

			while ( (read = bis.read()) != -1) {
				bos.write(read);
			}
			
			
			
			bos.flush(); // 버퍼가꽉차지않으면 안비워지니까 버퍼비워준다.
			System.out.println("I/O 횟수 : " + count);
			System.out.println("파일 복사 완료");
		} catch (FileNotFoundException e) {
			System.out.println(src+"파일(복사원본) 확인해 주세요");
		} catch(Exception e) {
			
		} finally {
			try {
				if(fis != null) fis.close();
				if(fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(" main end ");

	}

}
