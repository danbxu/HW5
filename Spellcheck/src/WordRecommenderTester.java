import java.util.ArrayList;
import java.util.*;

public class WordRecommenderTester {
	public static void main(String[] args) {
		Scanner abc = new Scanner(System.in);
		
		PrintToScreen z = new PrintToScreen();
		WriteNewFile bee = new WriteNewFile();		
		
		System.out.println("Enter file name for spellcheck.");
		
		String userFile = abc.next();
		ArrayList<String> correctedWords = z.correctMis(userFile, "engDictionary.txt");
	
		bee.writeNewFileName(userFile, correctedWords);
	
	}
}
