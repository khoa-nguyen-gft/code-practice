package refactoring.adapter_pattern_RESOLVE;

public class Client {
	public static void main(String[] args) {
		Enemy level1ship = new GalaxEnemy();
		
		level1ship.moveShip();
		level1ship.makeShipAttack();
		
		System.out.println("===========================");
		Enemy primeTime = new EnemyAdapter(new GalaxPrime());
		
		primeTime.moveShip();
		primeTime.makeShipAttack();
		
	}
}


interface Enemy {
	public void moveShip();
	public void makeShipAttack();
}


class GalaxEnemy implements Enemy {
	
	private int spacesMovedPerTurn = 5;
	private int attackPower = 2;
	
	

	@Override
	public void moveShip() {
		System.out.println("Galax moves " + spacesMovedPerTurn + " spaces");
	}

	@Override
	public void makeShipAttack() {
		System.out.println("Galax does " + attackPower + " damage");

	}
	
}



class GalaxPrime {
	protected String name = "Galax Prime";
	private int spacesMovedPerTurn = 15;
	private int attackPower = 4;

	
	public void turnOnForceField() {
		System.out.println(name + " turn on force field");
	}
	
	public void warpToSpace() {
		System.out.println(name + " warps " + spacesMovedPerTurn + " spaces");
	}
	
	
	public void chargePhasers() {
		System.out.println(name + " charges phasers");
	}
	
	public void firePhasers() {
		System.out.println(name + " fires phasers for " + attackPower);
	}
}


class EnemyAdapter implements Enemy {

	private GalaxPrime galaxPrime;
	
	@Override
	public void moveShip() {
		galaxPrime.turnOnForceField();
		galaxPrime.warpToSpace();
	}

	@Override
	public void makeShipAttack() {
		galaxPrime.chargePhasers();
		galaxPrime.firePhasers();
		
	}

	public EnemyAdapter(GalaxPrime galaxPrime) {
		super();
		this.galaxPrime = galaxPrime;
	}
	
	
	
}