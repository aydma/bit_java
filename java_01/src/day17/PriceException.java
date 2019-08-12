package day17;

public class PriceException extends Exception{ // 예외처리하려면 예외처리해주는 부모클래스(IOException, Exception)를 상속받기 
	// RuntiomException은 예외처리 안해줌

	public PriceException() {	
		super("PriceException : 음수 허용 안됨 ");
	}
	public PriceException(String msg) {
		super(msg);
	}
	
}

//접근지정자는 부모보다 같거나 커야하고 throw 부분은 부모보다 같거나 작아야한다.
//Set HashSet 주머니같은공간 TreeSet 이진정렬해서관리
//List ArrayList LinkedList 중간삽입이 쉬움 Vector배열로관리 배열의장점:메모리에 어떻게 공간차지하는지 연속적인 공간할당받음 접근하면 순차적인 자료호출이 제일 빠름
//Map key  


