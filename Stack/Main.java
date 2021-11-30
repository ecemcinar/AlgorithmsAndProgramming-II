import java.util.Random;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		Stack stack1 = new Stack(24); // hold the cards of the first player          ---- HUMAN
		Stack stack2 = new Stack(24); // hold the cards of the second player                   --- COMPUTER
		Stack stack3 = new Stack(24); // hold the cars on the table          -------- DESK
		Stack temp_stack = new Stack(24);
		Random rnd = new Random();
		while (!stack3.isFull()){  // firstly, i put the cards on the desk randomly. next, i will deal cards to the players
			int number = 1 +  rnd.nextInt(6); // random number between 1-6
			int number_count = 0; // control the number count, for example 'card 4's count cant be larger than 4
			temp_stack = new Stack(24);					
			while (!stack3.isEmpty()) {
				if ( (int) stack3.peek() != number) {
					temp_stack.Push(stack3.pop());
				}
				else{
					number_count++;
					temp_stack.Push(stack3.pop());
				}
			}
			if(number_count < 4) temp_stack.Push(number);
			stack3 = temp_stack;
		}		
		// each player gets 7 cards
			for (int i = 0; i < 7; i++) { // deal cards to the player1 (human) and then to the player2 (computer) 
				stack1.Push(stack3.pop());
				stack2.Push(stack3.pop());
			}		
			System.out.println("******* WELCOME TO GOFISH! *******");		
		
		boolean flag= true;
		boolean gamer = true; // necessary for the game to continue
		int player_book_counter =0;
		int computer_book_counter =0;
		while(flag) { // as long as the cards don't run out, flag is true
			// for the screen 
			temp_stack = new Stack(24); // reset the temp stack
			System.out.print("You: " + " ");
			while (!stack1.isEmpty()) {
				System.out.print(stack1.peek() + " ");
				temp_stack.Push(stack1.pop());
			}
			stack1 = temp_stack;
			System.out.print("\t\t PlayerBook : "+player_book_counter);
			System.out.print("\t\tDesk : ");
			temp_stack = new Stack(24);
			while (!stack3.isEmpty()) {
				System.out.print(stack3.peek() + " ");
				temp_stack.Push(stack3.pop());
			}
			stack3 = temp_stack;
			temp_stack = new Stack(24); // reset the temp stack 
			System.out.println();
			System.out.print("Computer: " + " ");
			while (!stack2.isEmpty()) {
				System.out.print(stack2.peek() + " ");
				temp_stack.Push(stack2.pop());
			}
			System.out.print("\t\tComputerBook : "+computer_book_counter);
			System.out.println();
			stack2 = temp_stack;
			if (gamer) { // -------- PLAYER'S TURN
				temp_stack = new Stack(24); // reset the temp stack
				Scanner sc = new Scanner(System.in);
				System.out.print("You ask: ");
				boolean flag2 = true; // if player doesnt have that card in her/his hand, flag is true
				int counter = 0;
				int input_number = sc.nextInt(); // get the number that player's chooses
										
				while (!stack1.isEmpty()) {
					if ( (int) stack1.peek() != input_number) {						
						temp_stack.Push(stack1.pop());
					}
					else{
						temp_stack.Push(stack1.pop());
						counter++;
						flag2 = false; // player cannot ask for the card if s/he doesnt have any. so flag become false, if player has it.
					}
				}
				stack1 = temp_stack;
				if(counter ==4) { 
					temp_stack = new Stack(24);	// reset the temp stack					
					while (!stack1.isEmpty()) {
						if ( (int) stack1.peek() != input_number) {
							temp_stack.Push(stack1.pop());
						}
						else{
							stack1.pop();
						}
					}
					stack1 = temp_stack;
					player_book_counter++; // If you have 4 of the same rank then you show the cards to the other player, and then place the four cards in a pile next to you. This is called a book.
					continue;
				}
				if (flag2) {
					System.out.println("**You may only ask for ranks that you already have at least one card of!!!!**");					
				}
				else { // player can ask for the card if s/he has it 
					boolean flag3 = true; // computer doesnt have it
					temp_stack = new Stack(24);		// reset the temp stack
					while (!stack2.isEmpty()) {
						if ( (int) stack2.peek() != input_number) {
							temp_stack.Push(stack2.pop());					
						}
						else{
							temp_stack.Push(stack2.pop());
							counter++;
							flag3 = false;
						}
					}
					stack2 = temp_stack;
					if (flag3) { // we can understand that computer doesnt have it. so player draw a card from table
						System.out.println("Computer says GOFISH! Draw one card from the pile on the table!!!! ");
						stack1.Push(stack3.pop());
						gamer = false;
					}
					else { // if computer has it
						temp_stack = new Stack(24);				// reset the temp stack	
						while (!stack2.isEmpty()) {
							if ( (int) stack2.peek() != input_number) {
								temp_stack.Push(stack2.pop());							
							}
							else{
								stack1.Push(stack2.pop());
							}
						}
						stack2 = temp_stack;
						if( counter ==4) { // for the book
							temp_stack = new Stack(24);		// reset the temp stack				
							while (!stack1.isEmpty()) {
								if ( (int) stack1.peek() != input_number) {
									temp_stack.Push(stack1.pop());
								}
								else{
									stack1.pop();								
								}
							}
							stack1 = temp_stack;
							player_book_counter++;
						}						
					}
				}
				
			}
			else { // --- COMPUTER'S TURN 
			
				System.out.print("Computer ask: ");
				boolean flag2 = true; // if computer doesnt have that card in her/his hand, flag is true
				int counter = 0;
				int random_number = 0;
				boolean flag4=true;
				while(flag4) {
					temp_stack = new Stack(24); // reset the temp stack
					random_number = rnd.nextInt(6)+1;
					while(!stack2.isEmpty()) { // When the computer plays, it randomly selects and asks a rank that it already has at least one card of.
						if((int)stack2.peek() != random_number) { 
							temp_stack.Push(stack2.pop());
						}
						else {
							temp_stack.Push(stack2.pop());
							counter++;
							flag4 = false;
						}
					}
					stack2 = temp_stack;
				}
				System.out.println(random_number); // print computer's random pick
				
				if(counter ==4) { // for the bookj
					temp_stack = new Stack(24);						
					while (!stack2.isEmpty()) {
						if ( (int) stack2.peek() != random_number) {
							temp_stack.Push(stack2.pop());
						}
						else{
							stack2.pop();
						}
					}
					stack2 = temp_stack;
					computer_book_counter++; // If you have 4 of the same rank then you show the cards to the other player, and then place the four cards in a pile next to you. This is called a book.
					continue;
				}
				
				boolean flag3 = true; // player doesnt have it
				temp_stack = new Stack(24);				// reset the temp stack
				while (!stack1.isEmpty()) {
					if ( (int) stack1.peek() != random_number) {
						temp_stack.Push(stack1.pop());						
					}
					else{
						temp_stack.Push(stack1.pop());
						counter++;
						flag3 = false;
					}
				}
				stack1 = temp_stack;
				if (flag3) {
					System.out.println("You say GOFISH! Computer draws card from the pile on the table!!!!");
					stack2.Push(stack3.pop());
					gamer = true;
				}
				else { // if player has it
					temp_stack = new Stack(24);				// reset the temp stack	
					while (!stack1.isEmpty()) {
						if ( (int) stack1.peek() != random_number) {
							temp_stack.Push(stack1.pop());						
						}
						else{
							stack2.Push(stack1.pop());
						}
					}
					stack1 = temp_stack;
					if( counter ==4) { // for the book
						temp_stack = new Stack(24);						
						while (!stack2.isEmpty()) {
							if ( (int) stack2.peek() != random_number) {
								temp_stack.Push(stack2.pop());
							}
							else{
								stack2.pop();								
							}
						}
						stack2 = temp_stack;
						player_book_counter++;
					}					
				}
			}		
			if (stack1.isEmpty() || stack2.isEmpty() || stack3.isEmpty()) { // If one of the players (human or computer) finishes all the cards in his hand, the game is over. Or the desk run out,the game is over too.
				flag= false;			
			}
		}
		//  to assign the winner
		System.out.println("***** GAME OVER *****");
		if(computer_book_counter <player_book_counter) { 
			System.out.println("YOU WON THE GAME!");
		}else if(computer_book_counter ==player_book_counter) {
			System.out.println("TIE!");
		}
		else System.out.println("COMPUTER WON THE GAME!"); // computer_book_counter > player_book_counter
	}
}