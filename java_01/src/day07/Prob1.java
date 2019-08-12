package day07;

public class Prob1 {
	
	public String rightPad(String str, int size, char padChar) {
		if(str.length()>size) {
			return str;
		}
		int count = size-str.length();
		for(int i=0; i<count;i++) {
			str = str+padChar;
		}
		return str;
	}
	
	
	public String leftPad(String str, int size, char padChar) {
		if(str.length()>size) {
			return str;
		}
		int count = size-str.length();
		for(int i=0; i<count;i++) {
			str = padChar+str;
		}
		return str;
	}
	

	public static void main(String[] args) {
		
		Prob1 prob1 = new Prob1();
		System.out.println( prob1.leftPad("bit", 6, '#') );
		System.out.println( prob1.leftPad("bit", 5, '$') ); 
		System.out.println( prob1.leftPad("bit", 2, '&') ); 
		
		System.out.println( prob1.rightPad("bit", 6, '#') );
		System.out.println( prob1.rightPad("bit", 5, '$') ); 
		System.out.println( prob1.rightPad("bit", 2, '&') ); 
	}
	
}