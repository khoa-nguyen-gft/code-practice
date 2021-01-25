package design_pattern.chainOfResponsibility.chainOfResponsibility03b_solution;

abstract class Handler {
	private Handler next;

	public Handler(Handler handler) {
		this.next = handler;
	}

	public void handle(HttpRequest request) {

		if (doHandle(request))
			return;

		if (next != null) {
			next.handle(request);
		}
	}

	protected abstract boolean doHandle(HttpRequest request);

//	public Handler getHandler() {
//		return next;
//	}


}

class Authenticator extends Handler {

	public Authenticator(Handler handler) {
		super(handler);
	}

	@Override
	protected boolean doHandle(HttpRequest request) {
		System.out.println("Authenticator: handle request: " + request.getUsername());

		boolean isValid = request.getUsername().equals("admin") && request.getPassword().equals("1234");

// Move the code into ABSTRACT class Handler
//		if (this.getHandler() != null) {
//			this.getHandler().doHandle(request);
//		}

		return !isValid;
	}

}

class Logger extends Handler {

	public Logger(Handler handler) {
		super(handler);
	}

	@Override
	protected boolean doHandle(HttpRequest request) {
		System.out.println("Logger: handle request: " + request.getUsername());

//  Move the code into ABSTRACT class Handler
//		if (this.getHandler() != null) {
//			this.getHandler().doHandle(request);
//		}		

		return false;
	}

}

class Compressor extends Handler {

	public Compressor(Handler handler) {
		super(handler);
	}

	@Override
	protected boolean doHandle(HttpRequest request) {
		System.out.println("Compressor: handle request: " + request.getUsername());

		return false;
//  Move the code into ABSTRACT class Handler

//		if (this.getHandler() != null) {
//			this.getHandler().doHandle(request);
//		}		
	}

}