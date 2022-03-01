public class Stack {

	private Card[] elements;
	private int top;
	
	 
	public Stack(int capacity) {
		elements = new Card[capacity];
		top = -1;
	}
	
	public boolean isEmpty() {
		return (top ==-1); 
	}
	
	public boolean isFull() {
		return (top +1 == elements.length);
	}
	
	
	public void Push(Card data) {
		if(isFull()) {
			System.out.println("Stack is full.");
		}
		else {
			top++;
			elements[top] = data;
		}
	}
	
	public Card pop() { 
		if(isEmpty()) {
			System.out.println("Stack is empty.");
			return null;
		}
		else {
			Card retData = elements[top];
			elements[top] = null;
			top--;
			return retData;
		}
	}
	
	public Card peek() {
		if(isEmpty()) {
			System.out.println("Stack is empty.");
			return null;
		}
		else {
			Card retData = elements[top];
			return retData;
		}
	}
	
	public int size() {
		return top+1;
	}
	
	
	
	
}
