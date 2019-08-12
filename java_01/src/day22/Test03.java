package day22;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test03 {
// InputStream	- 데이터 처리단위가 byte 인데 byte는 한글이 깨지는 문제점이 있다.
// 한글 처리하고 싶으면 InputStream이름을 바꿈 Reader로
// ex FileInputStream -> FileReader
// 2진파일은 무조건 InputStream / OutputStream
// text파일은 Reader/Writer
// FileInputStream-> 읽을때(Reader제공 ) // FileOutputStream -> 복사,저장할때 (Writer제공) 1바이트읽고1바이트씀 파일용량만큼 읽고씀
	public static void main(String[] args) {
		String src = "c://lib//Ben.mp3"; // 이 파일원본 읽어서 복사하려고함
		FileInputStream fis = null; 
		FileOutputStream fos = null;
		System.out.println("파일 복사 시작합니다.");
		
		try {
			fis = new FileInputStream(src); // src에서 데이터 읽음
//			fos = new FileOutputStream("c://lib//copy.mp3"); // 데이터 복사할때 확장자는 같게 이름내맘
			fos = new FileOutputStream("c://lib//copy3.mp3",false); // true는 append모드임  // false는 원본을 잃어버림  오버라이드됨
			
			int read = 0;
			int count = 0;
			
			byte[] buffer = new byte[fis.available()]; 
			
			while ((read=fis.read(buffer)) != -1 ) { // buffer 쓰면 한방에 복사됨 시간이 빨라짐
				fos.write(buffer); 
				count++;
			}
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
