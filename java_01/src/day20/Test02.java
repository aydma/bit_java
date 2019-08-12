package day20;

import java.util.Iterator;
import java.util.Properties;

public class Test02 {
	public static void main(String[] args) {
		Properties p = new Properties();  // Properties 환경설정파일에 사용 대부분의 환경설정파일의 확장자는 .Properties이다.
		p.setProperty("java01", "1234");
		p.setProperty("java02", "1244");
		p.setProperty("java03", "1734");
		p.setProperty("java04", "7234");
		p.setProperty("java05", "6234");
		System.out.println(p.getProperty("java01"));
		
		Iterator it = p.keySet().iterator(); 
		while (it.hasNext()) {
			String key = (String) it.next();
			System.out.println(key+" : "+p.getProperty(key));
		} 
	}
}
