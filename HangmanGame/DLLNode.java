
public class DLLNode {
	private char data;
	private DLLNode prev;
	private DLLNode next;
	
	public DLLNode(char dataToAdd) {
		data = dataToAdd;
		prev = null;
		next = null;
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public DLLNode getPrev() {
		return prev;
	}

	public void setPrev(DLLNode prev) {
		this.prev = prev;
	}

	public DLLNode getNext() {
		return next;
	}

	public void setNext(DLLNode next) {
		this.next = next;
	}
	
}
