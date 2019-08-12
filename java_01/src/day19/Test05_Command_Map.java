package day19;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Test05_Command_Map {
	public static void main(String[] args) {
		
		// Map 구조로 설계
		Map<String, Command> map = new HashMap<String, Command>();
		
		map.put("delete", new DeleteCommand());
		map.put("update", new UpdateCommand());
		map.put("select", new SelectCommand());
		map.put("insert", new InsertCommand());
		map.put("new", new Command() {
								@Override
								public void exec() {
									System.out.println("기능추가");
								}
						});
		
//		Command delete = new DeleteCommand();
//		Command update = new UpdateCommand();
//		Command select = new SelectCommand();
//		Command insert = new InsertCommand();
	
//		String cmd = args[0]; // delete update select insert
		Scanner scanner = new Scanner(System.in);
		System.out.println("delete update select insert 중 하나 입력 하세요.");
		String cmd = scanner.nextLine(); // delete update select insert 
		
//		map.get(cmd).exec();
		
		Command command = map.get(cmd);
		if(command != null)command.exec();
		
//		switch(cmd) {
//			case "insert":
//				insert.exec();
//			break;
//			case "update":
//				update.exec();
//			break;
//			case "select":
//				select.exec();
//			break;
//			case "delete":
//				delete.exec();
//			break;
//			default:
//				System.out.println("잘못입력했습니다.");
//			break;
//		}
		
		
	}

}
