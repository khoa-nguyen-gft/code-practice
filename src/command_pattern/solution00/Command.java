package command_pattern.solution00;

public interface Command {
	void execute();
}


class AddCustomerCommand implements Command {

	private CustomerServiceImpl service ;
	
	
	public AddCustomerCommand(CustomerServiceImpl service) {
		this.service = service;
	}


	@Override
	public void execute() {
		service.addCustomer();
	}

}
