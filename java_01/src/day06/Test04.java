package day06;

public class Test04 {

	public static void main(String[] args) {
		Employee emp1 = new Employee();
		
		Employee emp2 = new Employee();
		emp2.setAge(31);
		emp2.setName("홍길동");
		emp2.setDept("인사부");
		
		Employee emp3 = new Employee(); // 객체(Object)=(instance)
		emp3.setAge(27);
		emp3.setName("고길동");
		emp3.setDept("홍보부");
		
		Employee emp4 = new Employee(); // 객체(Object)=(instance)
		emp4.setAge(29);
		emp4.setName("김길동");
		emp4.setDept("영업부");
		
		Employee[] emp = {emp1,emp2,emp3,emp4};
		
		System.out.println("== 영업부에 근무하는 사원 목록 ==");
		double sum = 0;
		int count =0;
		for(int i=0; i<emp.length; i++) {
//			System.out.println(data.getDept());
			if ( emp[i].getDept() != null && emp[i].getDept().equals("영업부")) {
				// 데이터에 널값이 있는지 확인안하면 오류남
				sum += emp[i].getAge();
				count++;
				emp[i].display();
			}
		}
		System.out.printf("영업부 평균급여 = %.2f %n",sum/count);
		
		System.out.println("== single인 사원 목록 ==");		
		for(int i=0; i<emp.length; i++) {
			//System.out.println(emp[i].isSingle());
			if(emp[i].isSingle()) {
				emp[i].isSingle();
			}
		}
	}
}