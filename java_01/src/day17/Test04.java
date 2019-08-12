package day17;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test04 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("java");
		//list.add(new Date()); // String 타입만 들어감
		
		for(String data : list) {
			System.out.println(data.toUpperCase());
		}
		
		
	}
}
