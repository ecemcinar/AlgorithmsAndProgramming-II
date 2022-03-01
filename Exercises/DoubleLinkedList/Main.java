package lab9;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		DoubleLinkedList DLL = new DoubleLinkedList();
		DLL.add(10); DLL.add(20); DLL.add(30); DLL.add(40); DLL.add(50);
		DLL.add(60); DLL.add(70); DLL.add(80); DLL.add(90);
		
		System.out.println("from head to tail:");
		DLL.display1();
		System.out.println("\nfrom tail to head:");
		DLL.display2();
		System.out.println("\nSize:" + DLL.size());
		
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter a number:");
		
		try {
			int number = sc.nextInt();
			DLL.swap(number);
			DLL.display1();
		}
		catch ( InputMismatchException ex ) {
			System.out.println("Check the input you entered.Try Again.");
		}
		
	}

}
