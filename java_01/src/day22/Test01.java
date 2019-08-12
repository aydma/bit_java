package day22;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Date;


public class Test01 {
	public static void main(String[] args) {
		// dos창에서 dir명령내리는 걸 흉내내봄
		// io 들어가기전 파일이 뭔지 체크해봄
		File dir = new File("c:\\");
		String[] list = dir.list();
		
		File file = null;
		Date date = null;
		for(String data :list) {
			file = new File(dir,data);
			System.out.print(file.getName()+"\t");
			System.out.print(file.length()+"\t");
			date = new Date(file.lastModified()); // 마지막파일정보까지 가지고있음
			System.out.print(date+"\t");
			
			if(file.isDirectory()) System.out.println("<dir>");
			System.out.println();
		}
	}
}
