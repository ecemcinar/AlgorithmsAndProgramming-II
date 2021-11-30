
public class SingleLinkedList {
	
	Node head;
	public SingleLinkedList() {
		this.head=null;
	}
	public void insert(int dataToAdd) {
		if(head== null) head = new Node(dataToAdd);
		else {
			Node temp = head;
			while(temp.getLink()!=null) temp = temp.getLink();
			Node newnode = new Node(dataToAdd);
			temp.setLink(newnode);
		}
	}

	public void display() { // print the list
		if(head == null) System.out.print(""); // Linked list is empty
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
		if(head == null) System.out.print(""); // Linked list is empty
		else {
			Node temp = head;
			while(temp!=null) {
				count++;
				temp = temp.getLink();
			}
		}
		return count;
	}
	
	public boolean game() { // horizontally control 
		int size = size();
		Node temp = head;
		if(temp!=null) {
			int i=0;
			temp = head;
			while( temp!=null && i<size-2) { //  i < size-2 olmasayd� exception veriyordu. exception� engellemek i�in i<size-2 yazd�m
				int item = temp.getData();
				Node temp2 = temp.getLink(); // bi sonraki node'a ge�mek i�in
				int item2 = temp2.getData();
				Node temp3= temp2.getLink(); // bi sonraki node'a ge�mek i�in
				int item3 = temp3.getData();
				
				if((item+1==item2 && item2+1==item3) || (item3+1==item2 && item2+1==item)) { // incremental or decremental
					return false; // 
				}
				else {
					temp = temp.getLink(); // �stteki ko�ulu sa�lamazsa bi sonraki say� i�in kontrol eder
					i++;
				}
			}
		}
		return true;
	}
	public boolean game2(SingleLinkedList sll1,SingleLinkedList sll2,SingleLinkedList sll3) { //vertically control
		Node temp = sll1.head; // her s�tun i�in kontrol eder 
		Node temp2 = sll2.head;
		Node temp3 = sll3.head;
		while( temp!=null&& temp2!=null && temp3!=null ) {
			int item = temp.getData();
			int item2 = temp2.getData();
			int item3 = temp3.getData();
			if((item+1==item2 && item2+1==item3) || (item3+1==item2 && item2+1==item)) { //incremental or decremental
				return false;
			}
			else {
				temp = temp.getLink();
				temp2 = temp2.getLink();
				temp3 = temp3.getLink();
			}
		}
		return true;
	}
	
	public boolean game3(SingleLinkedList sll1,SingleLinkedList sll2,SingleLinkedList sll3) { // diagonally (sa�a do�ru)
		if(sll1.size()>0 && sll2.size()>1 && sll3.size()>2) { // bu ko�ulu sa�lamas� gerekiyor. e�er ba�ka t�rl� yazsayd�m exception verirdi. mutlaka bu ko�ul sa�lanmal�
			Node temp = sll1.head;
			Node temp2 = sll2.head.getLink();
			Node temp3 = sll3.head.getLink().getLink();
			while(temp!=null && temp2!=null && temp3!=null) {
				int item = temp.getData();
				int item2 = temp2.getData();
				int item3 = temp3.getData();
				if((item+1==item2 && item2+1==item3) || (item3+1==item2 && item2+1==item)) { //incremental or decremental
					return false;
				}
				else {
					temp = temp.getLink();
					temp2 = temp2.getLink();
					temp3 = temp3.getLink();
				}
			}
		}
		return true;
	}
	
	public boolean game4(SingleLinkedList sll1,SingleLinkedList sll2,SingleLinkedList sll3) { // diagonally sola do�ru
		if(sll3.size()>0 && sll2.size()>1 && sll1.size()>2) { // bu ko�ulu sa�lamas� gerekiyor. e�er ba�ka t�rl� yazsayd�m exception verirdi. mutlaka bu ko�ul sa�lanmal�
			Node temp3 = sll3.head;
			Node temp2 = sll2.head.getLink();
			Node temp = sll1.head.getLink().getLink();
			while(temp!=null && temp2!=null && temp3!=null) {
				int item = temp.getData();
				int item2 = temp2.getData();
				int item3 = temp3.getData();
				if((item+1==item2 && item2+1==item3) || (item3+1==item2 && item2+1==item)) { //incremental or decremental
					return false;
				}
				else {
					temp = temp.getLink();
					temp2 = temp2.getLink();
					temp3 = temp3.getLink();
				}
			}
		}
		return true;
	}
}
