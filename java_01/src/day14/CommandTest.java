package day14;

import javax.swing.JOptionPane;

public class CommandTest {

	public static void main(String[] args) {
		Command cmd = new ListeCommand();
		String key = JOptionPane.showInputDialog("list/delete/insert/update 중 하나 입력"); // 메세지창
		switch (key) {
		case "delete":
			cmd = new DeleteCommand();
			break;
		case "insert":
			cmd = new InsertCommand();
			break;
		case "update":
			cmd = new UpdateCommand();
			break;
		default:
			break;
		}
		cmd.exec(); // 메소드는 하나지만 선택에 따라 다양한 기능을 한다. -> 다형성
		cmd.check(); // delete는 Command의 체크함수가 아니라 자기가 가지고 있는 DeleteCommand체크함수를 호출한다.
	}
}