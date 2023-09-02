package minichat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	private Socket socket;
	private DataInputStream bufferDeEntrada = null;
	private DataOutputStream bufferDeSalida = null;
	private Scanner tecla = new Scanner(System.in);
	final String COMANDO_FIN = "exit";
	
	public void abrirConexion(String ip, int puerto) {
		try {
			socket = new Socket(ip, puerto);
			mostrar("Conectado a: "+socket.getInetAddress().getHostName());
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
				mostrar("\n[SERVIDOR]==> "+st);
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
		String entrada = "";
		while(true) {
			mostrar("\n[USTED]==> ");
			entrada = tecla.nextLine();
			if(entrada.length() > 0) {
				enviar(entrada);				
			}
		}
	}
	
	public void ejecutarConexion(String ip, int puerto) {
		Thread hilo = new Thread(new Runnable() {		
			@Override
			public void run() {
				while(true) {
					try {
						abrirConexion(ip, puerto);
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
		Cliente c = new Cliente();
		Scanner tecla = new Scanner(System.in);
		
		mostrar("INGRESE LA IP [localhost]:");
		String ip = tecla.nextLine();
		if(ip.length() <= 0) ip = "127.0.0.1";
		
		mostrar("INGRESE NUMERO DE PUERTO [5050]:");
		String puerto = tecla.nextLine();
		if(puerto.length() <= 0 ) puerto = "5050";
		
		c.ejecutarConexion(ip, Integer.parseInt(puerto));
		c.escribirDatos();
	}
}
