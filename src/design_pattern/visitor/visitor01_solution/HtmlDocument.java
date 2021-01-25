package design_pattern.visitor.visitor01_solution;

import java.util.ArrayList;
import java.util.List;

public class HtmlDocument {
	private List<HtmlNode> nodes = new ArrayList<>();
	
	public void add(HtmlNode node) {
		nodes.add(node);
	}
	
	public void execute(Operation operation) {
		nodes.stream().forEach(node -> node.execute(operation));
	}
}
