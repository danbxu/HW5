//Collaborators: Corey Parker, Daniel Xu

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class WriteNewFile {


	
	
	/**
	 * This method will output the corrected ArrayList<String> of corrected
	 * words and store that into a file that will be renamed by removing ".txt"
	 * and concatenating "_chk.txt"
	 * 
	 * @param filename (name to check and edit)
	 * @param file (ArrayList containing all the corrected words)
	 */
	public void writeNewFileName (String filename, ArrayList<String> file) {
		String[] xyz = null;
		//remove at period
		xyz = filename.split("\\.");
		//pull name of the file to concat. with "_chk.txt"
		String updateFile = xyz[0];
		try {
			PrintWriter pw = new PrintWriter(updateFile + "_chk.txt");
			for (int i = 0; i < file.size(); i++) {
				pw.print(file.get(i) + " ");
			}
			pw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
