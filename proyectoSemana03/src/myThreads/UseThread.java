package myThreads;

public class UseThread {

	public static void main(String[] args) {
		MyThread t1, t2;
		t1 = new MyThread("Jose");
		t2 = new MyThread("Karla");
		
		t1.start();
		t2.start();
	}
}
