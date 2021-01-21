package chainOfResponsibility.chainOfResponsibility02_solution;

public class IssueRaise {
	public RecevierInterface setFirstReceiver;

	public IssueRaise(RecevierInterface setFirstReceiver) {
		this.setFirstReceiver = setFirstReceiver;
	}

	public void RaiseMessage(Message message) {
		if (setFirstReceiver != null) {
			setFirstReceiver.processMessage(message);
		}
	}


}
