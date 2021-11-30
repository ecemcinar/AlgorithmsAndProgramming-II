import java.util.Random;

public class Test {

	public static void display(User user) { // to print user informations more effective

		System.out.println("Name:" + user.getName() + "\tSurname:" + user.getSurname() + "\tGender:" + user.getGender());
		System.out.println("--Birthdate--" + "\nDay:" + user.getBirthdate().getDay() + "\t\tMonth:" + user.getBirthdate().getMonth() + "\t\tYear:" + user.getBirthdate().getYear());
		System.out.println("--Address--" + "\nStreet:" + user.getCont_address().getStreet() + "\tNo:" + user.getCont_address().getNo() + "\t\tTown:" + user.getCont_address().getTown() 
				+ "\tCity:" + user.getCont_address().getCity() + "\tCountry:" + user.getCont_address().getCountry() );
		System.out.println("--Phone Number--" + "\ncountry code:" + user.getNumber().getCountry_code() + "\tarea code:" + user.getNumber().getArea_code() + "\tnumber:" + user.getNumber().getPhone_number());
	}
	
	 public static Queue Cards(Queue cardq) { //cards are created sequentially
		String suit=null; 
		String rank = null; 
		Card card;
		for (int i = 0; i < 4; i++) { // for the suit
			if(i==0) {
				suit="C"; // clubs
			}
			else if(i==1) {
				suit="D"; //  diamonds
			}
			else if(i==2) {
				suit="H"; // hearts
			}
			else if(i==3) {
				suit="S"; // spades
			}
			for (int j = 1; j <= 13; j++) {  // each suit has 13 ranks of card
				if(j==1) rank="A";	
				else if(j==11) rank="J";
				else if(j==12) rank="Q"; // queen
				else if(j==13) rank="K"; // king
				else {
					rank= Integer.toString(j);
				}
				card = new Card(suit,rank);	// card is created for current suit and rank
				cardq.enqueue(card); // card is added to queue
			}
		}
		return cardq;
	}
	
	public static Queue randomizeShuffle(Queue cards,Queue temp) { // to shuffle the cards randomly
		Random rnd = new Random();
		for (int i = 0; i <52; i++) { // must turn up the number of cards
			int number =  1+rnd.nextInt(52-i);	// for example, there is 10 cards left in queue. number random shouldnt be 22,30 or greater than count of the cards left.  (52-i) prevents this.
			for (int j = 0; j <number-1; j++) { // number-1 cards enqueue(dequeue))
				cards.enqueue(cards.dequeue());
			}
			temp.enqueue(cards.dequeue());		// the next card(numberth) is stored here
		}
		return temp; 
	}

	public static void sDisplay1(Stack s1,int scoreUser1, int scoreUser2,int size) { // to print stack, scores again and again more effective
		Stack temp = new Stack(52);
		System.out.print("User1: Stack - ");
		for (int j = 0; j < size; j++) {
			System.out.print(s1.peek().getSuit() + s1.peek().getRank() + " ");
			temp.Push(s1.pop());
		}
		int space = temp.size(); 
        for (int i = 0; i < 50 - ((space * 2 + space) - 1) ;i++) { // to collimate
            System.out.print(" ");
        }
		System.out.print("\t\tUser1 Score: " + scoreUser1 + "\t\tUser2 Score: " + scoreUser2);
		while(!temp.isEmpty()) s1.Push(temp.pop());
	}
	
	public static void sDisplay2(Stack s1,int scoreUser1, int scoreUser2,int size) { // to print stack, scores again and again more effective
		Stack temp = new Stack(52);
		System.out.print("User2: Stack - ");
		for (int j = 0; j < size; j++) {
			System.out.print(s1.peek().getSuit() + s1.peek().getRank() + " ");
			temp.Push(s1.pop());
		}
		int space = temp.size();
        for (int i = 0; i < 50 - ((space * 2 + space) - 1);i++) { // to collimate
            System.out.print(" ");
        }
		System.out.print("\t\tUser1 Score: " + scoreUser1 + "\t\tUser2 Score: " + scoreUser2);
		while(!temp.isEmpty()) s1.Push(temp.pop());
		
		
	}
	
