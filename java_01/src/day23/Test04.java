package day23;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Date;

public class Test04 {
	public static void main(String[] args) {
		String filename = "data.obj";
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(filename);
			ois = new ObjectInputStream(fis);
			
			String name = null;
			Date d = null; 
			name = (String)ois.readObject();
			Date date = (Date)ois.readObject();
			
			System.out.println("Read " + name);
			System.out.println("Read " + date);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (ois != null) ois.close();
				if (fis != null) fis.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println("main end");	
	} 
}

//try {
//	
//} catch (Exception e) {
//	System.out.println(e.getMessage());
//} finally {
//	try {
//		if (oos != null) oos.close();
//		if (fos != null) fos.close();
//	} catch (Exception e2) {
//		e2.printStackTrace();
//	}
//}