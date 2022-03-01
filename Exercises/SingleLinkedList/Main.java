package lab8;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		SingleLinkedList llist = new SingleLinkedList();
		Random rnd = new Random();
		for (int i = 0; i < 16; i++) { // generate the llist
			int number = rnd.nextInt(5); // 0-5 arasý random atar
			char symbol;
			if(number ==0) {
				symbol = 'A';
				llist.insert(symbol);
			}
			else if(number==1) {
				symbol = 'B';
				llist.insert(symbol);
			}
			else if(number==2) {
				symbol = 'C';
				llist.insert(symbol);
			}
			else if(number==3) {
				symbol = 'D';
				llist.insert(symbol);
			}
			else if(number==4) {
				symbol = 'E';
				llist.insert(symbol);
			}
		}
		System.out.print("Randomly generated single linked list:" ); // print the llist
		llist.display();
		llist.barGraph();
	}
}
