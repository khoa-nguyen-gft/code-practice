package mediator.mediator01_solution;

public class UIControl {
	
	protected DialogBox owner;

	public UIControl(DialogBox dialogBox) {
		super();
		this.owner = dialogBox;
	}
	
}

class Button extends  UIControl {

	private boolean isEnable;
	
	public Button(DialogBox dialogBox) {
		super(dialogBox);
	}


	public boolean isEnable() {
		return isEnable;
	}

	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
		owner.change(this);
	}
}



class ListBox extends UIControl {
	
	public String selection;

	public ListBox(DialogBox dialogBox) {
		super(dialogBox);
	}

	public String getSelection() {
		return selection;
	}

	public void setSelection(String selection) {
		this.selection = selection;
		owner.change(this);
	}
}

class TextBox extends UIControl {

	public String context;

	public TextBox(DialogBox dialogBox) {
		super(dialogBox);
	}
	
	
	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
		owner.change(this);
	}
}