	public static void main(String[] args) {
		
		Phone phone1 = new Phone("+90","232","1234567"); // assign phone infos for user1
		Address address1 = new Address("Atatürk","408","Buca","Ýzmir","Türkiye"); // assign address infos for user1
		Date birth1 = new Date(16,8,2000);  // assign birthdate infos for user1
		User user1 = new User("Simge","Çýnar",birth1,"female",address1,phone1); // assign all infos to user1
					
		Phone phone2 = new Phone("+90","232","0224597"); // assign phone infos to user2
		Address address2 = new Address("Erzene","402","Bornova","Ýzmir","Türkiye");  // assign address infos for user2
		Date birth2 = new Date(20,9,1999); // assign birthdate infos for user2	
		User user2 = new User("Baran","Fiþek",birth2,"male",address2,phone2); // assign all infos to user2

		System.out.println("ALL INFORMATIONS" + "\n--User1--"); 
		display(user1); // print
		System.out.println("\n--User2--"); 
		display(user2); // print
		
		
		Queue tempToShuffle = new Queue(1000); // before shuffling , tempToShuffle queue is created 
		System.out.println("\n\nALL CARDS BEFORE SHUFFLE");
		Cards(tempToShuffle);  // ------------------------------------------ cards are created sequentially
		for (int i = 0; i < 52; i++) { // print all cards sequentially
			System.out.print(tempToShuffle.peek().getSuit() + tempToShuffle.peek().getRank() + " ");
			tempToShuffle.enqueue(tempToShuffle.dequeue());
		}
		
		Queue cards = new Queue(1000); // after shuffle cards will be stored in it
		randomizeShuffle(tempToShuffle,cards); // cards are shuffled randomly and stored in queue "CARDS"
		System.out.println("\n\nALL CARDS AFTER SHUFFLE");
		for (int i = 0; i < 52; i++) {
			System.out.print(cards.peek().getSuit() + cards.peek().getRank() + " ");
			cards.enqueue(cards.dequeue());
		}
		System.out.println("\n----------------------------------------------------------------------------------------------------------------------");
		System.out.print("\t\t\t\t\t\t\tGAME");
		System.out.println("\n----------------------------------------------------------------------------------------------------------------------");
		System.out.print("\t\t\t\t\t\t\t\t\t\tUser1: " + user1.getName() + "\t\tUser2: " + user2.getName());

		boolean flag = true; // for the game
		boolean flag1 = true; // for the user1's turn
		boolean flag2=true; // for the user2's turn
		System.out.println();	
		int scoreUser1 = 0; 
		int scoreUser2 = 0;
		Stack s1 = new Stack(52);
		Stack s2 = new Stack(52);
		boolean adder =true;

		while(flag && !cards.isEmpty()) { // GAME BEGINS	// the game finishes when cards.isEmpty. That means all cards are turned over	
			
			if(flag1) { // ---- user1 begins first
				while(adder) { // turnes card
					s1.Push(cards.dequeue());
					adder=false;
				}
				int size = s1.size();
				if(size>1) { // to select and compare cards, stack size must be greater than 1. (least2)
					Card card1 = s1.peek();
					Stack temp = new Stack(52);
					temp.Push(s1.pop());
					Card card2 = s1.peek();
					s1.Push(temp.pop()); // push it back to s1
					
					if(card1.getRank().equalsIgnoreCase(card2.getRank())) {
						scoreUser1+=3;
						adder=true; // if there is a relation between last two cards, cards continue to turn over
					}
					else if(card1.getSuit().equalsIgnoreCase(card2.getSuit())) { 
						scoreUser1+=1;
						adder=true; // if there is a relation between last two cards, cards continue to turn over
					}
					else {
						scoreUser1+=0;
						flag1=false; // if there is no relation between last two cards, user1 stops 
						flag2=true; // and user2 begins.
						adder=true; // cards begin to turn for user2
						s2 = new Stack(52); // reset the stack because new cards will be added in it
					}
				}
				sDisplay1(s1,scoreUser1,scoreUser2,size); // print

				if(size==1) { // if stack size is 1, another card is turned over
					adder=true;
				}
				System.out.println();		
			}
					
			else if(flag2) {
				while(adder) { // turnes card
					s2.Push(cards.dequeue());
					adder=false;
				}
				int size = s2.size();
				
				if(size>1) { // to select and compare cards, stack size must be greater than 1. (least2)
					Card card1 = s2.peek();
					Stack temp = new Stack(52);
					temp.Push(s2.pop());
					Card card2 = s2.peek();
					s2.Push(temp.pop());  // push it back to s2
				
					if(card1.getRank().equalsIgnoreCase(card2.getRank())) {
						scoreUser2+=3;
						adder=true; // if there is a relation between last two cards, cards continue to turn over
					}
					else if(card1.getSuit().equalsIgnoreCase(card2.getSuit())) {
						scoreUser2+=1;
						adder=true; // if there is a relation between last two cards, cards continue to turn over
					}
					else {
						scoreUser1+=0;
						flag1=true; // if there is no relation between last two cards, user2 stops 
						flag2=false; // and user1 begins.
						adder=true; // cards begin to turn for user1
						s1 = new Stack(52); // reset the stack because new cards will be added in it
					}
				}
				sDisplay2(s2,scoreUser1,scoreUser2,size); // print

				if(size==1) { // if stack size is 1, another card is turned over
					adder=true;
				}
				System.out.println();		
			}
					
		
			// the game finishes when a player reaches at least 10 points
			if(scoreUser1>=10 || scoreUser2>=10) flag=false;
	
		}
		System.out.print("\n----------------------------------------------------------------------------------------------------------------------");
		if(scoreUser1==scoreUser2) {
			System.out.println("\n\t\t\t\t\t\t\tDRAW!!");
		}
		else if(scoreUser1>scoreUser2) {
			System.out.println("\n\t\t\t\t\tWinner is " + user1.getName() + "(user1) with score " + scoreUser1 + "!!!" );
		}
		else {
			System.out.println("\n\t\t\t\t\tWinner is " + user2.getName() + "(user2) with score " + scoreUser2 + "!!!");
		}
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		
	}
}
