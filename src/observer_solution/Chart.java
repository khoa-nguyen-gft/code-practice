package observer_solution;

public class Chart implements Observer {

	@Override
	public void update() {
		System.out.println("Update Chart with value: ");
	}

}
