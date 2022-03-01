

public class MLL {
	RowNode head;
	
	public void addRow(int dataToAdd) { // addRow method by sorting letter counts(word size) lowest to highest
		if (head == null) {
			RowNode newnode = new RowNode(dataToAdd);
			head = newnode;	 
		}
		else  {
			if( dataToAdd < (int) head.getRowNumber()) { // compare dataToAdd with head
				RowNode newnode = new RowNode(dataToAdd);
				newnode.setDown(head);
				head = newnode;
			}
			else {
				RowNode temp = head;
				RowNode previous = null;
				while(temp!=null && (int) dataToAdd > temp.getRowNumber()) {
					previous = temp;
					temp = temp.getDown();
				}
				if(temp ==null) { // add to last
					RowNode newnode = new RowNode(dataToAdd);
					previous.setDown(newnode);
				}
				else {
					if(dataToAdd!=temp.getRowNumber()) { // bu satir olmazsa ayni int degerini birden fazla ekliyor
						RowNode newnode = new RowNode(dataToAdd);
						newnode.setDown(temp);
						previous.setDown(newnode);
					}
					
				}
			}
		}
	}
	
	public void addColumn(int rowNumber, String columnWord) { // addColumn method by sorting words alphabetically
		if(head == null) 
			System.out.println("Add a row before column");
		else {
			RowNode temp = head;
			while(temp!=null) {
				if(rowNumber == temp.getRowNumber()) { 
					ColumnNode temp2 = temp.getRight();
					if(temp2==null) {
						ColumnNode newnode = new ColumnNode(columnWord);
						temp.setRight(newnode);
					}
					else {
						if(columnWord.compareTo(temp.getRight().getWord().toString())<0) { 
							while (temp2.getNext() != null)
								temp2 = temp2.getNext();
							ColumnNode newnode = new ColumnNode(columnWord);
							newnode.setNext(temp.getRight());
							temp.setRight(newnode);
						}
						else {
							while(temp2.getNext()!=null && columnWord.compareTo(temp2.getNext().getWord())>0) { 
								temp2 = temp2.getNext();
							}
							ColumnNode newnode = new ColumnNode(columnWord);
							newnode.setNext(temp2.getNext());
							temp2.setNext(newnode);
						}
					}
				}
				temp = temp.getDown();
			}
		}
	}
	
	public String country(int number) {  // find the numberTH index and return the word in numberTH index
		int count=0;
		if(head==null) {
			System.out.println("linked list is empty");
		}
		else {
			RowNode temp = head;
			while(temp!=null) {
				ColumnNode temp2 = temp.getRight();
				while(temp2!=null) {
					count++;
					if(count==number) { // bu if'e girerse bulmus demektir. 
						return temp2.getWord();
					}
					temp2 = temp2.getNext();
				}
				temp = temp.getDown();
			}
		}
		return null;
	}
	
	public int size() {
		int count = 0;
		if (head == null) {
			System.out.println("linked list is empty");
		} 
		else {
			RowNode temp = head;
			while (temp != null) {
				ColumnNode temp2 = temp.getRight();
				while (temp2 != null) {
					count++;
					temp2 = temp2.getNext();
				}
				temp = temp.getDown();
			}
		}
		return count;
	}
	public void display() {
		if(head==null) {
			System.out.println("linked list is empty");
		}
		else {
			RowNode temp = head;
			while(temp!=null) {
				System.out.print(temp.getRowNumber() + " --> ");
				ColumnNode temp2 = temp.getRight();
				while(temp2!=null) {
					System.out.print(temp2.getWord() + " ");
					temp2 = temp2.getNext();
				}
				temp = temp.getDown();
				System.out.println();
			}
		}
	}
}
