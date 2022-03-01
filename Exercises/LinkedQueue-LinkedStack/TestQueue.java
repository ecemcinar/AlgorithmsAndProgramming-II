package lab12;

public class TestQueue {

	public static Object Median(LinkedQueue lq) {
		int size= lq.size();
		LinkedQueue temp = new LinkedQueue();
		if(size%2==0) {
			for (int i = 0; i < size/2 - 1; i++) {
				temp.enqueue(lq.dequeue());
			}
			int s1 = (int)lq.dequeue();
			int s2= (int) lq.dequeue();
			return (s1+s2)/2; // ortalamasý alýnýr
		}
		else{
			for (int i = 0; i < size/2; i++) {
				temp.enqueue(lq.dequeue());
			}
			return lq.peek(); // ortadaki sayý median'dýr
		}
		
	}
	public static void main(String[] args) {
		LinkedQueue lq = new LinkedQueue();
		
		// if size is odd number
		lq.enqueue(10);
		lq.enqueue(20);
		lq.enqueue(30);
		lq.enqueue(40);
		lq.enqueue(50);
		lq.enqueue(60);
		lq.enqueue(70);
		lq.display();	
		System.out.println("Median:" + Median(lq));

		//if size is even number
		lq= new LinkedQueue();
		
		lq.enqueue(10);
		lq.enqueue(20);
		lq.enqueue(30);
		lq.enqueue(40);
		lq.enqueue(50);
		lq.enqueue(60);
		lq.display();
		System.out.println("Median:" + Median(lq));
	}

}
