package design_pattern.constructor_singleston;

public class Step01 {
	public static void main(String[] args) {
		BasicSingleton singleton = BasicSingleton.getInstance();
		
		singleton.setValue(20);
		
		System.out.println(singleton.toString());
	}
}

class BasicSingleton {
	private static final BasicSingleton INSTANCE = new BasicSingleton();

	private int value;
	
	private BasicSingleton() {
	}
	
	public static BasicSingleton getInstance() {
		return INSTANCE;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "BasicSingleton [value=" + value + "]";
	}	
	
	 
	
}
