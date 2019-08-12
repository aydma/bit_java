package day18_collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Test01 {
	public static void main(String[] args) {
//		String[] names1 = new String[100]; // 인덱스에 신경써야함
//		int index = 0;
		
		String[] names1 = {"이순신","김순신","박순신","강순신"};
		System.out.println(Arrays.toString(names1));		
		Arrays.sort(names1); // 배열 sort  // 배열을 관리하는 인터페이스Arrays
		System.out.println(Arrays.toString(names1));		
		
		System.out.println("======================================");
		List<String> list = new ArrayList<String>(); // 인덱스에 신경안써도됨
		list.add("홍길동");
		list.add("고길동");
		list.add("홍길동");
		list.add("최길동");
		list.add("박길동");
		list.add("고길동");
		list.add("이길동");
		
		System.out.println(list);
		Collections.sort(list); // Collections.sort 수행 //콜렉션을 관리하는 인터페이스 Collections
		System.out.println(list.toString());
		
		List<String> list2 = new ArrayList<String>(list.subList(1, 4)); // list2에 list의 인덱스 1-4가 들어옴
		System.out.println(list2);
		
		// 리스트를 배열로 바꾸기
		Object[] obj = list.toArray();
		System.out.println("obj  => "+Arrays.toString(obj)); // Object[] type
		
		String[] obj2 = new String[list.size()];
		list.toArray(obj2);
		System.out.println("obj2 => "+Arrays.toString(obj2)); // String[] type
		
		 // 배열을 Arraylist로 바꾸기 배열에있는 데이터를 기반으로 리스트 만듬
		String[] sss = {"111", "999", "777", "333"};
		List<String> sslist = new ArrayList<String>(Arrays.asList(sss));
		System.out.println(sslist);
		
		System.out.println("=== list 다루기 ===");
		System.out.println(list);
		System.out.println(list.contains("아길동")); // list안에 "아길동"이라는 데이터가 있는지 알려주는것
		
		for(int i=0; i<list.size(); i++) { // -> set구조는 접근불가
			System.out.println(list.get(i).charAt(0)+"**");
		}
		
		for(String data:list) { // -> set구조로 순회
			System.out.print(data);
		}
		
		System.out.println();
		Iterator<String> it = list.iterator(); // 콜렉션을 순회하기위한 표준화된방법Iterator
		while(it.hasNext()) {
			String data = it.next();
			if(data.equals("고길동")) {
				System.out.println("고길동 삭제되었습니다.");
				it.remove();
			}
		}
		System.out.println(list);
		
	}
}
