package refactoring.conditional04_resolve01;

public class Client {

	public static void main(String[] args) {
		int[] badWeight = new int[] {25, 55}; 
		
		int numberOfBags = badWeight.length;
		
		int bagFees = 0;
		
		for (int i = 0; i < numberOfBags; i++) {
			if(badWeight[i] < 50) {					
				bagFees += bagUnder50lps(i);
			} 

			if (badWeight[i] < 70 && badWeight[i] >= 50) {
				bagFees += bag50To70lps(i);
			}	
			
			if (badWeight[i] >= 70) {
				bagFees += bagOver70lps(i);
			}	
				
		}
		
		
		System.out.println("bagFees: " + bagFees);
	}

	public static int bagUnder50lps(int bag) {
			return bag < 1 ? 25: 35;
	}
	
	public static int bag50To70lps(int bag) {
		return bag < 2? 100: 150;
	}
	
	public static int bagOver70lps(int bag) {
		return 200;
	}
}


