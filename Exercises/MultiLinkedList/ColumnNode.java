package lab10;

public class ColumnNode {

	private int number;
	private ColumnNode next;
	
	public ColumnNode(int dataToAdd) {
		number = dataToAdd;
		next = null;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public ColumnNode getNext() {
		return next;
	}

	public void setNext(ColumnNode next) {
		this.next = next;
	}
	
}
