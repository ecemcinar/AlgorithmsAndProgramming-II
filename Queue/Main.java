import java.util.Random;

public class Main {

	public static void main(String[] args) {
	
		Random rnd = new Random();
		Queue first_dna = new Queue(1000); // first queue for dna
		Queue comp_dna = new Queue(1000); // second queue for complement dna
		Queue amino = new Queue(1000); // third queue for triple dna code
	    Queue aminoAcids_name = new Queue(1000);  // fourth queue for the amino acids
	    
		for (int i = 0; i < 21; i++) {
			char symbol; // for the base
			int number = rnd.nextInt(4);  // generate base randomly for first dna 
			if(number == 0) {
				symbol ='A';
				first_dna.enqueue(symbol);
			}
			else if(number == 1) {
				symbol ='T';
				first_dna.enqueue(symbol);
			}
			else if(number == 2) {
				symbol ='G';
				first_dna.enqueue(symbol);
			}
			else if(number == 3) {
				symbol ='C';
				first_dna.enqueue(symbol);
			}			
		}
		Queue saved_dna1 = new Queue(1000); 	
		System.out.println("-First DNA-"); // print first dna 
		for (int i = 0; i <21; i++) {
			System.out.print(first_dna.peek() + " ");
			first_dna.enqueue(first_dna.dequeue());
		}
		System.out.println();
		// construct a new queue which contains the complement of the DNA sequence --- complement dna
		for(int i =0; i < 21; i++) {
			char new_symbol; // complement base
			char symbol; // base 
			symbol = (char) first_dna.peek();
			if(symbol == 'A') { // A-T
				new_symbol = 'T';
				comp_dna.enqueue(new_symbol);
				first_dna.enqueue(first_dna.dequeue());
			}
			else if(symbol == 'T') { // T-A
				new_symbol = 'A';
				comp_dna.enqueue(new_symbol);
				first_dna.enqueue(first_dna.dequeue());
			}
			else if(symbol == 'G') { // G-C
				new_symbol = 'C';
				comp_dna.enqueue(new_symbol);
				first_dna.enqueue(first_dna.dequeue());
			}
			else if(symbol == 'C') { // C-G
				new_symbol = 'G';
				comp_dna.enqueue(new_symbol);
				first_dna.enqueue(first_dna.dequeue());
			}
		}
		System.out.println("\n-Complement of first DNA-"); // print the complement dna
		for (int i = 0; i < 21; i++) {
			System.out.print(comp_dna.peek() + " ");
			first_dna.enqueue(comp_dna.dequeue());
		}
		
		for(int i =0; i<21;i++) { // This is necessary because it will used in crossover part
			saved_dna1.enqueue(first_dna.dequeue());
		}		
		Queue saved_dna2 = new Queue(1000); // this is necessary too. It will used in amino acids part
		
		for(int i =0; i < 21; i++) { // this is the most important part. Without it, amino acids printed wrong. There was a problem in here, when I fix it with adding this code.
			char new_symbol;
			char symbol;
			symbol = (char) first_dna.peek();
			if(symbol == 'A') { // A-T
				new_symbol = 'T';
				saved_dna2.enqueue(new_symbol);
				first_dna.enqueue(first_dna.dequeue());
			}
			else if(symbol == 'T') { // T-A
				new_symbol = 'A';
				saved_dna2.enqueue(new_symbol);
				first_dna.enqueue(first_dna.dequeue());
			}
			else if(symbol == 'G') { // G-C
				new_symbol = 'C';
				saved_dna2.enqueue(new_symbol);
				first_dna.enqueue(first_dna.dequeue());
			}
			else if(symbol == 'C') { // C-G
				new_symbol = 'G';
				saved_dna2.enqueue(new_symbol);
				first_dna.enqueue(first_dna.dequeue());
			}
		}
		System.out.println();
		// for the second part ( amino acids )
		for (int i = 0; i < 7; i++) {
			String amino_acid ="";
			for (int j = 0; j < 3; j++) {
				amino_acid += saved_dna2.dequeue();		// I stored the dna codes 3-3			
			}
			amino.enqueue(amino_acid);
		}
		System.out.println("\n**Each 3 letters of DNA code for one amino acid**"); 
		
		for (int i = 0; i < 7; i++) {
			System.out.print(amino.peek() + " ");
			amino.enqueue(amino.dequeue());
		}
		System.out.println();
		for (int i = 0; i < 7; i++) { // A DNA sequence codes for a sequence of amino acids that make up a protein. Each 3 letters of DNA code for one amino acid
			String piece = (String) amino.dequeue();
			// starts with A
			if (piece.startsWith("AA")) {
				if (piece.endsWith("A") || piece.endsWith("G")) aminoAcids_name.enqueue("Lys");
				else aminoAcids_name.enqueue("Asn");	
			}
			else if ( piece.startsWith("AC")) aminoAcids_name.enqueue("Thr");
			else if (piece.startsWith("AG")) {
				if (piece.endsWith("A") || piece.endsWith("G")) aminoAcids_name.enqueue("Arg");
				else aminoAcids_name.enqueue("Ser");	
			}
			else if (piece.startsWith("AT")) {
				if (piece.endsWith("G")) aminoAcids_name.enqueue("Stop");
				else aminoAcids_name.enqueue("Ile");	
			}
					// starts with C
			else if (piece.startsWith("CA")) {
				if (piece.endsWith("A") || piece.endsWith("G")) aminoAcids_name.enqueue("Gln");
				else aminoAcids_name.enqueue("His");	
			}
			else if ( piece.startsWith("CC")) aminoAcids_name.enqueue("Pro");
			else if ( piece.startsWith("CT")) aminoAcids_name.enqueue("Leu");
			else if ( piece.startsWith("CG")) aminoAcids_name.enqueue("Arg");
			// starts with T
			else if (piece.startsWith("TA")) {
				if (piece.endsWith("A") || piece.endsWith("G")) aminoAcids_name.enqueue("Stop");
				else aminoAcids_name.enqueue("Tyr");	
			}
			else if ( piece.startsWith("TC")) aminoAcids_name.enqueue("Ser");
			else if (piece.startsWith("TT")) {
				if (piece.endsWith("A") || piece.endsWith("G")) aminoAcids_name.enqueue("Leu");
				else aminoAcids_name.enqueue("Phe");	
			}
			else if (piece.startsWith("TG")) {
				if (piece.endsWith("A"))  aminoAcids_name.enqueue("Stop");
				else if (piece.endsWith("C") || piece.endsWith("T")) aminoAcids_name.enqueue("Cys"); 
				else aminoAcids_name.enqueue("Trp");	
			}
			// starts with G
			else if (piece.startsWith("GA")) {
				if (piece.endsWith("A") || piece.endsWith("G")) aminoAcids_name.enqueue("Glu");
				else aminoAcids_name.enqueue("Asp");	
			}			
			else if ( piece.startsWith("GC")) aminoAcids_name.enqueue("Ala");
			else if ( piece.startsWith("GT")) aminoAcids_name.enqueue("Val");
			else if ( piece.startsWith("GG")) aminoAcids_name.enqueue("Gly");			
		}		
		System.out.println("\n-Amino Acids-"); // printed amino acids
		
		for (int i = 0; i < 7; i++) {
			System.out.print(aminoAcids_name.peek() + " ");
			aminoAcids_name.enqueue(aminoAcids_name.dequeue());
		}		
		System.out.println();
		
		Queue second_dna = new Queue(1000); // second dna that act in crossover 
		for (int i = 0; i < 21; i++) {
			char symbol;
			int number = rnd.nextInt(4);  // generate symbols randomly for second dna 
			if(number == 0) {
				symbol ='A';
				second_dna.enqueue(symbol);
			}
			else if(number == 1) {
				symbol ='T';
				second_dna.enqueue(symbol);
			}
			else if(number == 2) {
				symbol ='G';
				second_dna.enqueue(symbol);
			}
			else if(number == 3) {
				symbol ='C';
				second_dna.enqueue(symbol);
			}			
		}
		System.out.println("\n-Second DNA before crossover-"); // print second dna. It will used for crossover part
		for (int i = 0; i < 21; i++) {
			System.out.print(second_dna.peek() + " ");
			second_dna.enqueue(second_dna.dequeue());
		}	
		System.out.println();
		// Crossover part 
		int crossover = 1 +  rnd.nextInt(20); // random selected crossover point
		System.out.println("\nRandomly generated crossover point:" + crossover);		
		for (int i = 0; i < 21; i++) {
			if(i < crossover) {
				saved_dna1.enqueue(saved_dna1.dequeue());
				second_dna.enqueue(second_dna.dequeue());
			}
			else // crossover starting here. it happenes when i>= crossoverpoint 
			{
				saved_dna1.enqueue(second_dna.dequeue());
				second_dna.enqueue(saved_dna1.dequeue());
			}			
		}		
		//print first and second dna after crossover
		System.out.println("\n\t**After Crossover**");
		System.out.println("-First DNA-");
		for (int i = 0; i < 21 ; i++) {
			System.out.print(saved_dna1.peek() + " ");
			saved_dna1.enqueue(saved_dna1.dequeue());
		}
		System.out.println(); // print second one
		System.out.println("-Second DNA-");
		for (int i = 0; i < 21; i++) {
			System.out.print(second_dna.peek() + " ");
			second_dna.enqueue(second_dna.dequeue());
		}		
	}
}