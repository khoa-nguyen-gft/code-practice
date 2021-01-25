package design_pattern.mediator.mediator02_solution;

public class Client {
	public static void main(String[] args) {
		FacebookGroupMediator facebookGroupMediator = new FacebookGroupMediatorImpl();
		User dave = new UserImpl(facebookGroupMediator, "Dave");
		User raw = new UserImpl(facebookGroupMediator, "Ram");
		User raj = new UserImpl(facebookGroupMediator, "Raj");
		User aun = new UserImpl(facebookGroupMediator, "Aun");
		User rahui = new UserImpl(facebookGroupMediator, "Rahui");
		User stev = new UserImpl(facebookGroupMediator, "Stev");

		facebookGroupMediator.registerUser(dave);
		facebookGroupMediator.registerUser(raw);
		facebookGroupMediator.registerUser(raj);
		facebookGroupMediator.registerUser(aun);
		facebookGroupMediator.registerUser(rahui);
		facebookGroupMediator.registerUser(stev);

		dave.send("ram2ee blogspot.com this blog is very good blog");
	}
}
