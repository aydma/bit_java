package day08;

public class P164_Test { // 자바파일이름정할때는 public class이름으로 해야함 
						 // 한파일에 public class는 1개밖에 없음
	public static void main(String[] args) {
		Count c1 = new Count();
		Count c2 = new Count();
		Count c3 = new Count();
		Count c4 = new Count();
		System.out.println(Count.count);
		
	}
}

class Count{
	int c;
	static int count;
	public Count() {
		c++;
		count++;
	}
}