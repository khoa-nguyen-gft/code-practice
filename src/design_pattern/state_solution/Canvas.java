package design_pattern.state_solution;

public class Canvas extends AbstractTools {
	private AbstractTools currentTool;


	public void mouseDown() {
		currentTool.mouseDown();
	}

	public void mouseUp() {
		currentTool.mouseUp();
	}
	
	
	public AbstractTools getCurrentTool() {
		return currentTool;
	}

	public void setCurrentTool(AbstractTools currentTool) {
		this.currentTool = currentTool;
	}

	
	

}
