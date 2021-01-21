package command_pattern.solution02;

public interface UndoableCommand extends Command {
	public void undoExecute();
}


class BoldCommand implements UndoableCommand {

	private String prevContent;
	private HtmlDocument document;
	private History history;
		
	
	public BoldCommand(HtmlDocument document, History history) {
		this.document = document;
		this.history = history;
	}

	@Override
	public void execute() {
		prevContent = document.getContent();
		document.makeBold();
		history.push(this);
	}

	@Override
	public void undoExecute() {
		document.setContent(prevContent);
	}

}
