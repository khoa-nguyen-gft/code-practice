package visitor.visitor01_solution;

public interface Operation {
	public void apply(HeadingNode heading) ;
	public void apply(AnchorNode anchor);
}
