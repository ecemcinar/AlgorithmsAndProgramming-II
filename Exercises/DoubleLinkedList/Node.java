package lab9;

public class Node {

	private Object data;
	private Object prev;
	private Object next;
	
	public Node(Object dataToAdd) {
		data = dataToAdd;
		prev = null;
		next = null;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getPrev() {
		return prev;
	}

	public void setPrev(Object prev) {
		this.prev = prev;
	}

	public Object getNext() {
		return next;
	}

	public void setNext(Object next) {
		this.next = next;
	}
	
	
	
	
	
	
	
}
