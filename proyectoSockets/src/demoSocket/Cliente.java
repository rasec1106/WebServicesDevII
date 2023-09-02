package demoSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Cliente {
	public static void main(String[] args) {
		final String HOST = "127.0.0.1";
		final int PUERTO = 2020;
		DataInputStream in;
		DataOutputStream out;
		
		try {
			Socket sc = new Socket(HOST, PUERTO);
			in = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream());
			out.writeUTF("--> Hola desde el CLIENTE");
			String mensaje = in.readUTF();
			System.out.println(mensaje);
			sc.close();
		} catch (Exception e) {
			System.out.println("*** ERROR: "+e.getMessage());
		}
	}
}
