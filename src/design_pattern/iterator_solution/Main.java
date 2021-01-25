package design_pattern.iterator_solution;

public class Main {

	public static void main(String[] args) {
		BrowserHistory history = new BrowserHistory();
		
		history.push("a");
		history.push("b");
		history.push("c");
		history.push("d");
		
		Iterator itegrator = history.createIterator();
		
		while(itegrator.hasNext()) {
			String current = itegrator.current();
			itegrator.next();
			System.out.println(current);
		}
		
//		for
//		
//		for (int i = 0; i < history.getUrls().size(); i++) {
//			String url = history.getUrls().get(i);
//			System.out.println(url);
//		}

	}

}
