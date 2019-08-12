package day16;
// 예외처리란 어떤 문제가 발생했을때 오류를 해결할 수 있는 적절한 메세지를 띄어주는 것이다.
public class Test03 {
	public static void main(String[] args) {
		System.out.println("main start");
		String msg = null;
		msg ="xmlvvdv";
		try {
			if(msg != null) {
				System.out.println(msg.charAt(3));	
			}
			int num = Integer.parseInt(msg);
		} catch (NullPointerException e) {
			System.out.println("예 외 발 생 :" + e.getMessage()); // msg ="null"; // null
		} catch (StringIndexOutOfBoundsException e){
			System.out.println("예 외 발 생 :" + e.getMessage()); // msg ="xml";  // index
		} catch (NumberFormatException e){
			System.out.println("예 외 발 생 : 정수로 입력해주세요"); 
		} catch (Exception e) {
			System.out.println("예 외 발 생 :" + e.getMessage());  // 나머지 모든 예외
		}finally { // 예외발생하든 안하든 수행하기때문에 여기에 자원반납코드를 넣어준다.
			System.out.println("finally { 자원 반납 코드 }");
		}
		System.out.println("main end");
		
	}
}
