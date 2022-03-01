

public class PriorityQueue {

	private int rear,front;
	private QueueElement[] elements;
	private int tempRear, tempFront;
	private QueueElement[] tempElements;
	
	PriorityQueue(int capacity) {
		elements = new QueueElement[capacity];
		tempElements = new QueueElement[capacity];
		rear = -1;
		front = 0;
		tempRear = -1;
		tempFront = 0;
		}
	
	void enqueue(QueueElement item) {
		if(isFull())
			System.out.println("Queue overflow");
		else {
			while(!isEmpty() && item.getPriority() <= peek().getPriority())
				tempEnqueue(dequeue());		
			
			tempEnqueue(item);
			
			while (!isEmpty())
				tempEnqueue(dequeue());
			
			while (!isEmptyTemp())
				simpleEnqueue(tempDequeue());
		}
	}
	
	void tempEnqueue(QueueElement item) {
		if(isFullTemp())
			System.out.println("Queue overflow");
		else {
			tempRear = (tempRear +1) % tempElements.length;
			tempElements[tempRear] = item;
		}
	}
	
	void simpleEnqueue(QueueElement item) {
		if(isFull()) 
			System.out.println("Queue overflow");
		else {
			rear = (rear + 1) % elements.length;
			elements[rear] = item;
		}
	}
	
	QueueElement dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is empty!");
			return null;
		}
	
	else {
		QueueElement item = elements[front];
		elements[front] = null;
		front = (front +1 ) % elements.length;
		return item;
		}
	}
	
	QueueElement tempDequeue() {
		if(isEmptyTemp()) {
			System.out.println("Queue is empty");
			return null;
		}
		else {
			QueueElement item = tempElements[tempFront];
			tempElements[tempFront] = null;
			tempFront = (tempFront +1) % tempElements.length;
			return item;
		}
	}
	
	QueueElement peek() {
		if(isEmpty()) {
			System.out.println("Queue is empty!");
			return null;
		}
		else 
			return elements[front];
	}
	
	boolean isEmpty() {
		return elements[front] == null; // true döner
	}
	
	boolean isEmptyTemp() {
		return tempElements[tempFront] == null; // true döner
	}
	
	boolean isFull() {
		return ( front == (rear + 1 ) % elements.length && elements[front] != null && elements[rear] !=null);
	}
	
	boolean isFullTemp() {
		return ( tempFront == (tempRear + 1 ) % tempElements.length && tempElements[tempFront] != null && tempElements[tempRear] !=null);
	}
}
