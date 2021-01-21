package refactoring.revisiting_builder_design_pattern;

public class Client {

	public static void main(String[] args) {
		SandwichArtist artist = new SandwichArtist(new BLTBuilder());
		
		artist.takeSandWichOrder();
		
		Sandwich sanwich = artist.getSanwich();
		
		System.out.println(sanwich);
	}

}


class SandwichArtist {
	private SandwichBuilder sandwichBuilder;

	public SandwichArtist(SandwichBuilder sandwichBuilder) {
		this.sandwichBuilder = sandwichBuilder;
	}
	
	public Sandwich getSanwich() {
		return sandwichBuilder.getSandwich();
	}
	public void takeSandWichOrder() {
		sandwichBuilder.makeSandwich();
		sandwichBuilder.buildBread();
		sandwichBuilder.buildVegetable();
		sandwichBuilder.buildMeat();
		sandwichBuilder.buildCheese();
		sandwichBuilder.buildCondiments();
		
	}
}

class BLTBuilder extends SandwichBuilder {

	@Override
	public void buildBread() {
		this.sandwich.setBread("While Bread");
	}

	@Override
	public void buildVegetable() {
		this.sandwich.setVegetable("Lettuce Tomato");
		
	}

	@Override
	public void buildMeat() {
		this.sandwich.setMeat("while meat");
		
	}

	@Override
	public void buildCheese() {
		this.sandwich.setCheese("cheese");
		
	}

	@Override
	public void buildCondiments() {
		this.sandwich.setCondiment("Mayonnaise");
	}
	
}

abstract class SandwichBuilder {
	protected Sandwich sandwich;

	public Sandwich getSandwich() {
		return sandwich;
	}
	
	public void makeSandwich() {
		sandwich = new Sandwich();
	}
	
	public abstract void buildBread();
	public abstract void buildVegetable();
	public abstract void buildMeat();
	public abstract void buildCheese();
	public abstract void buildCondiments();
}

class Sandwich {
	private String bread = "";
	private String vegetable = "";
	private String meat = "";
	private String cheese = "";
	private String condiment = "";
	
	public String getBread() {
		return bread;
	}
	public void setBread(String bread) {
		this.bread = bread;
	}
	public String getVegetable() {
		return vegetable;
	}
	public void setVegetable(String vegetable) {
		this.vegetable = vegetable;
	}
	public String getMeat() {
		return meat;
	}
	public void setMeat(String meat) {
		this.meat = meat;
	}
	public String getCheese() {
		return cheese;
	}
	public void setCheese(String cheese) {
		this.cheese = cheese;
	}
	public String getCondiment() {
		return condiment;
	}
	public void setCondiment(String condiment) {
		this.condiment = condiment;
	}
	@Override
	public String toString() {
		return "Sandwich [bread=" + bread + ", vegetable=" + vegetable + ", meat=" + meat + ", cheese=" + cheese
				+ ", condiment=" + condiment + "]";
	}
	
	
}