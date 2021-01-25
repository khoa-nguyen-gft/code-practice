package design_pattern.chainOfResponsibility.chainOfResponsibility03_problem;

public class Authenticator {
	public boolean authenticate (HttpRequest request) {
		
		boolean isValid = request.getUsername().equals("admin") &&
				request.getPassword().equals("1234");
		
		return isValid;
	}
}
