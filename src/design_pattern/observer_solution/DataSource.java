package design_pattern.observer_solution;

public class DataSource {
	private int value;
	
	private Observable observerble;
	
	
	public DataSource(Observable observerble) {
		this.observerble = observerble;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
		observerble.notifyObserver();
	}
	
	
}
