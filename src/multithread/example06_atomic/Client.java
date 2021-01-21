package multithread.example06_atomic;

import java.util.Random;

public class Client {
	
	public static void main(String[] args) {
		Metric metric = new Metric();
		
		BusinessLogic businessLogicThread1 = new BusinessLogic(metric);
		
		BusinessLogic businessLogicThread2 = new BusinessLogic(metric);
		
		
		MetrhicPrinter metrhicPrinter = new MetrhicPrinter(metric);
		
		businessLogicThread1.start();
		businessLogicThread2.start();
		metrhicPrinter.start();
	}

	public static class MetrhicPrinter extends Thread {
		private Metric metric;

		public MetrhicPrinter(Metric metric) {
			super();
			this.metric = metric;
		}

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					// TODO: handle exception
				}

				double average = metric.getAverage();

				System.out.println("current Average is: " + average);
			}
		}

	}

	public static class BusinessLogic extends Thread {

		private Metric metric;
		private Random random = new Random();

		public BusinessLogic(Metric metric) {
			this.metric = metric;
		}

		@Override
		public void run() {

			while (true) {
				long start = System.currentTimeMillis();

				try {
					Thread.sleep(random.nextInt(10));
				} catch (Exception e) {
				}

				long end = System.currentTimeMillis();

				metric.addSample(end - start);
			}

		}

	}

	public static class Metric {
		private long count = 0;
		private volatile double average = 0.0;

		public synchronized void addSample(long sample) {
			average = (average * count + sample) / (count + 1);
		}

		public synchronized double getAverage() {
			return average;
		}

	}
}
