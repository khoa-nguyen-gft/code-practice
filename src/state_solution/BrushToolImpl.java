package state_solution;

public class BrushToolImpl extends AbstractTools {

	@Override
	public void mouseDown() {
		System.out.println("Brush icon");
	}

	@Override
	public void mouseUp() {
		System.out.println("Draw a line");
	}

}
