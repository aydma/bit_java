package util;
import java.util.Arrays;

public class MyUtil {
	
	public static long add(int a, int b) {
		return a+b;
	}
	// 메소드 오버로딩=> 
	// 하나의 클래스에 매개변수(파라미터)의 타입이나 갯수가 다르면 동일한 이름의 메소드가 존재할수있음
	// 이름은 하나인데 다양한 매개변수를 처리해줄 수 있는 것
	// 메소드의 리턴타입은 오버로딩이랑 관계없다.
	public static double add(double a, double b) {
		return a+b;
	}	

	// 가변인자(ex.double ... nums) -> 매개변수에서 반드시 마지막위치에 와야한다.
	// double ... nums, double a X , double a, double ... nums 이렇게사용
	
	public static double add(double ... nums) { 
		// ...->몇개들어올지 모른다->[]로처리->배열처리
		double sum=0;
		for(double data:nums) {
			sum+=data;
		}
		return sum;
	}
	
/*
	// 가변인자 double ... nums이 double의 배열이기때문에 중복사용안됨
	// 차이점은 MyMathTest에서 호출하는 값이 배열이 아니라면 오류가 난다. 
	// 사용하기에 가변인자가 훨씬 편함
	public static double add(double[] nums) {
		return 0;
	}
*/	
	public static String rightPad(String str, int size, char padChar) {
		if(str.length()>size) {
			return str;
		}
		int count = size-str.length();
		for(int i=0; i<count;i++) {
			str = str+padChar;
		}
		return str;
	}
	
	
	public static String leftPad(String str, int size, char padChar) {
		if(str.length()>size) {
			return str;
		}
		int count = size-str.length();
		for(int i=0; i<count;i++) {
			str = padChar+str;
		}
		return str;
	}
	
	public static int[] sort(int[] nums) {
		// 배열 원본은 변경이 되지 않도록 하고 
		// 오름차순으로 정렬된 int[] 을 리턴한다.
		
//		int[] copy = Arrays.copyOf(nums, nums.length);
		int[] copy = new int[nums.length];
		System.arraycopy(nums,0,copy,0,nums.length);		
		
		int temp=0;
		int min=0;
		for(int i=0; i<copy.length-1; i++) { 
			min=i;
			for(int j=i+1; j<copy.length; j++) { 
				if(copy[min] > copy[j]) {
					min=j;
				}
			}
			temp=copy[min]; 
			copy[min] = copy[i]; 
			copy[i]=temp; 
		}
		return copy;
	}

	// 숫자를 넘겨 받아 그중 가장 큰수를 리턴하는 함수 max
	/*
	public int max(int a, int b) {
		// 배열 원본은 변경이 되지 않도록 하고 
		// 오름차순으로 정렬된 int[] 을 리턴한다.		
		int max= Integer.MIN_VALUE;
		max = a>=b? a:b;
		return max;
	}
	 */
	
	// 숫자를 넘겨 받아 그중 가장 큰수를 리턴하는 함수 max
	public static int max(int ... a) { // util과힙영역자원안써서 static사용가능
		int max= Integer.MIN_VALUE; // 큰값을 찾기 위해 임의의 가장 작은 수를 초기화함
		for(int data:a) {
			if(max<data) max = data;
		}
		return max;
	}
	// 숫자를 넘겨 받아 그중 가장 작은수를 리턴하는 함수 min
	public static int min(int ... a) { 
		int min= Integer.MAX_VALUE; 
		for(int data:a) {
			if(min>data) min = data;
		}
		return min;
	}
}
