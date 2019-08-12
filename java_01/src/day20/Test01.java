package day20;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import day19.Employee;

// 배열이든 콜렉션이든 접근가능하게 만든것이 스트림이다. 집합체들은 스트림으로 처리해야함
public class Test01 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(10);
		list.add(15);
		list.add(20);
		
		list.forEach(i->System.out.print(i+"  "));
		System.out.println();
		list.removeIf(i->i%2==0);// 2로 나눴을때 나머지가 0이면 삭제함 // 조건에 맞는 엘리먼트 삭제 람다식
		list.forEach(i->System.out.print(i+"  "));
		
		System.out.println("-----------------------------------------------\n");
		// List stream 접근방법
		List<Employee> emp = new ArrayList<Employee>();
		emp.add(new Employee(2017001,"홍길동", "영업부"));
		emp.add(new Employee(2018002,"홍길동", "영업부"));
		emp.add(new Employee(2017011,"최길동", "인사부"));
		emp.add(new Employee(2019011,"이길동", "인사부"));
	
		System.out.println(emp.stream().filter(i->i.getNumber() > 2018001).count());// 모든 컬렉션은 스트림 가능하다.
		emp.stream()
		.filter(i->i.getNumber() > 2018001)
		.forEach(i->System.out.println(i)); // stream하고 filter,forEach 접목시키면서 작업가능
		
		// 배열 Stream 접근방법
		Employee[] e = {
				new Employee(2017001,"홍길동", "영업부"),
				new Employee(2018002,"홍길동", "영업부"),
				new Employee(2017011,"최길동", "인사부"),
				new Employee(2019011,"이길동", "인사부")
		};
		System.out.println("=== Array Stream 처리 ==="); 
		Stream.of(e).filter(i->i.getDept().equals("인사부")) // 배열을 스트림으로 바꾼후 인사부 사원만 추출하여
		.forEach(i->System.out.println(i)); // 출력
		
		System.out.println(); 
		Stream.of(e).sorted().forEach(i-> System.out.println(i)); // stream 정렬하기
		
		System.out.println("---------------------------------------"); 
		Stream.of(e).sorted(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getName().compareTo(o2.getName());
			}
		}).forEach(i-> System.out.println(i));
		System.out.println("---------------------------------------"); 
		Stream.of(e)
		.sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
		.forEach(i->System.out.println(i));
	}
}
