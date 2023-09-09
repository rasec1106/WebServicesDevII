package myThreads;

public class myThread extends Thread {
	// Constructor
	public myThread(String name) {
		super(name);
	}
	
	// "run" method -> where we code the process it will be doing
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println(i+" "+getName());
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Finished!!! "+getName());
	}
}
