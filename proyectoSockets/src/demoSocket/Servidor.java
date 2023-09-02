package demoSocket;

import java.io.DataInput;
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
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
