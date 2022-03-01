package lab10;

public class RowNode {
		
	private int rowNumber;
	private RowNode down;
	private ColumnNode right;
	
	public RowNode(int dataToAdd) {
		rowNumber = dataToAdd;
		down = null;
		right = null;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
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
