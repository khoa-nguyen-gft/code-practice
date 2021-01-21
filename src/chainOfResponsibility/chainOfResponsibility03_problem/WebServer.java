package chainOfResponsibility.chainOfResponsibility03_problem;

public class WebServer {
	public void handle(HttpRequest request) {
		//Authentication
		Authenticator authenticator = new Authenticator();
		authenticator.authenticate(request);
		
		//logging
		Logger logger = new Logger();
		logger.log(request);
		
		//Compression
		Compressor compressor = new Compressor();
		compressor.compressor(request);
		
	}
}
