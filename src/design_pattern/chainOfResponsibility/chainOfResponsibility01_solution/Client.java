package design_pattern.chainOfResponsibility.chainOfResponsibility01_solution;

public class Client {

	private DispenseChain c1;
	
	
	
	public Client() {
		c1 = new Dispense50Dollar("Dispense50Dollar");
		DispenseChain c2 = new Dispense20Dollar("Dispense20Dollar");
		DispenseChain c3 = new Dispense10Dollar("Dispense10Dollar");
		
		c1.setNextChain(c2);
		c2.setNextChain(c3);

	}



//	public DispenseChain getC1() {
//		return c1;
//	}



	public static void main(String[] args) {
		Client client = new Client();
		client.c1.dispense(new Currency(480));
	}

}
