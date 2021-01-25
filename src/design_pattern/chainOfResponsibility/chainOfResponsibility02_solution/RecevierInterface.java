package design_pattern.chainOfResponsibility.chainOfResponsibility02_solution;

interface RecevierInterface {
	public boolean processMessage(Message message);
	public void setNextReceiver(RecevierInterface nextChain);

}


class FaxErrorHandler implements RecevierInterface {
	private RecevierInterface nextChain;


	public void setNextReceiver(RecevierInterface nextChain) {
		this.nextChain = nextChain;
	}
	
	@Override
	public boolean processMessage(Message message) {
		if (message.getText().contains("Fax")){
			System.out.println("FaxErrorHandler: processed " + message.getMessagePriority()
			+ " priority issue: " + message.getText());
			return true;
		} else {
			if (nextChain != null) {
				nextChain.processMessage(message);
			}
		}
		return false;
	}
	
}



class EmailErrorHandler implements RecevierInterface {
	private RecevierInterface nextChain;

	
	public void setNextReceiver(RecevierInterface nextChain) {
		this.nextChain = nextChain;
	}


	public RecevierInterface getiReceiver() {
		return nextChain;
	}

	@Override
	public boolean processMessage(Message message) {
		if (message.getText().contains("Email")){
			System.out.println("EmailErrorHandler: processed " + message.getMessagePriority()
			+ " priority issue: " + message.getText());
			return true;
		} else {
			if (nextChain != null) {
				nextChain.processMessage(message);
			}
		}
		return false;
	}
	
}