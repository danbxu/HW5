import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WordRecommender {

	String filename; //refers to the file 
	//containing a dictionary of correct words
	//ensure that spellcheck can run with any file name


	String word1;
	String word2;
	ArrayList<String> wordsFromDictionary;
	ArrayList<String> wordsFromUserFile;

	//Constructor for taking dictionary File
	public WordRecommender (String fileName, String checkFile) {
		//create objective
		String userDictionary = fileName;
		String userCheckFile = checkFile;
		//set as new
		File userFile = new File(userDictionary);

		try {
			//create ArrayList wordsFromUserFile
			Scanner fileScanner = new Scanner(userFile);
			while (fileScanner.hasNextLine()) { //This would need to be changed
				wordsFromDictionary.add(fileScanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Invalid file");
			e.printStackTrace();

		}

		/**
		 * Once ArrayList<String> for userDictionary is created, now create 
		 * a ArrayList for all words to check spelling
		 */
		//System.out.println(Arrays.toString(wordsFromUserFile))

		//created a handle/file object
		File f = new File(userCheckFile);
		try {
			//try to do stuff
			Scanner fileScanner = new Scanner(f);
			//need to ask about this
			while (fileScanner.hasNext()) {
				wordsFromUserFile.add(fileScanner.next());
			}
		} catch (FileNotFoundException e) {
			System.out.println("bad file name");
			e.printStackTrace();
		}
	}
	
	public double getSimilarity (String word1, String word2) {
	
	this.word1 = word1;
	this.word2 = word2;
	double leftSim = 0;
	double rightSim = 0;
	int b = 0;
	
	int diff = word1.length() - word2.length();
	
	if (diff >= 0) {
		b = word1.length();
	}
	if (diff < 0) {
		b = word2.length();
	}
	
	for (int i = 0; i < b; i++) {
		if (word1.charAt(i) == word1.charAt(i)) {
			leftSim++;
		}
	}
	
	for (int i = -1; i > -b - 1; i--) {
		if (word1.charAt(i) == word1.charAt(i)) {
			rightSim++;
		}
	}
	
	double average = (rightSim + leftSim)/2;
	return average;

	}
}



