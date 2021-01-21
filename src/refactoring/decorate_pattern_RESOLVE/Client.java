package refactoring.decorate_pattern_RESOLVE;

public class Client {

}

//****************************************
// Solution
//****************************************
interface HairCut{
	
	public String getDescription();
	
	public double getCost();
}


abstract class HairCutDecorator implements HairCut {
	
	protected HairCut hairCut;

	public HairCutDecorator(HairCut hairCut) {
		this.hairCut = hairCut;
	}
	
	public String getDescription() {
		return hairCut.getDescription();
	}
	
	public double getCost() {
		return hairCut.getCost();
	}
	
}

class RegularHairCut implements HairCut {

	@Override
	public String getDescription() {
		return "Trim the Hair";
	}

	@Override
	public double getCost() {
		return 10.0;
	}
	
}

class PermHairCut extends HairCutDecorator {

	public PermHairCut(HairCut hairCut) {
		super(hairCut);
	}

	@Override
	public String getDescription() {
		return super.getDescription() +  "\n Add hemicals and Put Hair in Rollers";
	}

	@Override
	public double getCost() {
		return super.getCost() + 75.0;
	}
	
	
	
}

//****************************************
//BAD code
//****************************************

class CalculateHairCut{
	
	enum HairCutOption {BASIC_CUT, PERM, HAIR_FROSTING};
	
	HairCutOption option;

	public CalculateHairCut(HairCutOption option) {
		this.option = option;
	}
	
	public String getDescription() {
		if (option == HairCutOption.PERM) {
			
			return "\n Add hemicals and Put Hair in Rollers";
			
		} else if (option == HairCutOption.HAIR_FROSTING) {
			
			return "\n Add hemicals and Put Hair in Foil";
		}
		
		return "Trim the Hair";
	}
	
	public double getCost() {
		if (option == HairCutOption.PERM) {
			
			return 75.00;
			
		} else if (option == HairCutOption.HAIR_FROSTING) {
			
			return 100.00;
		}
		
		return 10.00;
	}
	
}
