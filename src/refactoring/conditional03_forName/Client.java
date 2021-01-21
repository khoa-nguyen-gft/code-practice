package refactoring.conditional03_forName;

import java.lang.reflect.Method;

public class Client {
	public static void main(String[] args) throws Exception {
		MedalFactory factory = new MedalFactory();
		
		Athlete goldWinner = factory.getMedal(GoldWinner.class.getName(), "Dave");
		Athlete sliverWinner = factory.getMedal(SliverWinner.class.getName(), "Mac");
		Athlete bronzeWinner = factory.getMedal(BronzeWinner.class.getName(), "David");
		Athlete goldWinnerNew = factory.getMedal(GoldWinner.class.getName(), "Ray");
		
		System.out.println("GoldWinner: " + goldWinner.getAthleteName());
		System.out.println("SliverWinner: " + sliverWinner.getAthleteName());
		System.out.println("BronzeWinner: " + bronzeWinner.getAthleteName());
		System.out.println("GoldWinner: " + goldWinnerNew.getAthleteName());

	}
}


class MedalFactory {
	public Athlete getMedal(String medalName, String athleteName) throws Exception {
		Class[] classParam = new Class[] {String.class};
		Class<?> class1 = Class.forName(medalName);
		Method method = class1.getMethod("getInstance", classParam);
		Object[] objectParam = new Object[] {new String(athleteName)};
		return (Athlete) method.invoke(null, objectParam);
		
	}
//	public Athlete getMedal(String medalName, String athleteName) throws Exception {
//		try {
//			return (Athlete) Class.forName(medalName).getDeclaredConstructor(String.class).newInstance(athleteName);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
}

class Athlete {
	private String athleteName = "";

	public String getAthleteName() {
		return athleteName;
	}

	public void setAthleteName(String athleteName) {
		this.athleteName = athleteName;
	}
	
	public static Athlete getInstance() {
		return null;
	}
}


class GoldWinner extends Athlete {
	public static GoldWinner instance = null;
	
	private GoldWinner(String athleteName) {
		setAthleteName(athleteName);
	}
	
	public static GoldWinner getInstance(String athleteName) {
		if (instance == null) {
			instance = new GoldWinner(athleteName);
		}
		
		return instance;
	}
}

class SliverWinner extends Athlete {
	public static SliverWinner instance = null;
	
	private SliverWinner(String athleteName) {
		setAthleteName(athleteName);
	}
	
	public static SliverWinner getInstance(String athleteName) {
		if (instance == null) {
			instance = new SliverWinner(athleteName);
		}
		
		return instance;
	}
}


class BronzeWinner extends Athlete {
	public static BronzeWinner instance = null;
	
	private BronzeWinner(String athleteName) {
		setAthleteName(athleteName);
	}
	
	public static BronzeWinner getInstance(String athleteName) {
		if (instance == null) {
			instance = new BronzeWinner(athleteName);
		}
		
		return instance;
	}
}