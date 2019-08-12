package day17;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class Test03 {
	public static void main(String[] args) {
			List list = new Vector();	//Object 배열
			//System.out.println(list);
			list.add("hello");
			list.add("java");
			list.add(200);
			list.add(new Date());
			list.add(new Book("Spring", 50000));
			System.out.println(list);
			
			for (int i = 0;i < list.size();i++ ) {		//전부 Object로 넣기때문에 다운캐스티잉 필요하다.
				System.out.println(list.get(i));
			}
			
			
	}
}
