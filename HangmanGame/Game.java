import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Game {

	private DLL letters = new DLL(); // DLL to store letters
	private String name; // player's name 
	HighScoreTable hst = new HighScoreTable();
	Words w = new Words();
	
	CSLL csll1 = new CSLL(); // to store randomTH word like M A L T A
	CSLL csll2 = new CSLL(); // to store randomTH word like - - - - 
	Scanner sc = new Scanner(System.in);
	String kelime;
	private int live = 6; // player has 6 lives beginning of the game
	private int score=0; // score before the game starts
	
	Game() throws Exception{ 
		
		System.out.println("----------------------------------------------------------G-A-M-E---S-T-A-R-T-----------------------------------------------------------");
		letters();
		getName();
		Words();
		System.out.println("\n\t\t\t\t\t\t\t    GAME RULES" + "\n\t\t\t\t\t\t1-You can enter both uppercase and lowercase. It's up to you." + 
							"\n\t\t\t\t\t\t2-Do not use Turkish letters!!" + "\n\t\t\t\t\t\t3-You have 6 lives. Use them carefully!!");
		System.out.println();
		RandomWord();
		while(live>0) { // game loop
			System.out.print("WORD: ");
			csll2.display();
			System.out.print("\t\t\tLives: " + live + " " + "\t\tScore: " + score + "\t");
			letters.display();
			System.out.print("\nGuess:");
			char guess = sc.nextLine().charAt(0); // get input from user
			
			// kontrolu yaparken uppercase'e yuvarladigim icin input olarak ikisinden birini girdigimde bu if satirina giriyordu.engellemek icin guess!='Ý' ve guess!='ý' kosullarini ekledim.
			if(letters.searchForWord(guess) && guess!='Ý' && guess!='ý') { // search for the word(the given input) if it exists in DLL
				letters.remove(guess); // suggested letter is deleted from the DLL
				
				if(csll1.search(guess)) { // if given letter exists in CSLL1
					
					csll2.change(csll1, csll2, guess); // "-" in csll2 changes into letter.(all correct positions)
					
					if(guess=='a' || guess=='e' || guess=='u' || guess=='i' || guess=='o' || guess=='A' || guess=='E' || guess=='U' || guess=='I' || guess=='O' )   
						score+=5; //the user gets 5 points for each vowel letter he/she knows.
					
					else  // the user gets 10 points for each consonant letter he/she knows. 
						score+=10;
					
				}
				else {  // if given letter does not exist in CLL1
					live--; // live decreases 
				}
			}
								
			else if( guess=='ü'  || guess=='ö' || guess=='þ' ||  guess=='Þ' || guess=='Ü'  || guess=='Ö' || guess=='Ð' || guess=='ç' || guess=='Ç' || guess=='ð' || guess=='Ý' || guess=='ý') { // Turkish letters control
				System.out.println("Enter only English letters!!");
			}
			else if((int) guess<65 || ((int) guess>90 && (int) guess < 96) || (int) guess>122) { // if player enters numbers, punctuation (like '.' or '!') or any other invalid char (i use ASCII table)
				System.out.println("Invalid character!!");
			}
			else { // if the word does not exist in DLL
				System.out.println("You entered the same letter before!!");
			}
			
			if(!csll2.search('-')) { // winning the game ( if there are no "-" left in CLL2, that means the word is accomplished.)
				System.out.print("WORD: ");
				csll2.display();
				System.out.print("\t\t\tLives: " + live + " " + "\t\tScore: " + score + "\t");
				letters.display();
				System.out.println();
				System.out.println("\n---------------------------------------------------C-O-N-G-R-A-T-U-L-A-T-I-O-N-S-!!!------------------------------------------------");
				System.out.println("\t\t\t\t\t\t\t High Score Table");
				ScoreTable(); // high score table is shown on the screen (top 10 players)
				break;
			}
		}
		
		if(live==0) { // if there are no lives, the game is over
			System.out.println("\n-------------------------------------------------Y-O-U--L-O-S-T-------P-L-A-Y--A-G-A-I-N-------------------------------------------------");
			System.out.println("The word was:" + kelime); // word is shown in the screen
			System.out.println("\t\t\t\t\t\t\t High Score Table");
			ScoreTable(); // high score table is shown on the screen (top 10 players)
		}
	}
	
	public void ScoreTable() throws Exception {
		hst.Read(); // read the HighScoreTable and store values in SLL. 
		User player = new User(name,score); // create a user object for the player with her/his name and score 
		hst.sll.insert(player); // then insert the player to the SLL.
		hst.sll.display();
		
		// update the file by top 10 score
		 new FileWriter("HighScoreTable.txt", false).close(); //firstly, deleted all lines in file (false parameter ensures this)
		 FileWriter fileWriter = new FileWriter("HighScoreTable.txt", true); // true parameter provides adding to the bottom of existing lines
	     BufferedWriter wrt = new BufferedWriter(fileWriter);
	     SLLNode temp = hst.sll.head;
	     
	     int i=1; // en yuksek 10 score'u txt dosyasina yazip dosyanin guncellenmesi istenmis. integer bir degisken tutup en yuksek 10 skorun yazilmasini kontrol edebilirim.
		 while(temp!=null && i<11) { // 
			 String line = temp.getData().getName() + ";" + temp.getData().getScore(); // create a string to add to the file
		        wrt.write(line); // write to file
		        if(i<10) // satiri yazdiktan sonra bir sonraki satira gecmek icin. son satirin yazimina geldigim zaman dosyada fazladan satir olmasin diye boyle bir if kosulu yazdim.
		        	wrt.newLine();
				temp = temp.getLink(); // next node
				i++; // next line
		 }
		  wrt.close(); // close the file at the end 
	}
	
	public DLL letters() { // store alphabet (all letters)in DLL
		for (int i =65; i < 91; i++) { // using ASCII table
			letters.add((char)i);
		}
		return letters;
	}
	
	public String getName() { // ask for the player her/his name. 
		System.out.print("\nEnter your username:");
		name = sc.nextLine();
		return name;
	}
	
	public void Words() throws Exception {
		w.ReadWordList(); // MLL
	}
	
	public void RandomWord() {
		Random rnd = new Random();
		int number = 1 + rnd.nextInt(w.mll.size()); // random between 1 and given input's size
		System.out.println("\nRandomly generated number: " + number);
		kelime = w.mll.country(number).toUpperCase(Locale.ENGLISH); // I use the toUpperCase() with parameter 
				// finding the numberTH word in MLL					// It's because normal toUpperCase() without parameter, converts "i" to upper version with dot on it.(for Turkish language)
																	// But i need "I" (English version)
		
		for (int i = 0; i < kelime.length(); i++) { // stores "-" as the number of letters of the word
			csll2.add('-'); // CSLL for the board
		}

		for (int i = 0; i < kelime.length(); i++) {
			csll1.add(kelime.charAt(i)); // main CSLL where i store the randomTH word
		}
	}
}
