package design_pattern.chainOfResponsibility.chainOfResponsibility03a_solution;



public interface Authenticator {
	public boolean authenticate(HttpRequest request);
}

class AuthenticatorImpl implements Authenticator {
	public boolean authenticate (HttpRequest request) {
		
		boolean isValid = request.getUsername().equals("admin") &&
				request.getPassword().equals("1234");
		
		return isValid;
	}
}
