package day05;

import java.util.Arrays;

public class Test03___ {

	public static void main(String[] args) {
		String msg = "hello JAVA ~~~ ";
		String msg2 = "hi ~~~ SQL ~~~ ";
		
		//char[] c = {'h','e','l'};
		
		char[] c = new char[msg.length()];
		for(int i=0; i<msg.length(); i++) {
			c[i] = msg.charAt(i);
		}   
		
		//////////////////////////////////////////////////////////////////////////////////////
		char[] cc = msg.toCharArray();  // toCharArray가  복사하고싶은 char배열길이, 배열주소를 복사해줌 (위의 3줄역할을함)
		cc[0]='Q'; 
		
		String ne = new String(cc); // char배열인 cc가 String으로 감 둘다 문자이기때문에 char형과 String형은 형이 왔다갔다하기쉽다.
		
		System.out.println(msg);
		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.toString(cc));
		System.out.println(ne);
		
	}

}
