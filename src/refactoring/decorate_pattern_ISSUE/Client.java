package refactoring.decorate_pattern_ISSUE;

public class Client {

}

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
