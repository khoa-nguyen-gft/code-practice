package multithread.jdk_07.example08_reentrantlock;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Client01 {
	public static void main(String[] args) {
		PriceContainer container = new PriceContainer();
		PriceUpdater priceUpdater = new PriceUpdater(container);
		PriceDisplay display = new PriceDisplay(container);

		priceUpdater.start();
		display.start();

	}

	public static class PriceContainer {

		private ReentrantLock lock = new ReentrantLock();

		private double bitcointPrice;
		private double etherPrice;
		private double liteCointPirce;
		private double bitcointCashPrice;
		private double ripplePrice;

		public double getBitcointPrice() {
			return bitcointPrice;
		}

		public void setBitcointPrice(double bitcointPrice) {
			this.bitcointPrice = bitcointPrice;
		}

		public double getEtherPrice() {
			return etherPrice;
		}

		public void setEtherPrice(double etherPrice) {
			this.etherPrice = etherPrice;
		}

		public double getLiteCointPirce() {
			return liteCointPirce;
		}

		public void setLiteCointPirce(double liteCointPirce) {
			this.liteCointPirce = liteCointPirce;
		}

		public double getBitcointCashPrice() {
			return bitcointCashPrice;
		}

		public void setBitcointCashPrice(double bitcointCashPrice) {
			this.bitcointCashPrice = bitcointCashPrice;
		}

		public double getRipplePrice() {
			return ripplePrice;
		}

		public void setRipplePrice(double ripplePrice) {
			this.ripplePrice = ripplePrice;
		}

		public ReentrantLock getLock() {
			return lock;
		}

		public void setLock(ReentrantLock lock) {
			this.lock = lock;
		}

		@Override
		public String toString() {
			return "PriceContainer [\n\t bitcointPrice=" + bitcointPrice + "\n\t etherPrice=" + etherPrice
					+ "\n\t liteCointPirce=" + liteCointPirce + "\n\t bitcointCashPrice=" + bitcointCashPrice
					+ "\n\t ripplePrice=" + ripplePrice + "\n]";
		}

	}

	public static class PriceUpdater extends Thread {
		private PriceContainer container;
		private Random random = new Random();

		public PriceUpdater(PriceContainer container) {
			super();
			this.container = container;
		}

		@Override
		public void run() {
			while (true) {

				container.getLock().lock();
				try {
					Thread.sleep(1000);

					container.setBitcointPrice(random.nextInt(2000));
					container.setEtherPrice(random.nextInt(2000));
					container.setLiteCointPirce(random.nextInt(500));
					container.setBitcointCashPrice(random.nextInt(500));
					container.setRipplePrice(random.nextInt(500));

				} catch (Exception ex) {
					ex.printStackTrace();
				} finally {
					container.getLock().unlock();
				}

				try {
					Thread.sleep(100);
					// System.out.println(container.toString());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static class PriceDisplay extends Thread {
		private PriceContainer container;
		private Random random = new Random();

		public PriceDisplay(PriceContainer container) {
			this.container = container;
		}

		@Override
		public void run() {
			while (true) {
				if (container.getLock().tryLock()) {

					try {
						Thread.sleep(random.nextInt(5000));
						System.out.println("Try to get price container: ");

						System.out.println("List price of coins: ");
						System.out.println("BTC: " + container.getBitcointPrice());
						System.out.println("ETH: " + container.getEtherPrice());
						System.out.println("LTC: " + container.getLiteCointPirce());
						System.out.println("BHC: " + container.getBitcointCashPrice());
						System.out.println("XRP: " + container.getRipplePrice());

					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						container.getLock().unlock();
					}
				}
			}
		}

	}
}
