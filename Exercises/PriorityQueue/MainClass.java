import java.io.File;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args)throws Exception {
		
		PriorityQueue q1 = new PriorityQueue(1000); // B1
		PriorityQueue q2 = new PriorityQueue(1000); // B2
		File file = new File("C:\\Users\\ecems\\Desktop\\data.txt"); // reading file
		Scanner s = new Scanner(file);
		int cost=0; // for the cost
		while(s.hasNextLine()) {
			String line =s.nextLine();
			String[] arr = line.split(" ");	
			if(Integer.parseInt(arr[2])>= 70 ) {
				QueueElement qElement = new QueueElement(line,2); // priority is 2
				if(arr[1].equalsIgnoreCase("B1")) {
					q1.enqueue(qElement);
				}
				else { //for B2 
					q2.enqueue(qElement);
				}
			}
			else { 
				QueueElement qElement = new QueueElement(line,1); //priority is 1
				if(arr[1].equalsIgnoreCase("B1")) {
					q1.enqueue(qElement);
				}
				else { //for B2 
					q2.enqueue(qElement);
				}
			}
			if(arr[3].equalsIgnoreCase("normal")) { // calculate the cost
				if(Integer.parseInt(arr[2])>= 65 ) // free
					continue;
				else 
					cost+=2; 
			}
			else if(arr[3].equalsIgnoreCase("student")) { // 1 tl
				cost++;
			}	
		}
		PriorityQueue temp_q1 = new PriorityQueue(1000); // temp queue is necessary to print the queue
		PriorityQueue temp_q2 = new PriorityQueue(1000);
		System.out.println("Priority Queue B1"); // before tour
		for (int i = 0; i < 22; i++) {
			System.out.println(q1.peek().getData());
			temp_q1.enqueue(q1.dequeue());
		}
		q1 = temp_q1;
		System.out.println("\nPriority Queue B2"); //before tour
		for (int i = 0; i < 11; i++) {
			System.out.println(q2.peek().getData());
			temp_q2.enqueue(q2.dequeue());
		}
		q2 = temp_q2;
		
		for (int i = 0; i < 8; i++) { // first 8 passengers
			q1.dequeue();
		}		
		System.out.println("\n****After Tour 1****"); //----------TOUR 1 
		System.out.println("Priority Queue B1");
		temp_q1 = new PriorityQueue(1000);
		for (int i = 0; i <14; i++) {
			System.out.println(q1.peek().getData());
			temp_q1.enqueue(q1.dequeue());
		}
		q1=temp_q1;
		 temp_q2 = new PriorityQueue(1000);
		System.out.println("\nPriority Queue B2");
		for (int i = 0; i <11; i++) {
			System.out.println(q2.peek().getData());
			temp_q2.enqueue(q2.dequeue());
		}
		q2=temp_q2;
		System.out.println("\n****After Tour 2****"); // ---------------TOUR 2
		for (int i = 0; i < 8; i++) {
			q1.dequeue();
		}	
		temp_q1 = new PriorityQueue(1000); // reseting the temp queue
		temp_q2 = new PriorityQueue(1000); // reseting the temp queue
		System.out.println("Priority Queue B1");
		for (int i = 0; i <6; i++) {
			System.out.println(q1.peek().getData());
			temp_q1.enqueue(q1.dequeue());
		}
		q1=temp_q1;
		System.out.println("\nPriority Queue B2");
		for (int i = 0; i <11; i++) {
			System.out.println(q2.peek().getData());
			temp_q2.enqueue(q2.dequeue());
		}
		q2=temp_q2;
		System.out.println("\n****After Tour 3****"); // ---------------TOUR 3
		for (int i = 0; i < 6; i++) {
			q1.dequeue();
		}	
		for (int i = 0; i < 2; i++) {
			q2.dequeue();
		}
		System.out.println("Priority Queue B1"); // empty, so there is no need to print the queue
		temp_q2 = new PriorityQueue(1000); // reseting the temp queue
		System.out.println("\nPriority Queue B2");
		for (int i = 0; i <9; i++) {
			System.out.println(q2.peek().getData());
			temp_q2.enqueue(q2.dequeue());
		}
		q2=temp_q2;
		System.out.println("\n****After Tour 4****"); // ---------------TOUR 4
		for (int i = 0; i <8; i++) {
			q2.dequeue();
		}
		System.out.println("Priority Queue B1"); // empty, so there is no need to print the queue
		temp_q2 = new PriorityQueue(1000); // reseting the temp queue
		System.out.println("\nPriority Queue B2");
		for (int i = 0; i <1; i++) {
			System.out.println(q2.peek().getData());
			temp_q2.enqueue(q2.dequeue());
		}
		System.out.println("\n****After Tour 5****"); // ---------------TUR 5
		System.out.println("Priority Queue B1"); // empty, so there is no need to print the queue
		System.out.println("Priority Queue B2"); // empty, so there is no need to print the queue
		System.out.println("\nOverall Income: " + cost); // print the cost
	}
}