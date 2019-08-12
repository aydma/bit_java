package day19;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Test02 {

	public static void main(String[] args) {
//		Map<String, String> map = new TreeMap<String, String>(); // 정렬
		Map<String, String> map = new HashMap<String, String>(); // 데이터정렬안됨
		map.put("java01", "1234");
		map.put("java02", "1234");
		map.put("admin", "admin");
		for(int i=0; i<30; i++) {
			map.put("test"+i, (int)(Math.random()*3)+"aa");
		}
		System.out.println(map);
		
		System.out.println("admin => pw ? "+map.get("admin") ); // map.get("admin") 
		System.out.println("java01 => pw ? "+map.get("java01") ); // 키의 밸류값알려줌
		System.out.println("java09 => pw ? "+map.get("java09") ); 
		System.out.println("test1 => pw ? "+map.get("test1") ); 
		System.out.println("=================================================");
		
		Set<String> keynames = map.keySet(); // key이름만 뽑아주는 메소드
		Iterator<String> it = keynames.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println("ID: "+key+", pw : "+map.get(key));
		}
	}
}