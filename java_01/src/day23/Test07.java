package day23;

import java.io.RandomAccessFile;

public class Test07 { // 수행시킬때마다 append모드라서 결과바뀜
	public static void main(String[] args) throws Exception{
		
		RandomAccessFile raf = new RandomAccessFile("rand.dat", "rw"); 
		// 임의 접근이 가능한 지원하는 클래스 RandomAccessFile // 읽고쓰기다됨
	
		String msg = "Hello, RandomAccessFile ...";
		String result = null;
		
		raf.writeBytes(msg); // Bytes문자열사용가능
		raf.seek(0);
		while (true) {
			result = raf.readLine();
			if(result == null ) break;
			System.out.println(result);
		}
		System.out.println("===============================");
		raf.seek(raf.length()); // seek로 커서조종가능
		msg = "\n hi.. java test... io test... ";
		raf.writeBytes(msg);
		raf.seek(7); // 7번째 위치로 가기
		while (true) { // 다시 읽어보기
			result = raf.readLine();
			if(result == null ) break;
			System.out.println(result);
		}
		System.out.println("===============================");
		raf.close();
		
		

	}
}
