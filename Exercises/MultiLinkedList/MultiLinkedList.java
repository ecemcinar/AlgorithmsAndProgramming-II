package lab10;

public class MultiLinkedList {

	RowNode head;
	
	public void addNumbertoRow(int dataToAdd) { // ismini insert yapabilirsin 
		if(head==null) {
			RowNode newnode = new RowNode(dataToAdd);
			head = newnode;	
		}
		else {
			RowNode temp = head;
			while(temp.getDown()!=null)
				temp=temp.getDown();
			RowNode newnode = new RowNode(dataToAdd);
			temp.setDown(newnode);
		}
	}
	
	public void addNumbertoColumn(int row,int column) {
		if(head==null) {
			System.out.println("Add a row before column");
		}
		else {
			RowNode temp = head;
			while(temp!=null) {
				if(row == temp.getRowNumber()) {
					ColumnNode temp2 = temp.getRight();
					if(temp2==null) {
						ColumnNode newnode = new ColumnNode(column);
						temp.setRight(newnode);
					}
					else {
						while(temp2.getNext()!=null)
							temp2 = temp2.getNext();
						ColumnNode newNode = new ColumnNode(column);
						temp2.setNext(newNode);
					}
				}
				temp = temp.getDown();
			}
		}
	}
	
	public int sizeRow() {
		int count=0;
		if(head==null) {
			System.out.println("linked list is empty");
		}
		else {
			RowNode temp = head;
			while(temp!=null) {
				count++;
				temp = temp.getDown();
			}
		}
		return count;
	}
	public int size() { // row x column yani toplamýnýn size'ý
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
					System.out.print(temp2.getNumber() + " ");
					temp2 = temp2.getNext();
				}
				temp = temp.getDown();
				System.out.println();
			}
		}
	}
	
	public boolean Scalar() {
		int i=0;
		int j=0;
		int row= sizeRow();
		RowNode temp = head;
		int RowNumber;
		int number = temp.getRight().getNumber();
		while(temp!=null && i < row) { // burda yapmaya çalýþtýðým þey c# ta for döngüleriyle arraylerde gezinmenin aynýsý. list yapýlarýnda bu while döngüleriyle olduðu için
			                                     // mantýken dönüþtürmüþ oldum.
			ColumnNode temp2 = temp.getRight();
			while(temp2!=null && j < row) {
				RowNumber = temp2.getNumber();
				if(i==j) { //  diagonal elementlerin birbirine eþit olmasý gerekiyor. 
					if(number!=RowNumber) {
						return false;	
					}
				}
				else if(i!=j) { // geri kalan her yerde 0 olmasý gerekiyor. deðilse scalar matrix deðildir.
					if(temp2.getNumber()!=0) {
						return false;
					}
				}
				j++;
				temp2=temp2.getNext(); 
			}
			//
			temp = temp.getDown(); // alt rowa geçer
			i++;
			j=0; // burda 0'lamak gerekiyor çünkü bir alt row'a geçiþ yapýyoruz.
		}
		return true;
	}
	
}
