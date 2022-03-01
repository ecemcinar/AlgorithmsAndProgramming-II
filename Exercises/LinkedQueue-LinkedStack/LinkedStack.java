package lab12;

public class LinkedStack {

	private Node top =null;
	private int numberElements=0;
	
	public void push(Object item) {
		Node newNode = new Node(item);
		newNode.setLink(top);
		top = newNode;
		numberElements++;	
	}
	
	public Object pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		}
		else {
			Object data = top.getData();
			top = top.getLink();
			numberElements--;
			return data;
		}
	}
	
	public Object peek() {
		if(isEmpty()) {
			System.out.println("stack is empty");
			return null;
		}
		else
			return top.getData();
	}
	
	public boolean isEmpty() {
		return top==null;
	}
	
	public int size() {
		return numberElements;
	}
	
	public void display() {
		if(isEmpty()) 
			System.out.println("stack is empty");
		else {
			Node temp =null;
			while(!isEmpty()) {
				System.out.print(temp.getData() + " ");
				Node newnode = new Node(top.getData());
				newnode.setLink(temp);
				temp = newnode;
				top = top.getLink();
			}
		}
	}
}
