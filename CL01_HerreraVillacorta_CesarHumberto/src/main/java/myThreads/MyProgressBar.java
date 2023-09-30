package myThreads;

import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class MyProgressBar extends Thread {
	private String name;
	private int numberOfSteps, index;
    private JProgressBar progressBar;
    public static volatile JProgressBar winner; // track the winner 
	public static volatile boolean raceInProgress; // track if the race is in progress
	public static volatile int totalOfBars; // total of progressBars
	public static volatile int randomIndex; // selects random ProgressBar to step forward
	
    public MyProgressBar(String name, JProgressBar progressBar, int index, int numberOfSteps) {
    	this.name = name;
        this.progressBar = progressBar;
        this.index = index;
        this.numberOfSteps = numberOfSteps;
        this.progressBar.setMinimum(0);
        this.progressBar.setMaximum(numberOfSteps);
        this.progressBar.setValue(0);
    }
    
    public void run() {
    	int value = progressBar.getValue();
        while (value<numberOfSteps && winner == null && raceInProgress) {
        	if(index == randomIndex) {        		
	            value += 1;
	            progressBar.setValue(value);
	            randomIndex = getRandomValue();
        	}
            try {
                Thread.sleep(300);                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        if (winner == null && raceInProgress) {
            raceInProgress = false;
            winner = progressBar;
            JOptionPane.showMessageDialog(null, name + " has finished and is the winner");
        }
        
        progressBar.setValue(0);
    }
    
    public static int getRandomValue() {
    	return new Random().nextInt(totalOfBars);
    }
}