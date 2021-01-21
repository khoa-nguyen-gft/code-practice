package refactoring.conditional04_problem;

public class Client {

	public static void main(String[] args) {
		int[] badWeight = new int[] {25, 55}; 
		
		int numberOfBags = badWeight.length;
		
		int bagFees = 0;
		
		for (int i = 0; i < numberOfBags; i++) {
			if (i <=1) {
				if(badWeight[i] < 50) {
					if (i == 0) {
						bagFees += 25;
					} else {
						bagFees += 35;
					}
				} else if (badWeight[i] < 70) {
					bagFees += 200;
				}
			} else if (i > 1 && badWeight[i] < 70) {
				bagFees += 150;
			} else {
				bagFees += 200;
			}
		}
		
		
		System.out.println("bagFees: " + bagFees);
	}

}
