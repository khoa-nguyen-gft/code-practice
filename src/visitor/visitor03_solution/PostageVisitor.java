package visitor.visitor03_solution;

public interface PostageVisitor {
	
	public void visit(Book book);
	public void visit(CD cd);
	public void visit(DVD dvd);

}

class USPostageVisitor implements PostageVisitor {

	private double totalPostagePrice;

	@Override
	public void visit(Book book) {
		totalPostagePrice += book.getWeight() * 2;
	}

	@Override
	public void visit(CD cd) {
		totalPostagePrice += cd.getWeight() * 2.5;		
	}

	@Override
	public void visit(DVD dvd) {
		totalPostagePrice += dvd.getWeight() * 3;		

	}

	public double getTotalPostagePrice() {
		return totalPostagePrice;
	}
	
	
	
}

class SouthAmericaPostageVisitor implements PostageVisitor {

	private double totalPostagePrice;
	
	@Override
	public void visit(Book book) {
		totalPostagePrice += book.getWeight() * 2 * 2;
	}

	@Override
	public void visit(CD cd) {
		totalPostagePrice += cd.getWeight() * 2.5 * 2;		
	}

	@Override
	public void visit(DVD dvd) {
		totalPostagePrice += dvd.getWeight() * 3 * 2;	

	}
	
	public double getTotalPostagePrice() {
		return totalPostagePrice;
	}
	
}