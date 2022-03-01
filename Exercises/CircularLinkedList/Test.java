package lab11;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		CircularLinkedList cll = new CircularLinkedList();
		Scanner sc = new Scanner(System.in);
		System.out.print("X:");
		try {
			int x = sc.nextInt();
			System.out.print("Y:");
			int y = sc.nextInt();
			
			for (int i = x; i >= 1; i--) { // aslýnda i=1; i<=x; i++ þeklinde bir for oluþturablirdim fakat o zaman 10 9 8 7 6.. þeklinde oluþturduðu için ,  i = x; i >= 1; i-- bu þekilde oluþturdum.
				cll.add(Integer.toString(i));
			}
			cll.display();
			cll.Josephus(x, y);	
			// Aþaðýdaki gibi de yazabilirdim ama x<y durumunda da doðru sonucu verdiði için gerek duymadým.Ama yine de yazýlabilir.
			
//			if(x>=y) {		
//				cll.display();
//				cll.Josephus(x, y);	
//			}
//			else {
//				System.out.println("Check the numbers!!");
//			}
		}
		catch ( InputMismatchException ex ) { // "ddsas55f" gibi doðru olmayan inputlarda bu outputu verir.
			System.out.println("Check the input you entered.Try Again.");
		}
		
}
}
