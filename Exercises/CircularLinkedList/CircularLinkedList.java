package lab11;

public class CircularLinkedList {

	private Node head=null;
	
	public void add(String dataToAdd) { // add to the beginning list
		Node temp;
		if(head==null) {
			Node newnode = new Node(dataToAdd);
			head = newnode;
			head.setLink(head);
		}
		else {
			temp = head;
			do {
				temp = temp.getLink();
			} while (temp.getLink()!=head);
			Node newnode = new Node(dataToAdd);
			newnode.setLink(head);
			temp.setLink(newnode);
			head = newnode;
//			if(dataToAdd.compareTo((String) head.getData())<0) {
//				
//			}
//			else { // add to middle and last
//				temp = head;
//				while(temp.getLink()!=head && dataToAdd.compareTo((String)temp.getLink().getData())>0)
//						temp = temp.getLink();
//				
//				Node newnode = new Node(dataToAdd);
//				newnode.setLink(temp.getLink());
//				temp.setLink(newnode);
//			}
		}
	}

	public int count() {
		int count=0;
		if(head==null) System.out.println("linked list is empty");
		else {
			Node temp = head;
			do {
				count++;
				temp = temp.getLink();
			} while (temp != head);
		}
		return count;
	}
	
	public void display() {
		if(head==null) System.out.println("linked list is empty");
		else {
			Node temp = head;
			do {
				System.out.print(temp.getData() + " ");
				temp = temp.getLink();
			} while (temp!=head);
			System.out.println();
		}
	}
	
	public void Josephus(int x,int y) {
		CircularLinkedList cll = new CircularLinkedList();
		
		for (int i = x; i >= 1; i--) {
			cll.add(Integer.toString(i));
		}
		int size= cll.count();
		Node temp = head;
		do {
			for (int i = 0; i <y-2; i++) { // a b c d e gibi bir listte a'dan baþladýðýmda d'yi silmek istiyorsam  c'nin linkini e yapmam lazým. bu forla tempin a'dan c'ye gelmesini saðlýyorum.
				temp = temp.getLink();
			}
			temp.setLink(temp.getLink().getLink()); // a b c þeklinde dizilsinler. burada b'yi silmek için, a'nýn linkini c'ye baðlýyorum ve b'yi silmiþ oluyorum.
			temp = temp.getLink(); // sildikten sonra bir sonrakine geçebilirim.
			size--; // her adýmda 1 eleman silindiði için size'da 1 eksilmiþ oluyor.
		} while (size!=1); // en sona 1 eleman kalmasý gerektiði için bu durumu yazdým.
		
		System.out.println("Last remaining: " + temp.getData());
	}
}
