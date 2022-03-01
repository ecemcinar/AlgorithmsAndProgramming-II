package lab9;

public class DoubleLinkedList {

	private Node head;
	private Node tail;
	
	
	public DoubleLinkedList() {
		head = null;
		tail = null;
	}
	
	public void add(Object dataToAdd) { // add a new node to the end
		if(head==null && tail==null) {
			Node newNode = new Node(dataToAdd);
			head = newNode; // pointing the first node
			tail = newNode; // pointing the last node
		}
		else {
			Node newNode = new Node(dataToAdd);
			newNode.setPrev(tail);
			tail.setNext(newNode);
			tail = newNode;
		}
	}
	
	public void display1() { // (which prints all items in the list from head to tail)
		if(head == null) System.out.println("Linked list is empty");
		else {
			Node temp =head;
			while(temp!=null) {
				System.out.print(temp.getData() + " ");
				temp = (Node) temp.getNext();
			}
		}
	}
	
	public void display2() { // (which prints all items in the list from head to tail)
		if(tail == null) System.out.println("Linked list is empty");
		else {
			Node temp = tail;
			while(temp!=null) {
				System.out.print(temp.getData() + " ");
				temp = (Node) temp.getPrev();
			}
		}
	}
	
	public int size() {
		int count =0;
		Node temp =head;
		while(temp!=null) {
			count++;
			temp = (Node) temp.getNext();
		}
		return count;
	}
	
	public void swap(int number) {
		int count = size(); // size of the dll
		if(number <= (count-1)/2 && number>0) {
			Node x = head;
			Node xPrev =null;
			for (int i = 1; i < number; i++) { // to update next pointer of the previous - for the xth node from beginning
				xPrev = x;
				x = (Node) x.getNext();
			}
			Node y = head;
			Node yPrev =null;
			for (int i = 1; i < count-number+1; i++) { // xth node from end. xth node from end is (count-number+1)th node from beginnig
				yPrev = y;
				y =(Node) y.getNext();
			}
			if(xPrev!=null) {
				xPrev.setNext(y);
			}
			if(yPrev!=null) {
				yPrev.setNext(x);
			}
		
			Node temp = (Node)x.getNext(); // swap next pointers of x and y.
			x.setNext(y.getNext());
			y.setNext(temp);
			
			if(number==1) head =y;
			if(number==count) head =x;
		}
		else if(number > count) System.out.println("The number you entered cannot be greater than the size of the list.Try again with different number.");			
		else if(2*number-1 == count) System.out.println("Since the number you entered is equal to the half, the list remains the same.");
		else if(number >(count-1)/2) System.out.println("The number you entered cannot be greater than half of the size.");
		else if(number<=0) System.out.println("The number you entered cannot be less than zero(or equal).Try again with different number.");	
	}
}
