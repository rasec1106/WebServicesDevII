package MyClasses;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serial1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p;
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		
		try {
			// Create file
			fos = new FileOutputStream("person.dat");
			out = new ObjectOutputStream(fos);
			
			// Create person object 1
			p = new Person("12345678", "Jose Lopez", 35);
			out.writeObject(p);
			
			// Create person object 2
			p = new Person("98467509", "Flor Becerra", 31);
			out.writeObject(p);
			
			// Create person object 3
			p = new Person("66725642", "Luis Suarez", 27);
			out.writeObject(p);
			
		} catch (FileNotFoundException e) {
			System.out.println("1 - "+e.getMessage());
		} catch (IOException e) {
			System.out.println("2 - "+e.getMessage());
		} finally {
			try {
				if(fos != null) fos.close();
				if(out != null) out.close();
				System.out.println("--- FILE CREATED SUCCESFULLY ---");
			} catch (IOException e) {
				System.out.println("3 - "+e.getMessage());
			}
		}
	}

}
