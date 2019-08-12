package day23;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.Set;

public class Test06 {
	public static void main(String[] args) {
		String filename = "account.obj";
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(filename);
			ois = new ObjectInputStream(fis);
			
			Set<Account> a1 = (Set<Account>) ois.readObject();
//			Account a1 = (Account) ois.readObject();
//			System.out.println("Read "+a1);
//			System.out.println(ois.readObject());
			a1.forEach(i->System.out.println(i));
			
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