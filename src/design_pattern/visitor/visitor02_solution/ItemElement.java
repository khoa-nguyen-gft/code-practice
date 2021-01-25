package design_pattern.visitor.visitor02_solution;

public interface ItemElement {
	public int accept(ShoppingCartVisitor visitor);
}


class Book implements ItemElement{

	private int price;
	private String isbnNumber;
		

	@Override
	public int accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}
	
	public Book(int price, String isbnNumber) {
		this.price = price;
		this.isbnNumber = isbnNumber;
	}

	public int getPrice() {
		return price;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}

}


class Fruit implements ItemElement {

	private int pricePerKg;
	private int weight;
	private String name;
	
	
	public Fruit(int pricePerKg, int weight, String name) {
		super();
		this.pricePerKg = pricePerKg;
		this.weight = weight;
		this.name = name;
	}


	@Override
	public int accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}


	public int getPricePerKg() {
		return pricePerKg;
	}


	public int getWeight() {
		return weight;
	}


	public String getName() {
		return name;
	}
}