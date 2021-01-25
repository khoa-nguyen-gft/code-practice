package design_pattern.chainOfResponsibility.chainOfResponsibility03b_solution;

public class WebServer {
	
	private Handler handler;
	
	
	public WebServer(Handler handler) {
		this.handler = handler;
	}


	public void handle(HttpRequest request) {
		handler.handle(request);
	}
	
	
}
