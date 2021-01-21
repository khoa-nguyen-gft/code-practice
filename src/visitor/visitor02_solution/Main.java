package visitor.visitor02_solution;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<ItemElement> items = new ArrayList<ItemElement>();
		items.add(new Book(20, "1234"));
		items.add(new Book(100, "5678"));
		items.add(new Fruit(10, 2, "Apple"));
		items.add(new Fruit(5, 5, "Banana"));

		
		int totalCost = calculatorCost(items);
		
		System.out.println("Total cost:" + totalCost);

	}

	private static int calculatorCost(List<ItemElement> items) {
		return items.stream().map(item -> item.accept(new ShoppingCartCostVisitorImpl())).mapToInt(Integer::valueOf).sum();
	}

}
