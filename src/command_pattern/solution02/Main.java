package command_pattern.solution02;

public class Main {
	public static void main(String[] args) {
		History history = new History();
		HtmlDocument document = new HtmlDocument();

		document.setContent("hello content");

		UndoableCommand command = new BoldCommand(document, history);
		command.execute();
		System.out.println(document.getContent());

		Command undoCommand = new UndoCommand(history);
		undoCommand.execute();
		System.out.println(document.getContent());

	}
}
