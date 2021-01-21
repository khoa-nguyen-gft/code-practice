package chainOfResponsibility.chainOfResponsibility02_solution;

public class Client {

	public static void main(String[] args) {
		System.out.println("******Chain of Responsibility Pattern Demo ****");
		
		
		//make the chain first: Fax -> Email
		RecevierInterface fax = new FaxErrorHandler();
		RecevierInterface email = new EmailErrorHandler();
		
		fax.setNextReceiver(email);
		
		// starting point: raiser will raise issues and set the first handler
		IssueRaise raise = new IssueRaise(fax);
		
		Message m1 = new Message("Fax is reaching late to destination", MessagePriority.Normal);
		Message m2 = new Message("Email is not going", MessagePriority.High);
		Message m3 = new Message("In Email, BCC field is disabled occasionally", MessagePriority.Normal);
		Message m4 = new Message("Fax is not reaching destination", MessagePriority.High);

		
		raise.RaiseMessage(m1);
		raise.RaiseMessage(m2);
		raise.RaiseMessage(m3);
		raise.RaiseMessage(m4);

	}

}
