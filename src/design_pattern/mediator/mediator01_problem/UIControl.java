package design_pattern.mediator.mediator01_problem;

public interface UIControl {

}

class Button implements UIControl {
	private boolean isEnable;

	public boolean isEnable() {
		return isEnable;
	}

	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}
}

class TextBox implements UIControl {
	public String context;

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
}


class ListBox {
	public String selection;

	public String getSelection() {
		return selection;
	}

	public void setSelection(String selection) {
		this.selection = selection;
	}
}