package design_pattern.chainOfResponsibility.chainOfResponsibility03a_solution;


public interface Compressor {
	public void compressor(HttpRequest request);
}

class CompressorImpl implements Compressor {
	public void compressor(HttpRequest request) {
		System.out.println("Compressor: " + request.getUsername());
	}
}
