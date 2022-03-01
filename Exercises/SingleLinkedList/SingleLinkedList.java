package lab8;

public class SingleLinkedList {

	Node head;
	
	public void insert(Object dataToAdd) { // adding 
		if(head== null) head = new Node(dataToAdd);
		else {
			Node temp = head;
			while(temp.getLink()!=null) temp = temp.getLink();
			Node newnode = new Node(dataToAdd);
			temp.setLink(newnode);
		}
	}

	public void display() { // print the llist
		if(head == null) System.out.println("Linked list is empty");
		else {
			Node temp = head;
			while( temp!=null) {
				System.out.print(temp.getData()+ " ");
				temp = temp.getLink();
			}
		}
	}
	
	public int size() { 
		int count =0;
		if(head == null) System.out.println("Linked list is empty");
		else {
			Node temp = head;
			while(temp!=null) {
				count++;
				temp = temp.getLink();
			}
		}
		return count;
	}
	
	public void barGraph() {
		Node temp = head;
		// Harflerin ka� defa tekrar etti�ini bulmak i�in her biri i�in ayr� counter tuttum.
		int tempA=0;
		int tempB=0;
		int tempC=0;
		int tempD=0;
		int tempE=0;
		while(temp!=null) {
			if(temp.getData().toString().equalsIgnoreCase("A")) { // e�itse counter'� art�r�yorum.
				tempA++;
			}
			else if(temp.getData().toString().equalsIgnoreCase("B")) {
				tempB++;		
			}
			else if(temp.getData().toString().equalsIgnoreCase("C")) {
				tempC++;	
			}
			else if(temp.getData().toString().equalsIgnoreCase("D")) {
				tempD++;	
			}
			else if(temp.getData().toString().equalsIgnoreCase("E")) {
				tempE++;		
			}
			temp = temp.getLink();	
		}
		// for'un count kadar d�nmesi gerekiyor ��nk� count kadar "*" bas�lacak.

		System.out.print("\n--Bar Graph--" + "\nA");
		for (int i = 0; i < tempA; i++) { 
			System.out.print("*");
		}
		System.out.print("\nB");
		for (int i = 0; i < tempB; i++) {
			System.out.print("*");
		}
		System.out.print("\nC");
		for (int i = 0; i < tempC; i++) {
			System.out.print("*");
		}
		System.out.print("\nD");
		for (int i = 0; i < tempD; i++) {
			System.out.print("*");
		}
		System.out.print("\nE");
		for (int i = 0; i < tempE; i++) {
			System.out.print("*");
		}
	}
	}