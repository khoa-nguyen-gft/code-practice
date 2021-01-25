package design_pattern.iterator_solution;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistory {
	//Replace type of urls from List to Array
	//private List<String> urls = new ArrayList<String>();
	  private String [] urls = new String[10];
	  private int count;
	  
	public String pop() {
		return urls[--count];
	}

	public void push(String url) {
		urls[count++] = url;
	}

	
	public Iterator createIterator() {
		return new ArrayIterator(this);
	}
	
	public class ArrayIterator implements Iterator {

		private BrowserHistory history;
		private int index;

		public ArrayIterator(BrowserHistory history) {
			this.history = history;
			index = 0;
		}

		@Override
		public boolean hasNext() {
			return index < history.count - 1;
		}

		@Override
		public void next() {
			if (index < history.count - 1) {
				index++;
			}
		}

		@Override
		public String current() {
			return history.urls[index];
		}
	}
	
	
//	public class ListIterator implements Iterator {
//
//		private BrowserHistory history;
//		private int index;
//
//		public ListIterator(BrowserHistory history) {
//			this.history = history;
//			index = 0;
//		}
//
//		@Override
//		public boolean hasNext() {
//			return index < history.urls.size() - 1;
//		}
//
//		@Override
//		public void next() {
//			if (index < history.urls.size() - 1) {
//				index++;
//			}
//		}
//
//		@Override
//		public String current() {
//			if (index < history.urls.size() - 1) {
//				return history.urls.get(index);
//			}
//			return null;
//		}
//	}

}
