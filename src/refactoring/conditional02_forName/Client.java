package refactoring.conditional02_forName;


public class Client {
	public static void main(String[] args) {
		CustomerFactory factory = new CustomerFactory();
		Customer customer = factory.getCustomer(DeadBeat.class.getName());
		
		System.out.println(customer.getCustRating());
	}
}


 abstract class Customer {
	
	private String custRating;
	static final int PREMIER = 2;
	static final int VALUED = 1;
	static final int DEADBEAT = 0;
	
	public String getCustRating() {
		return custRating;
	}
	public void setCustRating(String custRating) {
		this.custRating = custRating;
	}

}

class DeadBeat extends Customer {

	public DeadBeat() {
		setCustRating("DeadBeat Customer");
	}
	
}

class Premier extends Customer {

	public Premier() {
		setCustRating("Premier Customer");
	}
	
}

class Valued extends Customer {

	public Valued() {
		setCustRating("Valued Customer");
	}
	
}

class CustomerFactory {
	public Customer getCustomer(String custName) {
		try{
			return (Customer) Class.forName(custName).newInstance();
		} catch(Exception e) {
			throw new IllegalAccessError("cust type is not correct");
		}
	}
}