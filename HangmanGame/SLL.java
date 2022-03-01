
public class SLL {
	SLLNode head;

	
	public void insert(User dataToAdd) { // adding the user's to SLL, by sorting their scores highest to lowest
		if(head==null) {
			SLLNode newnode = new SLLNode(dataToAdd);
			head = newnode;
		}
		else {
			if((int) dataToAdd.getScore() >= (int)head.getData().getScore()) {
				SLLNode newnode = new SLLNode(dataToAdd);
				newnode.setLink(head);
				head = newnode;
			}
			else {
				SLLNode temp = head;
				SLLNode previous = null;
				while(temp!=null && (int) dataToAdd.getScore() < temp.getData().getScore()){
					previous = temp;
					temp = temp.getLink();
				}
				if(temp==null) { // add to the last of SLL
					SLLNode newnode = new SLLNode(dataToAdd);
					previous.setLink(newnode);
				}
				else {
					SLLNode newnode = new SLLNode(dataToAdd);
					newnode.setLink(temp);
					previous.setLink(newnode);
				}
			}
		}
	}
	
	public int size() { // find the size
		int count = 0;
		if (head == null)
			System.out.println("Linked list is empty");
		else {
			SLLNode temp = head;
			while (temp != null) {
				count++;
				temp = temp.getLink();
			}
		}
		return count;
	}
	
	public void display() { // print the list
		int i=1;
		if(head == null) System.out.println("Linked list is empty");
		else {
			SLLNode temp = head;
			while( temp!=null && i<11) { // to write top 10 score
				System.out.print(" \t\t\t\t\t\t\t " + i + "-" + temp.getData().getName() + " - " + temp.getData().getScore());
				System.out.println();
				i++;
				temp = temp.getLink();
			}
		}
	}
}
