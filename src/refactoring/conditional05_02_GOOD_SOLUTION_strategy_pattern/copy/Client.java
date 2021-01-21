package refactoring.conditional05_02_GOOD_SOLUTION_strategy_pattern.copy;

public class Client {

	public static void main(String[] args) {
		Employee saleman = new Saleman(15000.0);
		Employee secreary = new Secretary(20000.0);

		System.out.println(saleman.getPay());
		System.out.println(secreary.getPay());

		saleman.setBonusOption(new GetsBonus());
		secreary.setBonusOption(new bonus20Per());
		
		System.out.println(saleman.getPay());
		System.out.println(secreary.getPay());
	}
}

class Employee {
	protected double salary = 0.0;
	
	public Pay payType = new NoBonus();

	public Employee(double salary) {
		super();
		this.salary = salary;
	}

	public Employee(double salary, Pay payType) {
		super();
		this.salary = salary;
		this.payType = payType;
	}

	public Pay getPayType() {
		return payType;
	}

	public void setBonusOption(Pay payType) {
		this.payType = payType;
	}
	
	public double getPay() {
		return payType.getPay(this.salary);
	}
	
	
	
	
} 

class Saleman extends Employee {

	public Saleman(double salary) {
		super(salary);
	}
	
	public Saleman(double salary, Pay payType) {
		super(salary);
		setBonusOption(payType);		
	}
	
//	public double getPay() {
//		return payType.getPay(this.salary);
//	}
	
}

class Secretary extends Employee {


	public Secretary(double salary) {
		super(salary);
	}
	
	public Secretary(double salary, Pay payType) {
		super(salary);
		setBonusOption(payType);		
	}
	
//	public double getPay() {
//		return payType.getPay(this.salary);
//	}
	
}


interface Pay {
	double getPay(double salary);
}


class NoBonus implements Pay{

	@Override
	public double getPay(double salary) {
		return salary;
	}
	
}


class GetsBonus implements Pay {

	@Override
	public double getPay(double salary) {
		return salary + salary * .15;
	}
	
}

class bonus20Per implements Pay {

	@Override
	public double getPay(double salary) {
		return salary + salary * .2;
	}
	
}