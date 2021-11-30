import java.util.Random;

	
public class Main {
	
	public static void main(String[] args) {
		SingleLinkedList sll1 = new SingleLinkedList();
		SingleLinkedList sll2 = new SingleLinkedList();
		SingleLinkedList sll3 = new SingleLinkedList();
		SingleLinkedList gameControl = new SingleLinkedList(); // sll classýnda yazdýðým metodlarý kullanabilmek için bunu oluþturdum.
		Random rnd = new Random();
		boolean flag= true;    // oyunun akmasýný saðlayan flag, yani random atýlmasýný saðlayan
		boolean flag1 = true; // oyun sýrasý
		boolean flag2=true; // kural 2'nin tekrarý engellemek için
		
		
		while(flag) { // oyun dönügüsü
			if(flag1==true && flag2==true) { // user1 turn
				
				int number = 1 + rnd.nextInt(5); // random between 1 and 5
				int listNumber = 1 + rnd.nextInt(3); // 1 gelirse sll1, iki gelirse sll2, 3 gelirse sll3
				System.out.print("User1:");
				if(listNumber==1) {
					if(sll1.size()<8) sll1.insert(number);
					else {
						int newNumber = 2 +rnd.nextInt(1);
						if(newNumber==2) {
							if(sll2.size()<8) sll2.insert(number);
							else sll3.insert(number);                   // (both sll1.size>8 and sll2.size>8) number goes to sll3
						}
						else { // newNumber==3;
							if(sll3.size()<8) sll3.insert(number);
							else sll2.insert(number);                 //(both sll1.size>8 and sll3.size>8) number goes to sll2
						}
					}
				}
				
				else if(listNumber==2) {
					if(sll2.size()<8) sll2.insert(number);
					else {
						int newNumber = rnd.nextInt(1); // if random==0 number goes to sll1 AND if random==1 number goes to sll3
						if(newNumber==0) {
							if(sll1.size()<8) sll1.insert(number);
							else sll3.insert(number);                // (both sll1.size>8 and sll2.size>8) number goes to sll3
						}
						else { //newNumber==1
							if(sll3.size()<8) sll3.insert(number);
							else sll1.insert(number);                 //sll3.size 8'i geçmiþse
						}
					}	
				}
				else if(listNumber==3) {
					if(sll3.size()<8) sll3.insert(number);
					else {
						int newNumber = 1+ rnd.nextInt(1); // 1 gelirse 1' e at, 2 gelirse 2'ye at
						if(newNumber==1) {
							if(sll1.size()<8) sll1.insert(number); // sll1.size da 8'i geçmiþse
							else sll2.insert(number);
						}
						else { // newNumber ==2
							if(sll2.size()<8) sll2.insert(number);
							else sll3.insert(number);
						}
					}
				}
				
				System.out.print("\nSLL1 ");
				sll1.display();
				System.out.print("\nSLL2 ");
				sll2.display();
				System.out.print("\nSLL3 ");
				sll3.display();
				System.out.println("\n*********************");
				flag1=false;
			}
			
			if(!sll1.game() || !sll2.game() || !sll3.game()) { // her list için ayrý ayrý kontrol edilmeli. bi tanesi saðlanýyorsa kazanan belirlenmiþ demektir.
				System.out.println("Game Over" + "\nWinner is User1!!" + "\nRule: Horizontal");
				 flag = false;
				 flag2=false;
				 break;
			}
			
			if(!gameControl.game2(sll1,sll2, sll3)) {
				  flag=false;
				  flag2=false;
				  System.out.println("Game Over"+ "\nWinner is User1!!" + "\nRule:Vertical");
				  break;
			  }
			
			if(!gameControl.game3(sll1,sll2, sll3)) {
				  flag=false;
				  System.out.println("Game Over"+ "\nWinner is User1!!" + "\nRule:Diagonal");
				  break;
			  }
			if(!gameControl.game4(sll1,sll2, sll3)) {
				  flag=false;
				  System.out.println("Game Over"+ "\nWinner is User1!!"+ "\nRule:Diagonal");
				  break;
			  }
			
			
			else if(flag1==false && flag2==true && flag) { // user2 turn
				int number = 1 + rnd.nextInt(5); // 1 ve 5 arasýnda random atar
				int listNumber = 1 + rnd.nextInt(3); // 1 gelirse sll1, iki gelirse sll2, 3 gelirse sll3
				
				System.out.print("User2:");
				if(listNumber==1) {
					if(sll1.size()<8) sll1.insert(number);
					else {
						int newNumber = 2 +rnd.nextInt(1);
						if(newNumber==2) {
							if(sll2.size()<8) sll2.insert(number);
							else sll3.insert(number);                   // sll2.size'da 8i geçmiþse
						}
						else { // newNumber==3;
							if(sll3.size()<8) sll3.insert(number);
							else sll2.insert(number);                 //sll3.size 8'i geçmiþse
						}
					}
				}
				else if(listNumber==2) {
					if(sll2.size()<8) sll2.insert(number);
					else {
						int newNumber = rnd.nextInt(1); // 0 gelirse 1'e at, 1 gelirse 3'e at
						if(newNumber==0) {
							if(sll1.size()<8) sll1.insert(number);
							else sll3.insert(number);                // sll1.size'da 8i geçmiþse
						}
						else { //newNumber==1
							if(sll3.size()<8) sll3.insert(number);
							else sll1.insert(number);                 //sll3.size 8'i geçmiþse
						}
					}
				}
				else if(listNumber==3) {
					if(sll3.size()<8) sll3.insert(number);
					else {
						int newNumber = 1+ rnd.nextInt(1); // 1 gelirse 1' e at, 2 gelirse 2'ye at
						if(newNumber==1) {
							if(sll1.size()<8) sll1.insert(number); // sll1.size da 8'i geçmiþse
							else sll2.insert(number);
						}
						else { // newNumber ==2
							if(sll2.size()<8) sll2.insert(number);
							else sll3.insert(number);
						}
					}
				}
				System.out.print("\nSLL1 ");
				sll1.display();
				System.out.print("\nSLL2 ");
				sll2.display();
				System.out.print("\nSLL3 ");
				sll3.display();
				System.out.println("\n*********************");
				flag1=true;	
			}
			
			  if(!sll1.game() || !sll2.game() || !sll3.game()) {
				System.out.println("Game Over"+ "\nWinner is User2!!" + "\nRule:Horizontal");
				 flag = false; 
				 break;
			}
			  
			  if(!gameControl.game2(sll1,sll2,sll3)) {
				  flag=false;
				  System.out.println("Game Over"+ "\nWinner is User2!!"+ "\nRule:Vertical");
				  break;
			  }
			  
			  if(!gameControl.game3(sll1,sll2,sll3)) {
				  flag=false;
				  System.out.println("Game Over"+ "\nWinner is User2!!"+ "\nRule:Diagonal");
				  break;
			  }
			  
			  if(!gameControl.game4(sll1,sll2,sll3)) {
				  flag=false;
				  System.out.println("Game Over"+ "\nWinner is User2!!"+ "\nRule:Diagonal");	
				  break;
			  }
			  
			  
			  if(sll1.size()==8 && sll2.size()==8 && sll3.size()==8 && flag2==true && flag==true) {
					flag=false;
					System.out.println("TIE");
				}
		}
		
	}

}
