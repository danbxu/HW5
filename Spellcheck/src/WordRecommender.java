import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordRecommender {

	String filename; //refers to the file 
	//containing a dictionary of correct words
	//ensure that spellcheck can run with any file name
	
	
	String word1;
	String word2;
	
	//Constructor for taking in a file 
	public WordRecommender (String fileName) {
		String userFileName = fileName;
		
		
		File userFile = new File(userFileName);
		try {
			//try to do stuff
			Scanner fileScanner = new Scanner(userFile);
			while (fileScanner.hasNextLine()) {
				System.out.println(fileScanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Invalid file");
			e.printStackTrace();
		}
		
		
		
		
	
		
		
	//get similarities and return average of the two words
	//maybe use 2 forloops
	public double getSimilarity (String word1, String word2) {
	
	double leftSimilarity = 0;
	double rightSimilarity = 0;
	
	double numbers = 2.9;
	
	return numbers;
		
	}
	}
	
	
	
	
	
}



