
public class Queue {
	private int rear,front;
	private Card[] elements;
	public Queue(int capacity) {
		elements = new Card[capacity];
		rear = -1;
		front = 0;
	}

	public boolean isEmpty() {
		return rear < front; // true döner
	}
	
	public boolean isFull() {
		return (rear + 1 ==  elements.length); // trueeeeeeeeeeee
	}
	
	public void enqueue(Card data) { // ekleeeeeeeeeeeer
		
		if(isFull()) {
			System.out.println("Queue is full!");
		}
		else {
			rear++;
			elements[rear] = data;
		}
	}
	
	public Card dequeue() { // sileeeeeeeer
		if(isEmpty()) {
			System.out.println("Queue is empty!");
			return null;
		}
		else {
			Card retData = elements[front];
			elements[front] = null;
			front++;
			return retData;
		}
	}
	
	public Card peek() { 
		if(isEmpty()) {
			System.out.println("Queue is empty!");
			return null;
		}
		else {
			Card retData = elements[front];			
			return retData;
		}
	}
	
	public int size() {
		return (rear - front + 1);
	}
		
}
