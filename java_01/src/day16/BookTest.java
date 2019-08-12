package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import day17.PriceException;

public class BookTest {

	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("c://lib//sample.txt"));
			while (scanner.hasNextLine()) { // 읽을 라인있는동안 계속 수행
				String[] data = scanner.nextLine().replace('_', '/').split("/"); 
				// 한줄읽었으면 _을 /로 바꾸고 "/"로 쪼개서 data에 넣는다.
				//System.out.println(Arrays.toString(data));
				Book book = null;
				try {
					book = new Book(data[0], Integer.parseInt(data[1]));
				} catch (PriceException e) {
					System.out.println(e.getMessage());
				}
				System.out.println(book);
			}// -------------------------------------- while()
		} catch (FileNotFoundException e ) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(scanner != null) scanner.close();
			scanner = null;
			System.out.println("자원반납수행");
		}
		
		System.out.println("END");
	}
}
