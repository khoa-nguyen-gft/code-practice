package design_pattern.visitor.visitor01_solution;

public class PlainTextOperation implements Operation {

	@Override
	public void apply(HeadingNode heading) {
		System.out.println("Plain Text of Heading Node");
	}

	@Override
	public void apply(AnchorNode anchor) {
		System.out.println("Plain Text of Anchor Node");
	}



}
