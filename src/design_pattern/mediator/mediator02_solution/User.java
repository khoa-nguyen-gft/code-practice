package design_pattern.mediator.mediator02_solution;

public abstract class User {

	protected FacebookGroupMediator mediator;
	protected String name;
		
	
	public User(FacebookGroupMediator mediator, String name) {
		this.mediator = mediator;
		this.name = name;
	}
	
	public abstract void receive(String msg);
	public abstract void send(String msg);
}


class UserImpl extends User {

	public UserImpl(FacebookGroupMediator mediator, String name) {
		super(mediator, name);
	}

	@Override
	public void receive(String msg) {
		System.out.println(this.name + " receive message: " + msg);
	}

	@Override
	public void send(String msg) {
		System.out.println(this.name + " send message: " + msg);
		mediator.sendMessage(msg, this);
	}
	
}