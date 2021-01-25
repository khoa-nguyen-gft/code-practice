package multithread.jdk_07.example09_reentrant_read_write_lock;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Client02 {
	private static final int HIGHEST_PRICE = 1000;

	public static void main(String[] args) throws InterruptedException {
		InventoryDatabase database = new InventoryDatabase();

		Random random = new Random();
		for (int i = 0; i < 1000; i++) {
			database.addItem(random.nextInt(HIGHEST_PRICE));
		}

		// 1 Writer thread
		Thread writer = new Thread(() -> {
			while (true) {
				database.addItem(random.nextInt(HIGHEST_PRICE));
				database.removeItem(random.nextInt(HIGHEST_PRICE));

				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

//		/writer.setDaemon(true);
		writer.start();

		// 7 Reader thread
		int numberOfReaderThread = 100;

		List<Thread> readers = new ArrayList<Thread>();
		for (int i = 0; i < numberOfReaderThread; i++) {
			Thread reader = new Thread(() -> {
				for (int j = 0; j < 10_000; j++) {
					int upperBoundPrice = random.nextInt(HIGHEST_PRICE);
					int lowerBoundPrice = upperBoundPrice > 0 ? random.nextInt(upperBoundPrice) : 0;

					database.getNumberOfItemsInPriceRange(lowerBoundPrice, upperBoundPrice);
				}
			});
			//reader.setDaemon(true);
			readers.add(reader);
		}

		long startTime = System.currentTimeMillis();
		for (Thread read : readers) {
			read.start();
		}

		for (Thread read : readers) {
			read.join();
		}

		long endTime = System.currentTimeMillis();

		System.out.println(String.format("Reading took %d ms", endTime - startTime));

	}

	public static class InventoryDatabase {
		private TreeMap<Integer, Integer> priceToCountMap = new TreeMap<>();
		private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
		private Lock readLock = readWriteLock.readLock();
		private Lock writeLock = readWriteLock.writeLock();

		public int getNumberOfItemsInPriceRange(int lowerBound, int upperBound) {
			readLock.lock();
			try {
				Integer fromKey = priceToCountMap.ceilingKey(lowerBound);
				Integer toKey = priceToCountMap.floorKey(upperBound);

				if (fromKey == null || toKey == null) {
					return 0;
				}
				// System.out.println("fromKey: "+ fromKey + "toKey: "+ toKey);
				NavigableMap<Integer, Integer> rangeOfPrices = priceToCountMap.subMap(fromKey < toKey ? fromKey : toKey,
						true, toKey > fromKey ? toKey : fromKey, true);

				int sum = 0;

				for (int i : rangeOfPrices.values()) {
					sum += i;
				}

				return sum;
			} finally {
				readLock.unlock();
			}
		}

		public void addItem(int price) {
			writeLock.lock();
			try {

				Integer numberOfItem = priceToCountMap.get(price);
				if (numberOfItem == null) {
					priceToCountMap.put(price, 1);
					return;
				}

				priceToCountMap.put(price, numberOfItem + 1);
			} finally {
				writeLock.unlock();
			}
		}

		public void removeItem(int price) {
			writeLock.lock();
			try {
				Integer numberOfItem = priceToCountMap.get(price);

				if (numberOfItem == null || numberOfItem == 1) {
					priceToCountMap.remove(price);
					return;
				}

				priceToCountMap.put(price, numberOfItem - 1);
			} finally {
				writeLock.unlock();
			}
		}
	}
}
