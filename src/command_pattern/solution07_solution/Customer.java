package command_pattern.solution07_solution;

public class Customer {
	private int age;
	private boolean man;
	private double bill;
	
	public static void main(String[] args) {
		Customer customer = new Customer(62, true, 12);
		System.out.println(customer.returnFinalBill());
		
	}
	
	public double returnFinalBill() {
		double percentageOff = 0.0;
		if (age > 60) 
			percentageOff += 0.05;
		if (!man)
			percentageOff += 0.05;
		
		return bill - bill * percentageOff;
	}
	
	public Customer(int age, boolean man, double bill) {
		super();
		this.age = age;
		this.man = man;
		this.bill = bill;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isMan() {
		return man;
	}
	public void setMan(boolean man) {
		this.man = man;
	}
	public double getBill() {
		return bill;
	}
	public void setBill(double bill) {
		this.bill = bill;
	}
	
	
}
