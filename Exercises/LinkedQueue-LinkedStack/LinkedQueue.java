package lab12;

public class LinkedQueue {

	private Node front=null;
	private Node rear=null;
	private int numberElements=0;
	
	public void enqueue(Object item) {
		if(front==null) {
			Node newNode = new Node(item);
			rear = newNode;
			front = newNode;
		}
		else {
			Node newNode = new Node(item);
			rear.setLink(newNode);
			rear = newNode;
		}
		numberElements++;
	}

	public Object dequeue() {
		if(isEmpty()) {
			System.out.println("queue is empty");
			return null;
		}
		else {
			Object data = front.getData();
			front = front.getLink();
			numberElements--;
			return data;
		}
	}
	
	public Object peek() {
		if(isEmpty()) {
			System.out.println("queue is empty");
			return null;
		}
		else {
			return front.getData();
		}
	}
	
	public boolean isEmpty() {
		return front==null;
	}
	public int size() {
		return numberElements;
	}
	
	public void display() {
		if(isEmpty()) System.out.println("queue is empty");
		else {
			Node temp = null;
			while(!isEmpty()) {
				System.out.print(front.getData() + " ");
				Node newnode = new Node(front.getData());
				newnode.setLink(temp);
				temp = newnode;
				front = front.getLink();
			}
			while(temp!=null) {
				Node newnode = new Node(temp.getData());
				newnode.setLink(front);
				front = newnode;
				temp = temp.getLink();
			}
			System.out.println();
		}
	}
}
