package chainOfResponsibility.chainOfResponsibility03_problem;

public class Compressor {
	public void compressor(HttpRequest request) {
		System.out.println("Compressor: " + request.getUsername());
	}
}
