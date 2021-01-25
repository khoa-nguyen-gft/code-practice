package design_pattern.visitor.visitor03_solution;

public interface ItemMember {
	public void apply(PostageVisitor postageVisitor);
}


class Book implements ItemMember {
	private String name;
	private double price;
	private double weight;
	
	public Book(String name, double price, double weight) {
		this.name = name;
		this.price = price;
		this.weight = weight;
	}

	@Override
	public void apply(PostageVisitor postageVisitor) {
		postageVisitor.visit(this);
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public double getWeight() {
		return weight;
	}	
}

class CD implements ItemMember {
	private String name;
	private double price;
	private double weight;
	
	
	public CD(String name, double price, double weight) {
		super();
		this.name = name;
		this.price = price;
		this.weight = weight;
	}
	@Override
	public void apply(PostageVisitor postageVisitor) {
		postageVisitor.visit(this);
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public double getWeight() {
		return weight;
	}	
}

class DVD implements ItemMember {
	private String name;
	private double price;
	private double weight;
	
	
	public DVD(String name, double price, double weight) {
		super();
		this.name = name;
		this.price = price;
		this.weight = weight;
	}

	@Override
	public void apply(PostageVisitor postageVisitor) {
		postageVisitor.visit(this);
	}
	
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public double getWeight() {
		return weight;
	}
}