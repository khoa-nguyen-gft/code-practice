package design_pattern.visitor.visitor01_problem;

public class HeadingNode implements HtmlNode {
	@Override
	public void highlight() {
		System.out.println("hight light of Heading Node");
	}

	@Override
	public String planText() {
		return "Heading Node";
	}

}
