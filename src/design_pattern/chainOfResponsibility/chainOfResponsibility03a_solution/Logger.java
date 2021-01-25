package design_pattern.chainOfResponsibility.chainOfResponsibility03a_solution;



public interface Logger {
	public void log(HttpRequest request);
}

class LoggerImpl implements Logger {
	public void log(HttpRequest request) {
		System.out.println("Logger: " + request.getUsername());
	}
}
