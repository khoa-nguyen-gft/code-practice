package refactoring.conditional05_01_issue_strategy_pattern;

public class Client {

	public static void main(String[] args) {
		Employee saleman = new Employee(true, 15000.0, 3);
		Employee secreary = new Employee(false, 20000.0);
		
		System.out.println("Sale man: " + saleman.getSalary());
		System.out.println("Secreary: " + secreary.getSalary());

	}
}


class Employee {
	private boolean bonus = false;
	private double salary = 0.0;
	
	private double bonusAmount = .15;
	
	
	public Employee(boolean bonus, double salary) {
		super();
		this.bonus = bonus;
		this.salary = salary;
	}
	
	public Employee(boolean bonus, double salary, double bonusAmount) {
		super();
		this.bonus = bonus;
		this.salary = salary;
		this.bonus = bonus;
	}


	public boolean isBonus() {
		return bonus;
	}


	public void setBonus(boolean bonus) {
		this.bonus = bonus;
	}


	public double getSalary() {
		
		if (bonus) salary += (salary * bonusAmount);
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
}
