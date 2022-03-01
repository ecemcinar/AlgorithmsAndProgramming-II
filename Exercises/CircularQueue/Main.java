package lab6;

public class Main {

	public static void main(String[] args) {
		CircularQueue q1 = new CircularQueue(10); // for the numbers
		CircularQueue q2 = new CircularQueue(10); // for the operators
		int step=1;
		
		q1.enqueue(14); q1.enqueue(20); q1.enqueue(13); q1.enqueue(7); q1.enqueue(8); 
		q1.enqueue(6); q1.enqueue(11); q1.enqueue(9); q1.enqueue(3); q1.enqueue(5);
		
		
		q2.enqueue("+"); q2.enqueue("+"); q2.enqueue("-"); q2.enqueue("*");
		q2.enqueue("+"); q2.enqueue("-"); q2.enqueue("*"); q2.enqueue("+"); q2.enqueue("+");

		System.out.print("Q1: ");
		for (int i = 0; i < 10; i++) {
			
			System.out.print(q1.peek() + " ");
			q1.enqueue(q1.dequeue());
		}
		System.out.print("\nQ2: ");
		for (int i = 0; i < 9; i++) {
			
			System.out.print(q2.peek() + " ");
			q2.enqueue(q2.dequeue());
		}
		int saved_opert = q2.size();
		for (int i = 0; i < saved_opert; i++) {
		System.out.println("\n\nStep " + step);
		int a = (int) q1.dequeue();
		int b = (int) q1.dequeue();
		String operator = (String) q2.dequeue();
		if(operator == "+") {
			int c = a+b;
			q1.enqueue(c);
		}
		else if(operator == "-") {
			int c = a-b;
			q1.enqueue(c);
		}
		else if(operator == "*") {
			int c = a*b;
			q1.enqueue(c);
		}
		System.out.print("Q1: ");
		 int saved_size = q1.size();
		for (int j = 0; j < saved_size; j++) {			
			System.out.print(q1.peek() + " ");
			q1.enqueue(q1.dequeue());
		}
		int saved_size2 = q2.size();
		System.out.print("\nQ2: ");
		for (int k = 0; k < saved_size2; k++) {
			
			System.out.print(q2.peek() + " ");
			q2.enqueue(q2.dequeue());
		}
		step++;
		}
		System.out.println("\nCalculating is finished! The result is written on the top.");
}
}
