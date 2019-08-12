package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Test07 {
	public static void main(String[] args) {
		System.out.println(" main start ");
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("c://lib//sample.txt"));
			while (scanner.hasNextLine()) { // 읽을 라인있는동안 계속 수행
				String[] data = scanner.nextLine().replace('_', '/').split("/"); 
				// 한줄읽었으면 _을 /로 바꾸고 "/"로 쪼개서 data에 넣는다.
				System.out.println(Arrays.toString(data));
			}
		} catch (FileNotFoundException e ) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("sample.txt 파일을 확인해 주세요 ");
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			if(scanner != null) scanner.close();
			scanner = null;
			System.out.println("자원반납수행");
		}
		System.out.println(" main end ");
		
	}
}
