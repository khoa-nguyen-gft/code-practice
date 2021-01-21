package chainOfResponsibility.chainOfResponsibility03_problem;

public class Logger {
	public void log(HttpRequest request) {
		System.out.println("Logger: " + request.getUsername());
	}
}
