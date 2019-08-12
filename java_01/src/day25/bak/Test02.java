package day25.bak;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;

public class Test02 {
// 네이버 인덱스 읽어옴
	public static void main(String[] args) {
		String address = "https://www.naver.com/index.html";
		String line = null;
		
		URL url = null;
		BufferedReader br = null; // 한라인씩읽으려면 버퍼드리더가필요함
		try {
			url = new URL(address); 
			br = new BufferedReader(new InputStreamReader(url.openStream())); 
			// openStream하면 naver사이트에서 데이터들어옴 System.in이랑 같음
			// 네트워크에 연결함 네이버
			// InputStream 이 바이트인데 Reader하면 char타입으로 바꿔줌  
			// InputStreamReader은 바이트 -> char로 변환해줌
			// BufferedReader 이거 쓰면 성능빨라짐 빨리 읽어옴
			
			
			while ((line = br.readLine()) != null) {
				System.out.println(line); // 네이버에서 만든 인덱스 다읽어옴
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) br.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}

	}

}
