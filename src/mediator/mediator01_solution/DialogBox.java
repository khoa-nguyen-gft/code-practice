package mediator.mediator01_solution;

public abstract class DialogBox {
	public abstract void change(UIControl control);
}

class ArticlesDialogBox extends DialogBox {
	private ListBox articlesListBox = new ListBox(this);
	private TextBox titleTextBox = new TextBox(this);
	private Button saveButton = new Button(this);

	
	public void simulateUserInteraction() {
		articlesListBox.setSelection("Article 1");
		titleTextBox.setContext("");
		System.out.println("TextBox: " + titleTextBox.getContext());
		System.out.println("Button: " + saveButton.isEnable());
	}
	
	@Override
	public void change(UIControl control) {
		if(articlesListBox == control) {
			listBoxChanged();
		} else if (titleTextBox == control) {
			textBoxChanged();
		}
	}

	private void textBoxChanged() {
		String content = titleTextBox.getContext();
		boolean isEmpty = (content == null || content.isEmpty());
		saveButton.setEnable(!isEmpty);
	}

	private void listBoxChanged() {
		titleTextBox.setContext(articlesListBox.getSelection());
		saveButton.setEnable(true);
	}

}