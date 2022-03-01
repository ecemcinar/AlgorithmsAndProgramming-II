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
			
			for (int i = x; i >= 1; i--) { // asl�nda i=1; i<=x; i++ �eklinde bir for olu�turablirdim fakat o zaman 10 9 8 7 6.. �eklinde olu�turdu�u i�in ,  i = x; i >= 1; i-- bu �ekilde olu�turdum.
				cll.add(Integer.toString(i));
			}
			cll.display();
			cll.Josephus(x, y);	
			// A�a��daki gibi de yazabilirdim ama x<y durumunda da do�ru sonucu verdi�i i�in gerek duymad�m.Ama yine de yaz�labilir.
			
//			if(x>=y) {		
//				cll.display();
//				cll.Josephus(x, y);	
//			}
//			else {
//				System.out.println("Check the numbers!!");
//			}
		}
		catch ( InputMismatchException ex ) { // "ddsas55f" gibi do�ru olmayan inputlarda bu outputu verir.
			System.out.println("Check the input you entered.Try Again.");
		}
		
}
}
