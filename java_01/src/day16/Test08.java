package day16;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Test08 {
	public static void main(String[] args) {
		try(FileInputStream fis = new FileInputStream("c://lib//sample.txt");) { // try구문에서 자동으로 자원반납해줌
			System.out.println("file 처리 ~~~~ ");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {}
		
		System.out.println("------------------------------------------");
		
		try (Scanner scanner = new Scanner(new File("c://lib//sample.txt"));){ // auto close
			while (scanner.hasNextLine()) { // 읽을 라인있는동안 계속 수행
				String[] data = scanner.nextLine().replace('_', '/').split("/"); 
				// 한줄읽었으면 _을 /로 바꾸고 "/"로 쪼개서 data에 넣는다.
				System.out.println(Arrays.toString(data));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(" end ");
	}
}
