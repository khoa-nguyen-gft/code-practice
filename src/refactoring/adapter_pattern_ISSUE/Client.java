package refactoring.adapter_pattern_ISSUE;

public class Client {
	public static void main(String[] args) {
		EnemyShip level1ship = new EnemyShip(6);
		
		level1ship.moveShip();
		level1ship.makeShipAttack();
		
		GalaxianPrime primeTime = new GalaxianPrime(15);
		
		primeTime.moveShip();
		primeTime.makeShipAttack();
		
	}
}




class EnemyShip {
	protected String name;
	protected int spacesMovedPerTurn;
	private int attackPower;
	
	
	public EnemyShip(int currentLevel) {
		
		if(currentLevel <= 5) {
			
			name = "Galax";
			this.attackPower = 5;
			this.spacesMovedPerTurn = 2;
			
		} else if (currentLevel > 5 || currentLevel < 10) {
			
			name = "Galaxian";
			this.attackPower = 10;
			this.spacesMovedPerTurn = 3;
			
		} else if (currentLevel > 10) {
			
			name = "Galaxian Prime";
			this.attackPower = 15;
			this.spacesMovedPerTurn = 4;
			
		}
	}
	
	public void moveShip() {
		System.out.println(name + " moves " + spacesMovedPerTurn + " spaces");
	}
	
	public void makeShipAttack() {
		System.out.println(name + " does " + attackPower + " damage");
	}
	
	
}



class GalaxianPrime extends EnemyShip {

	public GalaxianPrime(int currentLevel) {
		super(currentLevel);
	}

	@Override
	public void moveShip() {
		System.out.println(name + " turns on force field and moves " + spacesMovedPerTurn + "space");
	}
	
	
	
}