
public class ColumnNode {
	private String word;
	private ColumnNode next;
	
	public ColumnNode(String dataToAdd) {
		word = dataToAdd;
		next = null;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public ColumnNode getNext() {
		return next;
	}

	public void setNext(ColumnNode next) {
		this.next = next;
	}
	
	
}
