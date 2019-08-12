package day18_collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test04 {
	public static void main(String[] args) {
		Set<Employee> set = new HashSet<Employee>();
		boolean flag = set.add(new Employee(2017001, "홍씨", "영업부"));
		if(flag) System.out.println("등록되었습니다.");
		
		flag = set.add(new Employee(2017001, "홍씨", "영업부"));
		if(!flag) System.out.println("이미 존재하는 데이터입니다.");
		
		set.add(new Employee(2017002, "김씨", "마케팅부"));
		set.add(new Employee(2017003, "박씨", "기술부"));
		
		// set 목록 출력 //set구조 - 들어간순서대로 나온다는 보장이 없다.
		System.out.println("  사원 목록  ");
		Iterator<Employee> it = set.iterator(); //iterator 콜렉션 인터페이스 (list,set에서도 쓸수있음)
		while (it.hasNext()) {
			Employee data = it.next();
			System.out.println(data);
		}
		System.out.println();
		// 2017003 사번의 사원을 검색 출력하세요.
		it = set.iterator(); //iterator 콜렉션 인터페이스 (list,set에서도 쓸수있음)
		System.out.println("검색결과입니다.");
		while (it.hasNext()) {
			Employee data = it.next();
			if(data.number == 2017003) {
				System.out.println(data);
			}
		}
		
	}
}

class Employee implements Comparable<Employee> {
	int number;
	String name;
	String dept;
	
	public Employee() {	}
	public Employee(int number, String name, String dept) {
		super();
		this.number = number;
		this.name = name;
		this.dept = dept;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [number=" + number + ", name=" + name + ", dept=" + dept + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (number != other.number)
			return false;
		return true;
	}
	@Override
	public int compareTo(Employee o) {
		return number-o.number;
	}

}