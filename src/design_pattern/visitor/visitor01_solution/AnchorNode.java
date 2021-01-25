package design_pattern.visitor.visitor01_solution;

public class AnchorNode implements HtmlNode {

	@Override
	public void execute(Operation operation) {
		operation.apply(this);
	}
	
//	@Override
//	public void highlight() {
//		System.out.println("hight light of Anchor Node");
//	}
//
//	@Override
//	public String planText() {
//		System.out.println("Plan Text of Anchor Node");
//
//		return "Anchor  Node";
//	}
}
