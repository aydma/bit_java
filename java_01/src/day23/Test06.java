package day23;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.Set;

public class Test06 {
	public static void main(String[] args) {
		String fileName = "account.obj";
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		// Set<Account> 읽어오기
		
		try {
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			
			System.out.println(" Data Object Read ");
			Set<Account> a1 = (Set<Account>) ois.readObject(); 
			
//			System.out.println("Read "+a1);
//			System.out.println(ois.readObject());
			a1.forEach(i-> System.out.println(i));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(ois!= null) ois.close();
				if(fis!= null) fis.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		System.out.println("  main end  ");
	}
}
