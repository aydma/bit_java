package day18_collections;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Test03 {
	public static void main(String[] args) {
		Student[] s = new Student[10];
		Student[] sss = {
				new Student("홍순이", 88,99),
				new Student("차순이", 82,93),
				new Student("고순이", 80,91)
		};
		Arrays.sort(sss); // 배열 sort
		
		Vector<Student> list = new Vector<Student>(5, 10);   // 내부에 Student[] 만들어서 관리
		// Vector는 동기화가 되고 ArrayList는 동기화가 안된다.
//		List<Student> list = new ArrayList<Student>();
		System.out.println("capacity : "+list.capacity());
		System.out.println("size : "+list.size());
		
		list.add(new Student("홍순이", 88,99));
		list.add(new Student("차순이", 82,93));
		list.add(new Student("고순이", 80,91));
		list.add(new Student("홍순이", 88,99));
		list.add(new Student("차순이", 82,93));
		list.add(new Student("고순이", 80,91));
		list.add(new Student("홍순이", 88,99));
		list.add(new Student("차순이", 82,93));
		list.add(new Student("고순이", 80,91));
		list.add(new Student("홍순이", 88,99));
		list.add(new Student("차순이", 82,93));
		list.add(new Student("고순이", 80,91));
		list.add(new Student("홍순이", 88,99));
		list.add(new Student("차순이", 82,93));

		System.out.println("----------------------------------");
		System.out.println("capacity : "+list.capacity());
		System.out.println("size : "+list.size());
		
		//System.out.println(list);
		Iterator<Student> it = list.iterator(); // 콜렉션을 순회하기위한 표준화된방법Iterator
		while(it.hasNext()) {
			Student data = it.next();
			if(data.getAvg()>=90) {
				System.out.println(data);
			}
		}
		System.out.println(list.contains(new Student("고순이", 80,91))); // equlas 메소드가 없어서 비교못함
		// equlas()함수 오버라이딩 되어있어야 한다.
		
		// C생성 U수정 R읽기 D삭제
		// 홍길동 90 90 등록 
		Student s1 = new Student("홍길동", 90,90);
		boolean flag = list.add(s1);
		if(flag) System.out.println(s1+" 등록되었습니다.");
		else System.out.println(s1+" 등록되었습니다");
//		list.add(new Student("홍길동", 90,90)); // C등록
		
		// 홍길동 100 100 수정 
		it = list.iterator(); // iterator다시 사용하려면 해줘야함
		while (it.hasNext()) {
			Student data = it.next();
			if(data.name.equals("홍길동")) {
//				data.name = "홍길동";
				data.ko = 100;     // 수정
				data.math = 100;
				data.setAvg(); // 평균안바뀌니까 다시호출
				System.out.println(data+" 수정되었습니다");
			}
		}
		
		// list 목록출력
		System.out.println(" ***** 학생 List 정보 출력 ***** ");
		it = list.iterator();
		while (it.hasNext()) {
			Student data = it.next();
			System.out.println(data);
		}
		
		// s1 삭제 처리
		it = list.iterator(); 
		while(it.hasNext()) {
			Student data = it.next();
			if(data.equals(s1)) {
				it.remove();
				System.out.println(" ***** 학생  "+s1+" 삭제 *****");
			}
		}
		
		Collections.sort((List<Student>) list); 
		
		// list 목록출력
		System.out.println(" ***** 학생 List 정보 출력 ***** ");
		it = list.iterator();
		while (it.hasNext()) {
			Student data = it.next();
			System.out.println(data);
		}
		
		
	}
}