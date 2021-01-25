package design_pattern.visitor.visitor01_problem;

import java.util.ArrayList;
import java.util.List;

public class HtmlDocument {
	private List<HtmlNode> nodes = new ArrayList<>();
	
	public void add(HtmlNode node) {
		nodes.add(node);
	}
	
	public void highlight() {
		nodes.stream().forEach(node -> node.highlight());
	}
	
	public void planText() {
		nodes.stream().forEach(node -> node.planText());
	}
}
