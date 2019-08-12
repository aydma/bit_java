package day09;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Test02_String {
	public static void main(String[] args) {
		String msg = "Java programming/23000";
		System.out.println(msg.indexOf("/"));
		
		// substring->추출
		String d1 = msg.substring(0,msg.indexOf("/")); 
		//0부터/전까지 Java programming
		String d2 = msg.substring(msg.indexOf("/")+1); // 23000
		
		System.out.println(d1);
		System.out.println(d2);
		
		String url = "http://127.0.0.1:8080/web1/list.do";
		System.out.println(url.indexOf('/'));  //
		System.out.println(url.lastIndexOf('/'));
		System.out.println(url.substring(url.lastIndexOf('/')));
		// url.substring(url.indexOf('/'));
		
		System.out.println(url.contains("web1"));
		
		String data = "2019001_홍길동/ 90_ 70/100";
		System.out.println(data);
		// System.out.println(data.replace('_', '/'));
		// data가 가르키는 곳에 가서 _가 /로 바꾼값을 리턴한다.
		// System.out.println(data);
		data = data.replace('_', '/');
		System.out.println(data);
		
		String[] sdata = data.split("/"); // split으로 쪼개지지않으면 replace한다.
		System.out.println(Arrays.toString(sdata));
		
		System.out.println("============================================");
		
		data = "2019001_홍길동/ 90_ 70/100";
		StringTokenizer st = new StringTokenizer(data,"/_"); 
		//StringTokenizer는 한번에 여러개의 기호로 쪼갤수있다. 
		// ex)_로 쪼갠다. /과_두개로 쪼갤수있다. 
		System.out.println(st.countTokens()); // 몇개로 쪼개졌는지 확인
		
		while(st.hasMoreElements()) { // 원소가 있는동안 루프돔
			System.out.print(st.nextToken()+" , ");
		}
		
	}
}
