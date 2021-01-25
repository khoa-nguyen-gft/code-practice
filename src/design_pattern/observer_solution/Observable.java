package design_pattern.observer_solution;

import java.util.List;

public class Observable {
	private List<Observer> observers;

	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	public void notifyObserver() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

}
