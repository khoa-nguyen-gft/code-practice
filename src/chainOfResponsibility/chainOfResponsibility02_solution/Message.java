package chainOfResponsibility.chainOfResponsibility02_solution;


enum MessagePriority {
	Normal, High;
	
}


class Message {
	private String Text;
	private MessagePriority messagePriority;
	
	
	public Message(String text, MessagePriority messagePriority) {
		Text = text;
		this.messagePriority = messagePriority;
	}

	
	public String getText() {
		return Text;
	}

	
	public void setText(String text) {
		Text = text;
	}


	public MessagePriority getMessagePriority() {
		return messagePriority;
	}


	public void setMessagePriority(MessagePriority messagePriority) {
		this.messagePriority = messagePriority;
	}
	
	
}
