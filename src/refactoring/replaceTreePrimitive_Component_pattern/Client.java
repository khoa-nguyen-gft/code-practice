package refactoring.replaceTreePrimitive_Component_pattern;

import java.util.ArrayList;
import java.util.List;



public class Client {
	public static void main(String[] args) {
		ProductComponent groceryProduct = new ProductGroup("Grocery Product");

		ProductComponent produce = new ProductGroup("   Produce");
		ProductComponent cereal = new ProductGroup("  Cereal");
		ProductComponent meat = new ProductGroup("  Meat");
		
		groceryProduct.add(produce);
		groceryProduct.add(cereal);
		groceryProduct.add(meat);
			
		produce.add(new ProductItem("Apple"));
		produce.add(new ProductItem("Orange"));
		produce.add(new ProductItem("Pear"));
		
		cereal.add(new ProductItem("Special K"));
		cereal.add(new ProductItem("Cheerios"));
		cereal.add(new ProductItem("Raisin Bran"));
		
		groceryProduct.displayProductInfo();
	}
}




abstract class ProductComponent {
	
	
	// group product
	void add(ProductComponent component) {}
	void remove(ProductComponent component) {}
	ProductComponent getProductComponent(int index) {return null;}
	
	
	//product item 
	String getProductName() {return null;}

	// group product and item
	abstract void displayProductInfo();
}


class ProductGroup extends ProductComponent {

	private List<ProductComponent> productList = new ArrayList<ProductComponent>();
	private String productGroupName;
	
	public ProductGroup(String string) {
		productGroupName = string;
	}

	@Override
	public void add(ProductComponent e) {
		productList.add(e);
	}

	@Override
	void remove(ProductComponent component) {
		productList.remove(component);
	}

	@Override
	ProductComponent getProductComponent(int index) {
		return productList.get(index);
	}

	
	@Override
	String getProductName() {
		return productGroupName;
	}

	@Override
	void displayProductInfo() {
		System.out.println(getProductName());

		for (ProductComponent product : productList) {
			product.displayProductInfo();
		}
	}
	
}



class ProductItem extends ProductComponent{

	private String productName;
	
	
	public ProductItem(String productName) {
		this.productName = productName;
	}


	@Override
	String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	@Override
	void displayProductInfo() {
		System.out.println("    + " + getProductName());
	}
	
}