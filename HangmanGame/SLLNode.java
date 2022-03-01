

public class SLLNode {
	private User data;
	private SLLNode link;
	
	
	public SLLNode(User dataToAdd) {
		data = dataToAdd;
		link = null;
	}
	
	public User getData() {
		return data;
	}
	public void setData(User data) {
		this.data = data;
	}
	public SLLNode getLink() {
		return link;
	}
	public void setLink(SLLNode link) {
		this.link = link;
	}

	
}
