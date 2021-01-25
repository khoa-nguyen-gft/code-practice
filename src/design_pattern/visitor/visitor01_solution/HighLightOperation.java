package design_pattern.visitor.visitor01_solution;

public class HighLightOperation implements Operation {

	@Override
	public void apply(HeadingNode heading) {
		System.out.println("hight light of Heading Node");
	}

	@Override
	public void apply(AnchorNode anchor) {
		System.out.println("hight light of Anchor Node");
	}

}
