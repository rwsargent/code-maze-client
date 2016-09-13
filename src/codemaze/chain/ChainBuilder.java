package codemaze.chain;

import codemaze.Constants;
import codemaze.PropertyHandler;

public class ChainBuilder {
	
	private Chain chain;
	private int brokenLinkIdx = findBrokenLink();
	
	public ChainBuilder() {
		chain = new Chain();
	}
	
	public ChainBuilder addLink(char link) {
		chain.addLink(link);
		String uid = PropertyHandler.getProperties().getProperty(Constants.LabPropertyKeys.UID);
		if(link == uid.charAt(brokenLinkIdx)) {
			return null;
		}
		return this;
	}
	
	public Chain build() {
		return chain;
	}
	
	public static int findBrokenLink() {
		String uid = PropertyHandler.getProperties().getProperty(Constants.LabPropertyKeys.UID);
		return uid.hashCode() % uid.length();
	}
}
