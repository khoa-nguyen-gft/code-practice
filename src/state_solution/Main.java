package state_solution;

public class Main {
	public static void main(String[] args) {
		Canvas canvas = new Canvas();
//		/canvas.setCurrentTool(new BrushToolImpl());
		canvas.setCurrentTool(new EraserToolImpl());

		canvas.mouseDown();
		canvas.mouseUp();
	}
}
