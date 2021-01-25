package design_pattern.command_pattern.solution00;

public class Main {

	public static void main(String[] args) {
		Button button = new Button(new AddCustomerCommand(new CustomerServiceImpl()));
		
		button.click();
	}

}
