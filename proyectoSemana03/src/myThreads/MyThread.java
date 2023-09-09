package myThreads;

public class MyThread extends Thread {
	// Constructor
	public MyThread(String name) {
		super(name);
	}
	
	// "run" method -> where we code the process of the thread
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
