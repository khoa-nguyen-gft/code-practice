package multithread.jdk_01.example07_deadlock;

import java.util.Random;

public class Client01 {
	public static void main(String[] args) {
		Intersection intersection = new Intersection();

		
		
		Thread trainA = new Thread(new TrainA(intersection));
		Thread trainB = new Thread(new TrainB(intersection));
		
		trainA.start();
		trainB.start();

	}

	public static class TrainB implements Runnable {

		private Intersection intersection;
		private Random random = new Random();

		public TrainB(Intersection intersection) {
			this.intersection = intersection;
		}

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(random.nextInt(1));
					intersection.takeRoadB();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static class TrainA implements Runnable {

		private Intersection intersection;
		private Random random = new Random();

		public TrainA(Intersection intersection) {
			this.intersection = intersection;
		}

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(random.nextInt(1));
					intersection.takeRoadA();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

}

class Intersection {
	private Object A = new Object();
	private Object B = new Object();

	public void takeRoadA() throws InterruptedException {
		synchronized (A) {
			System.out.println("Take Road A and start wait");
			synchronized (B) {
				Thread.sleep(1);
				System.out.println("compleate processing from A to B");

			}
		}
	}

	public void takeRoadB() throws InterruptedException {
		synchronized (B) {
			System.out.println("Take Road B and start wait");
			synchronized (A) {
				Thread.sleep(1);

				System.out.println("compleate processing from B to A");
			}
		}
	}
}
