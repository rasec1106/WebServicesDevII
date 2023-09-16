package MyClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Serial2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		ObjectInputStream in = null;
		Person p;
		
		try {
			fis = new FileInputStream("person.dat");
			in = new ObjectInputStream(fis);
			
			p = (Person) in.readObject();
			System.out.println(p.getDni() + "\t" + p.getName() + "\t" + p.getAge());
			
			p = (Person) in.readObject();
			System.out.println(p.getDni() + "\t" + p.getName() + "\t" + p.getAge());
			
			p = (Person) in.readObject();
			System.out.println(p.getDni() + "\t" + p.getName() + "\t" + p.getAge());
		} catch (FileNotFoundException e) {
			System.out.println("1 - "+e.getMessage());
		} catch (IOException e) {
			System.out.println("2 - "+e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("3 - "+e.getMessage());
		} finally {
			try {
				if(fis != null) fis.close();
				if(in != null) in.close();
			} catch (IOException e) {
				System.out.println("4 - "+e.getMessage());
			}
		}

	}

}
