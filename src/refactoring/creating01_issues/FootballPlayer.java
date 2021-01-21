package refactoring.creating01_issues;

public class FootballPlayer {
	private double passedRating; 		// Specific to QBs
	private int rushingYards;    		// Specific to RBs & QBs
	private int receivingYards;  		// Specific to RBs & WRs
	private int totalTackles;   	    // Specific to DEF
	private int interception;    		// Specific to DEF
	private int fieldGoals;      		// Specific to Kickers
	private double avgPunt;      		// Specific to Punters
	private double avgKickoffReturn;	// Specific to special Teams
	private double avgPuntReturn;		// Specific to special Teams
	
	
	
	public FootballPlayer(double passedRating, int rushingYards) {
		super();
		this.passedRating = passedRating;
		this.rushingYards = rushingYards;
	}


	public FootballPlayer(int rushingYards) {
		super();
		this.rushingYards = rushingYards;
	}

	//TODO: ERROR 2 constructor methods have same type int parameters
//	public FootballPlayer(int receivingYards) {
//		super();
//		this.receivingYards = receivingYards;
//	}
	
}
