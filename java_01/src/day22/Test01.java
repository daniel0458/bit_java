package day22;

import java.io.File;
import java.util.Date;

import javax.print.DocFlavor.INPUT_STREAM;

public class Test01 {
	public static void main(String[] args) {
		File dir = new File("c:\\");
		String[] list = dir.list();
		
		File file = null;
		Date date = null;
		for(String data : list) {
			file = new File(dir,data);
			System.out.println(file.getName() +"\t");
			System.out.println(file.length()+"\t");
			date = new Date(file.lastModified());
			System.out.println(date+"\t");
			
			if(file.isDirectory()) System.out.println("<dir>");
			System.out.println();
		}
		
	}
}
