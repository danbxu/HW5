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
	public void createDFile (String fileName) {
	
		String userDictionary = fileName; //unit test
	
		File userFile = new File(userDictionary); //unit test
		try {
			//create ArrayList wordsFromUserFile
			Scanner fileScanner = new Scanner(userFile);
			while (fileScanner.hasNextLine()) { 
				wordsFromDictionary.add(fileScanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Invalid file");
			e.printStackTrace(); 
		}
	}
	
	//Constructor for taking words to check
	public void createFileToCheck (String checkFile) {
		String userCheckFile = checkFile; //unit test
		
		File wordsToCheck= new File(userCheckFile); //unit test
		
		try {
			Scanner fileScanner = new Scanner(wordsToCheck);
			
			while (fileScanner.hasNext()) {
				wordsFromUserFile.add(fileScanner.next());
			}
		} catch (FileNotFoundException e) {
			System.out.println("bad file name");
			e.printStackTrace();
		}
	}
	
	public double getSimilarity (String word1, String word2) {
	
	this.word1 = word1; //unit test
	this.word2 = word2; //unit test
	double leftSim = 0; //unit test
	double rightSim = 0; //unit test
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
	
//	public static void main(String[] args) {
//		String hi = "hi";
//		String [] hello = hi.split("");
//		System.out.println(Arrays.toString(hello));
//		
//		
//	}
	
	public ArrayList<String> getWordSuggestions(String word, int tolerance, double commonPercent, int topN) {
//		this.word = word;
//		this.tolerance = tolerance;
//		this.commonPercent = commonPercent;
//		this.topN = topN;
		int candidateWordMax = word.length() + tolerance; 
		int candidateWordMin = word.length() - tolerance; 
		
		String[] incorrectWord = word.split("");
		ArrayList<String> set1 = new ArrayList<>(); 
		//set1.add(incorrectWord[0]);
		
		for (int i = 0; i < incorrectWord.length; i++) {
			if (!set1.contains(incorrectWord[i])) {
				set1.add(incorrectWord[i]);
			}
		}
		
//		for (int i = 0; i < incorrectWord.length; i++) {
//			for (int j = 0; j < incorrectWord.length; j++) {
//				if(i != j && incorrectWord[i] != incorrectWord[j]) {
//					set1.add(incorrectWord[i]);
//				}
//			}
//		
//		}
		return set1; //need to delete 
		
		
	}
	public String prettyPrint (ArrayList <String> list) {
		return "1. " + list.get(0) + "\n2. " + list.get(1) + "\n3. " + list.get(2);
	}
	
	
	
	public static void main(String[] args) {
		WordRecommender a = new WordRecommender();
		ArrayList <String> test = new ArrayList<String>();
		test.add("rick");
		test.add("rick");
		test.add("rick");
		System.out.println(a.getWordSuggestions("mississippi", 4, 75.0, 3));
		
		//System.out.println(a.prettyPrint(test));
	
	}		
		
		
}
	



