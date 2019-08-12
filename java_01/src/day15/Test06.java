package day15;

import javax.swing.JOptionPane;

public class Test06 {
	public static void main(String[] args) {
		String msg = JOptionPane.showInputDialog("1.list 2.update 3.delete 4.insert q.quit");
		
		// Test05를 람다표기법으로 바꿈  인터페이스에 추상메소드가 하나만 있어야 람다로 전환할수있다.
		// 람다 => 변수에 함수를 등록하여 사용하는 기능
		Command list   = () ->  System.out.println("*** list  ***"); // Command 추상메소드 1개밖에 없어서
		Command update = () -> System.out.println("*** update ***");
		Command delete = () -> System.out.println("*** delete ***");
		Command insert = () -> System.out.println("*** insert ***");
		
		switch (msg) {
		case "1":
			list.exec();
			break;
		case "2":
			update.exec();
			break;
		case "3":
			delete.exec();
			break;
		case "4":
			insert.exec();
			break;
		default:
			break;
		}
		
	}
}
