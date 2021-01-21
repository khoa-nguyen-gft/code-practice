package multithread.example04_synchronized_static;

public class Client {
	public static void main(String[] args) {
		synchronizedDiffirenceObject();

	}

	private static void synchronizedDiffirenceObject() {
		Thread a = new ThreadA(new Table());
		Thread b = new ThreadB(new Table());

		a.start();
		b.start();
	}
}

class Table {
	public synchronized static void printTablewithSynchronizedBlock(int n, String name) {
//		synchronized(this) {
		for (int i = 0; i < 10; i++) {
			System.out.println(name + ": " + n * i);
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

//	}

class ThreadB extends Thread {

	private Table table;

	public ThreadB(Table table) {
		super();
		this.table = table;
	}

	@Override
	public void run() {
		table.printTablewithSynchronizedBlock(100, this.getName());
	}

}

class ThreadA extends Thread {

	private Table table;

	public ThreadA(Table table) {
		super();
		this.table = table;
	}

	@Override
	public void run() {
		table.printTablewithSynchronizedBlock(5, this.getName());
	}

}