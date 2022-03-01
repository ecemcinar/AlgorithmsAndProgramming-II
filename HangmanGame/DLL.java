
public class DLL {
	private DLLNode head;
	private DLLNode tail;
	
	
	public int size() {
		int count =0;
		DLLNode temp =head;
		while(temp!=null) {
			count++;
			temp = temp.getNext();
		}
		return count;
	}
	
	public boolean searchForWord(char letter) {
		String s = String.valueOf(letter); // Since compare method can be used with string, given char is converted to string.
		if(head == null)
			System.out.println("Linked list is empty");
		else {
			if(s.compareToIgnoreCase("M")<=0) { //  smaller or equal to "m", I check the DLL by starting from the head.
				DLLNode temp = head;
				while(temp!=null) {
					if(s.equalsIgnoreCase(String.valueOf(temp.getData()))) // if the letter exists. Also with equalsIgnoreCase, player is able to enter upper case or lower case letter
						return true;																												// it's up to user.
					temp = temp.getNext();
				}
			}
			else { // greater then "m", I check the DLL by starting from the tail
				DLLNode temp = tail;
				while(temp!=null) {
					if(s.equalsIgnoreCase(String.valueOf(temp.getData()))) // if the letter exists
						return true;
					temp = temp.getPrev();
				}
			}
		}
		return false; // if the letter does not exist
	}
	
	
	public void add(char dataToAdd) { // add a new node to the end
		if(head==null && tail==null) {
			DLLNode newNode = new DLLNode(dataToAdd);
			head = newNode; // pointing the first node
			tail = newNode; // pointing the last node
		}
		else {
			DLLNode newNode = new DLLNode(dataToAdd);
			newNode.setPrev(tail);
			tail.setNext(newNode);
			tail = newNode;
		}
	}
	
	public void remove(char data) { // delete the suggested letter from DLL
		if(head == null) {
			System.out.println("LinkedList is empty");
		}
		else {
			while(String.valueOf(head.getData()).equalsIgnoreCase(String.valueOf(data))) { // upper case or lower case letter control
				head =  head.getNext();
				head.setPrev(null);
			}
			DLLNode temp = head;
			while(temp != null) {
				if(String.valueOf(temp.getData()).equalsIgnoreCase(String.valueOf(data))){// upper case or lower case letter control
					if(temp.getNext() == null) {
						tail = tail.getPrev();
						tail.setNext(null);
					}
					else {
						( temp.getPrev()).setNext(temp.getNext());
						( temp.getNext()).setPrev(temp.getPrev());
					}
				}
				temp = temp.getNext();
			}			
		}
	}
	
	public void display() { // (which prints all items in the list from head to tail)
		if(head == null) System.out.println("Linked list is empty");
		else {
			DLLNode temp =head;
			while(temp!=null) {
				System.out.print(temp.getData() + " ");
				temp = temp.getNext();
			}
		}
	}
}
