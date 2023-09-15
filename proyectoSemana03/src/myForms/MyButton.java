package myForms;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MyButton extends Thread{
	int x, y;
	int limit;
	private JButton button;
	private String name;
	public static volatile JButton winner = null; // track the winner button
	public static volatile boolean raceInProgress = false; // track if the race is in progress
	
	// Constructor
	public MyButton(int x, int y, int limit, JButton button, String name) {
		this.x = x;
		this.y = y;
		this.limit = limit;
		this.button = button;
		this.name = name;
	}
	
	// run method
	public void run() {
		int value = 30;
		while(value<=limit && winner == null && raceInProgress) {
			value += (int) (Math.random()*50);
			button.setLocation(value,y);
			button.getName();
			try {
				sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// First button to finish enters here
		if(winner == null && raceInProgress) {
			winner = button;
			JOptionPane.showMessageDialog(null, name + " has finished and won the race");
		}
	}
	
	// Reset the button to its initial position
	public void resetButton() {
        button.setLocation(x, y);
    }
    
    // Stop the thread
    public void stopThread() {
        raceInProgress = false;
    }
}
