package multithread.jdk_01.example05_share_resource;

public class Step01 {
	public static void main(String[] args) throws InterruptedException {
		InventoryCounter counter = new InventoryCounter();
		
		IncrementThread increment = new IncrementThread(counter);
		DecrementThread decrement = new DecrementThread(counter);
		
		
		increment.start();
		increment.join();
		
		decrement.start();
		decrement.join();
		
		System.out.println("We current have: " + counter.getItems());
	}
	
	public static class DecrementThread extends Thread{
		private InventoryCounter counter;

		public DecrementThread(InventoryCounter counter) {
			super();
			this.counter = counter;
		}

		@Override
		public void run() {
			for (int i = 0; i < 1000; i++) {
				counter.decrement();
			}
		}
	}
	
	public static class IncrementThread extends Thread{
		private InventoryCounter counter;

		public IncrementThread(InventoryCounter counter) {
			super();
			this.counter = counter;
		}

		@Override
		public void run() {
			for (int i = 0; i < 1000; i++) {
				counter.increment();
			}
		}
	}
	
	private static class InventoryCounter {
		private int items = 0;

		public void increment() {
			items++;			
		}
		
		public void decrement() {
			items--;			
		}
		
		public int getItems() {
			return items;
		}		
	}
	
	
	
}



