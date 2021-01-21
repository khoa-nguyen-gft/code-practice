package refactoring.creating02_issues;

public class FootballPlayer2 {
	private String playerName = "";
	private String college = "";
	private double fortyYardDash = 0.0;
	private int repsBenchPress = 0;
	private double sixtyYardDash = 0.0;
	
	public FootballPlayer2(String playerName, String college, double fortyYardDash, double sixtyYardDash) {
		super();
		this.playerName = playerName;
		this.college = college;
		this.fortyYardDash = fortyYardDash;
		this.sixtyYardDash = sixtyYardDash;
	}

	public FootballPlayer2(String playerName, String college, double fortyYardDash, int repsBenchPress) {
		super();
		this.playerName = playerName;
		this.college = college;
		this.fortyYardDash = fortyYardDash;
		this.repsBenchPress = repsBenchPress;
	}

	public FootballPlayer2(String playerName, String college, double fortyYardDash, int repsBenchPress,
			double sixtyYardDash) {
		super();
		this.playerName = playerName;
		this.college = college;
		this.fortyYardDash = fortyYardDash;
		this.repsBenchPress = repsBenchPress;
		this.sixtyYardDash = sixtyYardDash;
	}
	
	
	
	
	

}
