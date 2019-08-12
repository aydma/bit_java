package day15;

import javax.swing.JOptionPane;

public class Test05 {
	public static void main(String[] args) {
		String msg = JOptionPane.showInputDialog("1.list 2.update 3.delete 4.insert q.quit");
		
		Command list = new Command() { //  Comman()->인터페이스인 이름없는 클래스선언,생성 
			@Override
			public void exec() {
				System.out.println("*** list  ***");
			}
		};
//		list.exec();
		
		
		Command update = new Command() {
			@Override
			public void exec() {
				System.out.println("*** update ***");
			}
		};
//		update.exec();
		
		Command delete = new Command() {
			@Override
			public void exec() {
				System.out.println("*** delete ***");
			}
		};
//		delete.exec();
		
		Command insert = new Command() {
			@Override
			public void exec() {
				System.out.println("*** insert ***");
			}
		};
//		insert.exec();
		
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
