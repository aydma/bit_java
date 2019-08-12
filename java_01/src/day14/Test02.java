package day14;

import java.util.Arrays;

public class Test02 {
	public static void main(String[] args) throws CloneNotSupportedException { // Clone이 지원되지않으면NotSupported 오류Exception발생한다는 의미
		int[] num = {11,22,33,44,55};
		//int[] num2= num;
		int[] num2 = num.clone(); // clone() 주소복사가 아니라 데이터복제 // 객체를 복제할때 사용하는것
		num2[2] = 0;
		System.out.println(num);
		System.out.println(num2);
		
		System.out.println(Arrays.toString(num));
		System.out.println(Arrays.toString(num2));
		System.out.println("-----------------------------");
		Point p = new Point(5, 5);
//		Point p2 = p; // 주소가 같아짐
		Point p2 = p.clone(); // Point클래스가 복제 가능하니까 clone()사용가능하고 오류잡아줘야해서 throws CloneNotSupportedException해줌
		Object obj; //clone() 사용하려면 Point클래스에  implements Cloneable헤줘야한다.
		/* 
		 * 객체에 복제능력주기
		 * 클래스에 implements Cloneable해주고  clone() 오버라이딩 해주고 리턴타입 해당 클래스로 바꿈 리턴타입 형변환해줌
		 * 복제능력 사용할때는 throws CloneNotSupportedException로 오류잡아주기
		 */
	
		
		
		p.setX(0);
		System.out.println(p);
		System.out.println(p2);
		
	}
}
