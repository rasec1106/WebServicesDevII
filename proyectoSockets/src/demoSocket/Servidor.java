package demoSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) {
		ServerSocket servidor = null;
		Socket sc = null;
		DataInputStream in;
		DataOutputStream out;
		final int PUERTO = 2020;
		
		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println("---SERVIDOR INICIADO---");
			
			while(true) {
				sc = servidor.accept();
				System.out.println("--> Cliente CONECTADO !!!");
				in = new DataInputStream(sc.getInputStream());
				out = new DataOutputStream(sc.getOutputStream());
				String mensaje = in.readUTF();
				System.out.println(mensaje);
				out.writeUTF("--> Saludos desde el SERVIDOR !!!");
				sc.close();
				System.out.println("---CLIENTE DESCONECTADO---");
			}
		}catch (Exception e) {
			System.out.println("*** ERROR: "+e.getMessage());
		}
	}

}
