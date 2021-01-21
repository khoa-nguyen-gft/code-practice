package visitor.visitor02_solution;

public interface ShoppingCartVisitor {

	public int visit(Book book);
	public int visit(Fruit fruit);

}


/**
 * Calculator COST for BOOK and FRUIT 
 * @author knguyen97
 *
 */
class ShoppingCartCostVisitorImpl implements ShoppingCartVisitor {

	/**
	 * Apply 5$ discount if book price is greater than 50$ 
	 */
	@Override
	public int visit(Book book) {
		int cost = book.getPrice() >= 50 ?
					book.getPrice() -5 :
					book.getPrice();
					
		System.out.println("Book ISBM::" + book.getIsbnNumber() 
			+ " cost:: " + cost);
		return cost;
	}

	@Override
	public int visit(Fruit fruit) {
		int cost = fruit.getPricePerKg() * fruit.getWeight();
		System.out.println(fruit.getName() + " cost is " + cost);
		return cost;
	}


	
}
