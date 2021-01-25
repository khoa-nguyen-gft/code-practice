package design_pattern.chainOfResponsibility.chainOfResponsibility01_solution;

public interface DispenseChain {
	void setNextChain(DispenseChain nextChain);
	void dispense(Currency currency);
	String getName();
}


class Dispense50Dollar implements DispenseChain {

	private DispenseChain nextChain;
	private String name;
	
	
	public Dispense50Dollar() {
		super();
	}
		

	public Dispense50Dollar(String name) {
		this.name = name;
	}


	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public void dispense(Currency currency) {
		int amount = currency.getAmount();
		if (amount > 50) {
			int num = amount/50;
			int remain = amount % 50;
			System.out.println("Dispense: " + num + " " + name);
			
			if (nextChain != null) {
				// execute next dispense 
				System.out.println("The next dispense is: " + nextChain.getName());
				this.nextChain.dispense(new Currency(remain));
			}

		}
	}

	public String getName() {
		return name;
	}
	
	
	
}

class Dispense20Dollar implements DispenseChain {

	private DispenseChain nextChain;
	private String name;

	public Dispense20Dollar(String name) {
		this.name = name;
	}

	
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public void dispense(Currency currency) {
		int amount = currency.getAmount();
		if (amount > 20) {
			int num = amount/20;
			int remain = amount % 20;
			System.out.println("Dispense: " + num + " " + name);
			
			if (nextChain != null) {
				// execute next dispense 
				System.out.println("The next dispense is: " + nextChain.getName());
				this.nextChain.dispense(new Currency(remain));
			}

		}
	}
	

	public String getName() {
		return name;
	}
	
}


class Dispense10Dollar implements DispenseChain {

	private DispenseChain nextChain;
	private String name;

	public Dispense10Dollar(String name) {
		this.name = name;
	}

	
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public void dispense(Currency currency) {
		int amount = currency.getAmount();
		if (amount >= 10) {
			int num = amount/10;
			int remain = amount % 10;
			System.out.println("Dispense: " + num + " " + name);
			
			if (nextChain != null) {
				// execute next dispense 
				System.out.println("The next dispense is: " + nextChain.getName());
				this.nextChain.dispense(new Currency(remain));
			}


		}
	}
	

	public String getName() {
		return name;
	}
	
}
