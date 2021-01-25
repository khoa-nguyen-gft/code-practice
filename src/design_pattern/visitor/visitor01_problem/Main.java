package design_pattern.visitor.visitor01_problem;

public class Main {

	public static void main(String[] args) {
		HtmlDocument document = new HtmlDocument();
		document.add(new HeadingNode());
		document.add(new AnchorNode());
		
		document.highlight();
	}

}
