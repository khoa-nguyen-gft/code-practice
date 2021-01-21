package refactoring.duplicate_code01_Template_pattern;



public class Cook {
	public static void main(String[] args) {
		Sandwitch customer1 = new Hambeger();
		customer1.makeSandwitch();
		
		
		Sandwitch customer2 = new VeggieSub();
		customer2.makeSandwitch();
	}
}

class Hambeger extends Sandwitch {

	@Override
	protected void addMeat() {
		System.out.println("Hamburger: Add meat");
	}

	@Override
	protected void addCondiments() {
		System.out.println("Hamburger: Add condiments");
	
	}

}


class VeggieSub extends Sandwitch {

	@Override
	public boolean customerWantMeat() {
		return false;
	}
	
	
	@Override
	protected void addMeat() {
		System.out.println("VeggieSub: Add meat");
	}

	@Override
	protected void addCondiments() {
		System.out.println("VeggieSub: Add condiments");
	
	}

}



