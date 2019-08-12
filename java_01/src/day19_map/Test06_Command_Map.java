package day19_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test06_Command_Map {
	public static void main(String[] args) {
		// Map 구조로 설계

//		Command delete = new DeleteCommand();
//		Command update = new UpdateCommand();
//		Command select = new SelectCommand();
//		Command insert = new InsertCommand();

		Map<String, Command> map = new HashMap<String, Command>();
		map.put("delete", new DeleteCommand());
		map.put("update", new UpdateCommand());
		map.put("select", new SelectCommand());
		map.put("insert", new InsertCommand());
		map.put("new", new Command() {

			@Override
			public void exec() {
				System.out.println("기능 추가");
			}
		});

//		String cmd = args[0]; // delete update select insert
		Scanner sc = new Scanner(System.in);
		System.out.println("delete update select insert 중 하나 입력");
		String cmd = sc.nextLine(); // delete update select insert
		if (map.get(cmd) != null) {
			map.get(cmd).exec();
		}

//		switch (cmd) {
//		case "insert":
//			insert.exec();
//			break;
//		case "update":
//			update.exec();
//			break;
//		case "select":
//			select.exec();
//			break;
//		case "delete":
//			insert.exec();
//			break;
//		default:
//			System.out.println("잘못입력했습니다");
//			break;
//		}
	}
}
