package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonSerializer {

    public static void serializeJson(JSONObject jsonObject) {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		
		try {
			// Create file
			fos = new FileOutputStream("json.dat");
			out = new ObjectOutputStream(fos);
			out.writeObject(jsonObject.toString());
			
		} catch (FileNotFoundException e) {
			System.out.println("1 - "+e.getMessage());
		} catch (IOException e) {
			System.out.println("2 - "+e.getMessage());
		} finally {
			try {
				if(fos != null) fos.close();
				if(out != null) out.close();
				JOptionPane.showMessageDialog(null, "--- FILE CREATED SUCCESFULLY ---");
			} catch (IOException e) {
				System.out.println("3 - "+e.getMessage());
			}
		}
    }
    
    public static JSONObject deserializeJson() {
    	FileInputStream fis = null;
		ObjectInputStream in = null;
		JSONObject json = new JSONObject();
		
		try {
			fis = new FileInputStream("json.dat");
			in = new ObjectInputStream(fis);
			String jsonString = (String) in.readObject();
			json = (JSONObject) new JSONParser().parse(jsonString);
		} catch (FileNotFoundException e) {
			System.out.println("1 - "+e.getMessage());
		} catch (IOException e) {
			System.out.println("2 - "+e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("3 - "+e.getMessage());
		} catch (ParseException e) {
			System.out.println("4 - "+e.getMessage());
		} finally {
			try {
				if(fis != null) fis.close();
				if(in != null) in.close();
			} catch (IOException e) {
				System.out.println("5 - "+e.getMessage());
			}
		}
    	return json;
    }
}
