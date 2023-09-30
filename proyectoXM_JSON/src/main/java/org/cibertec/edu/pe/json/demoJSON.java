package org.cibertec.edu.pe.json;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class demoJSON {
	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		try {
				Object obj = parser.parse(new FileReader("usuarios.json"));
				JSONObject json = (JSONObject)obj;
				System.out.println("JSON LEIDO :" + json);
				
				// El objeto json se recorrera mediante un array
				JSONArray array = (JSONArray)json.get("Usuarios");
				System.err.println("");
				
				// Recorrer el array
				for(int i = 0; i < array.size(); i++) {
					JSONObject jsonRow = (JSONObject)array.get(i);
					System.out.println("\n=== DATOS DEL USUARIO :" + (i+1) + "===");
					System.out.println("---> ID :" + jsonRow.get("id"));
					System.out.println("---> NOMBRE :" + jsonRow.get("nombre"));
					System.out.println("---> TELEFONO :" + jsonRow.get("telefono"));
					System.out.println("---> CORREO :" + jsonRow.get("email"));
				}
		} catch (Exception e) {
				System.out.println("\nERROR:" + e.getMessage());
		}
	}
}
