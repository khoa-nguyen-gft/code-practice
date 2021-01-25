package design_pattern.visitor.visitor03_solution;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<ItemMember> items = new ArrayList<ItemMember>();
		
		items.add(new Book("Book", 8.52, 1.05));
		items.add(new CD("CD", 18.52, 3.05));
		items.add(new DVD("DVD", 6.52, 4.05));
		
		USPostageVisitor usVisitor = new USPostageVisitor();
		SouthAmericaPostageVisitor southVisitor = new SouthAmericaPostageVisitor();

		items.stream().forEach(item ->  item.apply(usVisitor));
		System.out.println("US Postage Visitor: " + usVisitor.getTotalPostagePrice());
		
		
		items.stream().forEach(item ->  item.apply(southVisitor));
		System.out.println("South America Postage Visitor: " + southVisitor.getTotalPostagePrice());
					
	}

}
