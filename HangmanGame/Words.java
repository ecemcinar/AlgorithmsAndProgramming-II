import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Words {

	MLL mll = new MLL();
	
	public void ReadWordList() throws Exception {
		File file = new File("input.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
		String st;
		
		// without using array, i directly store words in MLL
		while ((st = br.readLine()) != null) { 
			mll.addRow(st.length()); // firstly, add letter count of the word to the row 
			mll.addColumn(st.length(),st); // then add the (letter count,word) to the column
		}
		
	}
}
