package refactoring.replaceTreePrimitive_with_builder_pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {

	public static void main(String[] args) {
		ItemBuilder products = new ItemBuilder("Products");
		
		products.addChild("Produce");
			products.addChild("Orange");		
			products.addItemInformation("Price", "$1.00");
			products.addItemInformation("Stock", "$100");
	
			products.addSibling("Apple");
			products.addItemInformation("Price", "$1.00");
			products.addItemInformation("Stock", "$100");
				products.addChild("Red Apple");
				products.addItemInformation("Price", "$1.00");
				products.addItemInformation("Stock", "$100");
			
			products.EditThisItems("Apple");
			products.addSibling("Grape");
			products.addItemInformation("Price", "$1.00");
			products.addItemInformation("Stock", "$100");
		
		products.EditThisItems("Produce");
			products.addChild("Cereal");		
				products.addChild("Special K");		


		products.displayAllItems();
		
	}

}


class ItemBuilder {
	private List<Item> items = new ArrayList<Item>();
	private Item root;
	private Item current;
	private Item parent;
	
	
	public ItemBuilder(String name) {
		root = new Item(name);
		parent = root;
		current = root;
		
		addItemtoArrayList(root);
		addItemInformation("Parent", parent.getItemName());
			
	}

	public void addItemInformation(String name, String value) {
		System.out.println("addItemInformation" + current.getItemName());
		current.addItemInformation(name, value);
	}
	
	public void addChild(String name) {
		Item childNode = new Item(name);
		
		addItemtoArrayList(childNode);
		
		parent = current;
		current.addChildNode(childNode);
		current = childNode;
		
		childNode.addItemInformation("Parent", parent.getItemName());
		
	}
		
	
	public void addSibling(String name) {
		Item siblingNode = new Item(name);
		
		addItemtoArrayList(siblingNode);
		parent.addChildNode(siblingNode);
		current = siblingNode;
		
		siblingNode.addItemInformation("Parent", parent.getItemName());
	
	}
	
	public void addItemtoArrayList(Item item) {
		items.add(item);
	}
	
	public void displayAllItems() {
		for (Item item : items) {
			System.out.println("*********************");
			System.out.println(item.getItemName() + ": ");
			System.out.println("*********************");
			System.out.println("Product Information: ");
			System.out.println(item.displayProductInfo());

		}
	}
	
	public void EditThisItems(String name){
		
		for (Item item : items) {
			if(item.getItemName().equals(name)) {
				current = item;
			}
		}
		
		setItemsParent(current.getItemInformation("Parent"));
	}
	
	public void setItemsParent(String parentName) {
		
		for (Item item : items) {
			if(item.getItemName().equals(parentName)) {
				parent = item;
			}
		}
	}
}

class Item{
	private String itemName;
	private Map<String,String> itemInfoHashMap= new HashMap<String,String>();
	private  List<Item> children = new ArrayList<Item>();
	
	
	public Item(String name) {
		this.setItemName(name);
		itemInfoHashMap = new HashMap<String, String>(20);		
	}
	

	public String getItemName() {
		return itemName;
	}

	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public void addChildNode(Item item) {
		children.add(item);
	}
	
	
	public void addItemInformation(String infoName, String info) {
		itemInfoHashMap.put(infoName, info);
	}
	
	
	public String getItemInformation(String infoName) {
		return itemInfoHashMap.get(infoName);
	}
	
	
	public String ToString() {
		StringBuffer itemInformation = new StringBuffer(itemName);
		itemInformation.append("\n");
		
		if(!itemInfoHashMap.isEmpty()) {
			itemInformation.append(displayProductInfo());
		}
		
		for (Item item : children) {
			itemInformation.append(item.toString());
		}
		
		return itemInformation.toString();
		
	}

	
	public String displayProductInfo() {
		StringBuffer productInfo = new StringBuffer();
		
		for(Map.Entry<String, String> entry: itemInfoHashMap.entrySet()) {
			productInfo.append(" ");
			productInfo.append(entry.getKey());
			productInfo.append(" : ");
			productInfo.append(entry.getValue());
			productInfo.append("; ");

		}
				
		return productInfo.toString();
	}
}

