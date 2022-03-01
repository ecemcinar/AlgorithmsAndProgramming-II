import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class HighScoreTable {

	SLL sll = new SLL();
	
	public void Read() throws Exception { // read the given file
		File file = new File("HighScoreTable.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
		String st;
		int satir = 0;
		int counter=0;
		while ((st = br.readLine()) != null) {
			counter++; // get the count of given file
		}
		
		
		BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
		String[][] peopleWithScore = new String[counter][2]; // create an array to keep players' names and scores
		while ((st = br2.readLine()) != null) {
			String[] array= st.split(";");
			for (int i = 0; i < array.length; i++) {
				peopleWithScore[satir][i] = array[i];
			}
			satir++;
		}
		// add to the SLL
		for (int i = 0; i < peopleWithScore.length; i++) { 
			User user = new User(peopleWithScore[i][0],Integer.parseInt(peopleWithScore[i][1])); // creating user objects to store names and scores
			sll.insert(user); // adding these user objects to the SLL ( by sorting their scores highest to the lowest)
		}
	}
}
