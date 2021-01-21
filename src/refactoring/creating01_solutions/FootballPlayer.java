package refactoring.creating01_solutions;

public class FootballPlayer {
	private double passedRating; // Specific to QBs
	private int rushingYards; // Specific to RBs & QBs
	private int receivingYards; // Specific to RBs & WRs
	private int totalTackles; // Specific to DEF
	private int interception; // Specific to DEF
	private int fieldGoals; // Specific to Kickers
	private double avgPunt; // Specific to Punters
	private double avgKickoffReturn; // Specific to special Teams
	private double avgPuntReturn; // Specific to special Teams

	private FootballPlayer(double passedRating, int rushingYards, int receivingYards, int totalTackles,
			int interception, int fieldGoals, double avgPunt, double avgKickoffReturn, double avgPuntReturn) {
		super();
		this.passedRating = passedRating;
		this.rushingYards = rushingYards;
		this.receivingYards = receivingYards;
		this.totalTackles = totalTackles;
		this.interception = interception;
		this.fieldGoals = fieldGoals;
		this.avgPunt = avgPunt;
		this.avgKickoffReturn = avgKickoffReturn;
		this.avgPuntReturn = avgPuntReturn;
	}


	public static FootballPlayer createQBs(double passedRating, int rushingYards) {
		return new FootballPlayer(passedRating, rushingYards, 0, 0, 0, 0, 0.0, 0.0, 0.0);
	}

	public static void main(String[] args) {
		FootballPlayer player = createQBs(1.1, 1);
		System.out.println(player.toString());
	}

}
