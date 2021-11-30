public class Stack {

	private Object[] elements;
	private int top;
	
	 
	public Stack(int capacity) {
		elements = new Object[capacity];
		top = -1;
	}
	
	public boolean isEmpty() {
		return (top ==-1); 
	}
	
	public boolean isFull() {
		return (top +1 == elements.length);
	}
	
	
	public void Push(Object data) {
		if(isFull()) {
			System.out.println("Stack is full.");
		}
		else {
			top++;
			elements[top] = data;
		}
	}
	
	public Object pop() { 
		if(isEmpty()) {
			System.out.println("Stack is empty.");
			return null;
		}
		else {
			Object retData = elements[top];
			elements[top] = null;
			top--;
			return retData;
		}
	}
	
	public Object peek() {
		if(isEmpty()) {
			System.out.println("Stack is empty.");
			return null;
		}
		else {
			Object retData = elements[top];
			return retData;
		}
	}
	
	public int size() {
		return top+1;
	}
	
	
	
	
}
