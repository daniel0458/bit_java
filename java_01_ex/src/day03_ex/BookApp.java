package day03_ex;

import java.util.Scanner;

/**
 * 
 * @author user
 *
 */
public class BookApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int button;
		String work = null;
		String yn;
		while(true) {
			System.out.println("*******  명령 선택   *******");
			System.out.println("1. insert(등록)\n");
			System.out.println("2. delete(삭제)\n");
			System.out.println("3. update(수정)\n");
			System.out.println("4. quit(종료)\n");
			System.out.println("*************************\n");
			System.out.println("수행할 명령을 선택하세요!");
			System.out.print("1 2 3 4 중 하나를 선택하세요.. _");
			button = sc.nextInt();
            sc.nextLine();
			switch (button) {
			case 1:
				work = "등록";
				break;
			case 2:
				work = "삭제";
				break;
			case 3:
				work = "수정";
				break;
			case 4:
				System.out.print("정말 종료하시겠습니까? Y/N");
				
				yn = sc.nextLine().trim();
				if(yn.equals("Y") || yn.equals("y")) {
					sc.close();
					sc = null;
					System.exit(0);
				}else {
					break;
				}
				
			default:
				continue;
			}

			System.out.printf("%s 작업을 수행합니다.%n", work);

		}

	}
}
