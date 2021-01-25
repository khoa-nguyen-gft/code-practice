package design_pattern.visitor.visitor01_problem;

public class AnchorNode implements HtmlNode {

	@Override
	public void highlight() {
		System.out.println("hight light of Anchor Node");
	}

	@Override
	public String planText() {
		return "Anchor  Node";
	}
}
