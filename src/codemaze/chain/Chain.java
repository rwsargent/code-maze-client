package codemaze.chain;

public class Chain {
	StringBuilder links;
	public Chain() {
		links = new StringBuilder();
	}
	
	void addLink(char link) {
		links.append(link);
	}
	
	public String getLinks() {
		return links.toString();
	}
}
