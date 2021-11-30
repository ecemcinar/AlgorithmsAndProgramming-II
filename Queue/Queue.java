

public class Queue {
	private int rear,front;
	private Object[] elements;
	public Queue(int capacity) {
		elements = new Object[capacity];
		rear = -1;
		front = 0;
	}

	public boolean isEmpty() {
		return rear < front; // true döner
	}
	
	public boolean isFull() {
		return (rear + 1 ==  elements.length); // trueeeeeeeeeeee
	}
	
	public void enqueue(Object data) { 
		
		if(isFull()) {
			System.out.println("Queue is full!");
		}
		else {
			rear++;
			elements[rear] = data;
		}
	}
	
	public Object dequeue() { 
		if(isEmpty()) {
			System.out.println("Queue is empty!");
			return null;
		}
		else {
			Object retData = elements[front];
			elements[front] = null;
			front++;
			return retData;
		}
	}
	
	public Object peek() { 
		if(isEmpty()) {
			System.out.println("Queue is empty!");
			return null;
		}
		else {
			Object retData = elements[front];			
			return retData;
		}
	}
	
	public int size() {
		return (rear - front + 1);
	}
	
	
	
}
