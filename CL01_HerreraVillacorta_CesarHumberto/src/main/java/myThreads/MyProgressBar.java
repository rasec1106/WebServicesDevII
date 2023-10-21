package myThreads;

import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class MyProgressBar extends Thread {
	private String name;
	private int numberOfSteps, index;
    private JProgressBar progressBar;
    public static volatile JProgressBar winner; // cajero ganador
	public static volatile boolean raceInProgress; // si la carrera aun esta en proceso
	public static volatile int totalOfBars; // total de progressBars
	public static volatile int randomIndex; // un indice aleatorio elegido a priori
	
    public MyProgressBar(String name, JProgressBar progressBar, int index, int numberOfSteps) {
    	this.name = name;
        this.progressBar = progressBar;
        this.index = index; // indice del hilo (para compararlo con randomIndex)
        this.numberOfSteps = numberOfSteps; // numero de pasos que tiene el progressBar
        this.progressBar.setMinimum(0);
        this.progressBar.setMaximum(numberOfSteps);
        this.progressBar.setValue(0);
    }
    
    public void run() {
    	int value = progressBar.getValue();
        while (value<numberOfSteps && winner == null && raceInProgress) {
        	// aqui solo entra quien ha sido elegido aleatoriamente
        	if(index == randomIndex) {        		
	            value += 1;
	            progressBar.setValue(value);
	            randomIndex = getRandomValue(); // se setea un nuevo randomIndex para todos los hilos
        	}
            try {
                Thread.sleep(300);                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // El primero que llega aqui sera el ganador
        if (winner == null && raceInProgress) {
            raceInProgress = false;
            winner = progressBar;
            JOptionPane.showMessageDialog(null, name + " has finished and is the winner");
        }
        // Reiniciamos el proceso
        progressBar.setValue(0);
    }
    
    // Metodo para obtener un entero aleatorio
    public static int getRandomValue() {
    	return new Random().nextInt(totalOfBars);
    }
}