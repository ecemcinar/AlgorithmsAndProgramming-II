package lab12;

import java.util.Scanner;

public class TestStack {

	static boolean Parenthesis(String s) {
		LinkedStack ls = new LinkedStack();
		String[] arr = s.split("");
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].contains("(") || arr[i].contains(")") ) {
				ls.push(arr[i]);
			}
			else continue;
		}
		int count=0;
		
		while(!ls.isEmpty()) {
			if(ls.peek().toString().contains("("))count++; 
			else count--; // yani parantez ) seklindeyse eksiliyor. 
			ls.pop();
		}
		if(count==0) return true; // birbirlerine esit olmalarý gerekiyor, yani tuttugum countun 0'a esit olmasý lazým
		else return false;
		
 	}
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("input:");
        String s = in.nextLine();

        System.out.println("Output: " + Parenthesis(s));
	}

}
