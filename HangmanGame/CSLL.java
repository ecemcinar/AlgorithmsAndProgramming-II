import java.util.Locale;

public class CSLL {

	private CSLLNode head =null;
	
	public void add(char dataToAdd) {
		CSLLNode temp;
		if(head==null) {
			CSLLNode newnode = new CSLLNode(dataToAdd);
			head = newnode;
			head.setLink(head);
		}
		else { // add to the last
			temp = head;
			do {
				temp = temp.getLink();
			} while (temp.getLink()!=head);
			CSLLNode newnode = new CSLLNode(dataToAdd);
			newnode.setLink(temp.getLink());
			temp.setLink(newnode);
			
		}
	}
	
	public void change(CSLL cll1,CSLL cll2,char letter) {
		if(head ==null)
			System.out.println("empty!!");
		else {
			CSLLNode temp=cll1.head; // traversal in both CSLL1 and CSLL2 at the same time
			CSLLNode temp2=cll2.head;
			do {
				if(String.valueOf(temp.getData()).equalsIgnoreCase(String.valueOf(letter))) {  //csll1'de letter'a esit olan indeksi,csll2'de degistirmem gerekiyor
					letter = String.valueOf(letter).toUpperCase(Locale.ENGLISH).charAt(0); // girilen harfi uppercase olarak donusturuyorum.
					temp2.setData(letter); // set the data in csll2
				}
				temp = temp.getLink();
				temp2 = temp2.getLink();
				
			} while (temp!=cll1.head && temp2!=cll2.head); // kelimede ayni harften birden fazla bulunabilir. do while ile harfin birden fazla bulunmasi durumunda da degistirmis oluyorum.
		}
	}
	
	public int size() { // return the size of CSLL
		int count = 0;
		if(head == null)
			System.out.println("List is empty");
		else {
			CSLLNode temp = head;
			do {
				count++;
				temp = temp.getLink();
			}while(temp != head);
		}
		return count;
	}
	
	public boolean search(char letter) { //check for the given letter, if it exist in CSLL
		if(head == null)
			return false;
		else {
			CSLLNode temp = head;
			do {
				if(String.valueOf(temp.getData()).equalsIgnoreCase(String.valueOf(letter))) // control both upper case and lower case
					return true;
				temp = temp.getLink();
			}while(temp != head);
			return false;
		}
	}
	
	public void display() {
		if(head==null) System.out.println("linked list is empty");
		else {
			CSLLNode temp = head;
			do {
				System.out.print(temp.getData() + " ");
				temp = temp.getLink();
			} while (temp!=head);
			//System.out.println();
		}
	}
}
