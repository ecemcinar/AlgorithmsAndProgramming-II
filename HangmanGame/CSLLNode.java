

public class CSLLNode {
	private char data;
	private CSLLNode link;
	
	public CSLLNode(char dataToAdd) {
		data = dataToAdd;
		link = null;
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public CSLLNode getLink() {
		return link;
	}

	public void setLink(CSLLNode link) {
		this.link = link;
	}
	
}
