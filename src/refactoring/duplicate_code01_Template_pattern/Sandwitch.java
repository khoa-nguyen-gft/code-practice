package refactoring.duplicate_code01_Template_pattern;

public abstract class Sandwitch {
	
	final void makeSandwitch() {
		System.out.println("\n---------NEW ORDER -------------\n");
		
		cutBun();
		
		if (customerWantMeat()) {
			addMeat();
		} 
		
		addVegetable();
		
		if (customerWantCondiments()) {
			addCondiments();
		}
		
		wrapSandwitch();
	}


	private boolean customerWantCondiments() {
		return true;
	}


	public boolean customerWantMeat() {
		return true;
	}


	protected abstract void addMeat();
	protected abstract void addCondiments();


	public void cutBun() {
		System.out.println("the bun was Cut");
	}
	

	public void addVegetable() {
		System.out.println("lettuce, onion, tomatoes");
	}
	
	public void wrapSandwitch() {
		System.out.println("The Sandwitch was Wrapped");
	}
	
}
