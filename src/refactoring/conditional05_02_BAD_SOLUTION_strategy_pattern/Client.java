package refactoring.conditional05_02_BAD_SOLUTION_strategy_pattern;

public class Client {

	public static void main(String[] args) {
		Employee saleman = new Employee(true, 15000.0);
		Employee secreary = new Employee(false, 20000.0);
		
		System.out.println("Sale man: " + saleman.getSalary());
		System.out.println("Secreary: " + secreary.getSalary());

	}
}


class Employee {
	private boolean bonus = false;
	private double salary = 0.0;
	
	
	public Employee(boolean bonus, double salary) {
		super();
		this.bonus = bonus;
		this.salary = salary;
	}


	public boolean isBonus() {
		return bonus;
	}


	public void setBonus(boolean bonus) {
		this.bonus = bonus;
	}


	public double getSalary() {
		
		if (bonus) salary += salary + 0.15;
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
}
