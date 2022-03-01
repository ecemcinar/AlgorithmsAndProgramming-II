

public class RowNode {
	private int count; // letter count
	private RowNode down;
	private ColumnNode right;
	
	public RowNode(int dataToAdd) {
		count = dataToAdd;
		down = null;
		right = null;
	}

	public int getRowNumber() {
		return count;
	}

	public void setRowNumber(int rowNumber) {
		this.count = rowNumber;
	}

	public RowNode getDown() {
		return down;
	}

	public void setDown(RowNode down) {
		this.down = down;
	}

	public ColumnNode getRight() {
		return right;
	}

	public void setRight(ColumnNode right) {
		this.right = right;
	}

}
