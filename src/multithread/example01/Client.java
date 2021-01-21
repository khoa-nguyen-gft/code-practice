package multithread.example01;

public class Client {
	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("hello from " + Thread.currentThread().getName());
			}
		});
		
		thread.start();
		
	}
}
