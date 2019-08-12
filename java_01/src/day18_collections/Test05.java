package day18_collections;

public class Test05 {

	public static void main(String[] args) {
		Employee e1 = new Employee(2017001, "홍씨", "영업부");
		Employee e2 = new Employee(2017002, "김씨", "마케팅부");
		
		System.out.println(e1.equals(e2));
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());

	}

}
