package design_pattern.command_pattern.solution02;

public interface Command {
	public void execute();
}

class UndoCommand implements Command {
	
	private History history;
	
	
	public UndoCommand(History history) {
		this.history = history;
	}


	@Override
	public void execute() {
		if(history.size() > 0)
			history.pop().undoExecute();
	}

}
