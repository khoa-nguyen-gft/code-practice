package design_pattern.command_pattern.solution02;

public class HtmlDocument {
	private String content;

	public void makeBold() {
		content = "<b>" + content + "</b>";
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
