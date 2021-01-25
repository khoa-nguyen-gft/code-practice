package design_pattern.chainOfResponsibility.chainOfResponsibility03a_solution;

public class WebServer {
	
	private Authenticator authenticator;
	private Logger logger;
	private Compressor compressor;
	
		
	
	public WebServer(Authenticator authenticator, Logger logger, Compressor compressor) {
		this.authenticator = authenticator;
		this.logger = logger;
		this.compressor = compressor;
	}




	public void handle(HttpRequest request) {
		//Authentication
		authenticator.authenticate(request);
		
		//logging
		logger.log(request);
		
		//Compression
		compressor.compressor(request);
		
	}
}
