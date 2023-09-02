package minichat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

	private Socket socket;
	private ServerSocket serverSocket;
	private DataInputStream bufferDeEntrada = null;
	private DataOutputStream bufferDeSalida = null;
	private Scanner tecla = new Scanner(System.in);
	final String COMANDO_FIN = "exit";
	
	public void abrirConexion(int puerto) {
		try {
			serverSocket = new ServerSocket(puerto);
			mostrar("Esperando conexion entrante en el puerto "+puerto);
			socket = serverSocket.accept();
			mostrar("Conexion establecida con: "+socket.getInetAddress().getHostName());
		} catch (Exception e) {
			mostrar("*** ERROR EN CONEXION: "+e.getMessage());
			System.exit(0);
		}
	}
	
	public void flujos() {
		try {
			bufferDeEntrada = new DataInputStream(socket.getInputStream());
			bufferDeSalida = new DataOutputStream(socket.getOutputStream());
			bufferDeSalida.flush(); // to clear all the information it could has inside
		} catch (Exception e) {
			mostrar("*** ERROR EN APERTURA DE FLUJOS: "+e.getMessage());
		}
	}
	
	public void cerrarConexion() {
		try {
			bufferDeEntrada.close();
			bufferDeSalida.close();
			socket.close();
		} catch (Exception e) {
			mostrar("*** ERROR AL CERRAR LA CONEXION: "+e.getMessage());
		}finally {
			mostrar("===CONVERSACION FINALIZADA===");
			System.exit(0);
		}
	}
	
	public void recibirDatos() {
		String st = "";
		try {
			do {
				st = (String) bufferDeEntrada.readUTF();
				mostrar("\n[CLIENTE]==> "+st);
				mostrar("\n[USTED]==> ");
			} while(!st.equals(COMANDO_FIN));
		} catch (IOException e) {
			cerrarConexion();
		}
	}
	
	public void enviar(String st) {
		try {
			bufferDeSalida.writeUTF(st);
			bufferDeSalida.flush();
		} catch (Exception e) {
			mostrar("*** ERROR AL ENVIAR: "+e.getMessage());
		}
	}
	
	public static void mostrar(String mensaje) {
		System.out.println(mensaje);
	}
	
	public void escribirDatos() {
		while(true) {
			mostrar("\n[USTED]==> ");
			enviar(tecla.nextLine());
		}
	}
	
	public void ejecutarConexion(int puerto) {
		Thread hilo = new Thread(new Runnable() {		
			@Override
			public void run() {
				while(true) {
					try {
						abrirConexion(puerto);
						flujos();
						recibirDatos();
					} catch (Exception e) {
						cerrarConexion();
					}
				}				
			}
		});
		hilo.start();
	}
	
	public static void main(String[] args) {
		Servidor s = new Servidor();
		Scanner tecla = new Scanner(System.in);
		
		mostrar("INGRESE NUMERO DE PUERTO [5050]:");
		String puerto = tecla.nextLine();
		if(puerto.length() <= 0 ) puerto = "5050";
		s.ejecutarConexion(Integer.parseInt(puerto));
		s.escribirDatos();
	}
}
