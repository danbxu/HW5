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
		ArrayList<String> set2 = new ArrayList<>();
		ArrayList<String> closeWords = new ArrayList<>();
		ArrayList<String> meetComPercent = new ArrayList<>();
		ArrayList<Double> ComPercentages = new ArrayList<>();
		
		for (int i = 0; i < incorrectWord.length; i++) {
			if (!set1.contains(incorrectWord[i])) {
				set1.add(incorrectWord[i]);
			}
		}
		
		for (int i = 0; i < wordsFromDictionary.size(); i++) {
			if (wordsFromDictionary.get(i).length() >= candidateWordMin && wordsFromDictionary.get(i).length() <= candidateWordMax) {
				closeWords.add(wordsFromDictionary.get(i));
			}
		}

		for (int i = 0; i < closeWords.size(); i++) {
			
			for (int j= 0; j < closeWords.get(i).length(); j++) {
				if (!set2.contains(incorrectWord[i])) {
					set2.add(incorrectWord[i]);
				}
				
				ArrayList <String> intersect = new ArrayList<>();
				ArrayList <String> union = new ArrayList<>();

				for (int k = 0; k < set1.size(); k++) {
					union.add(set1.get(k));
				}
				for (int k = 0; k < set2.size(); k++) {
					if (!union.contains(set2.get(k))) {
						union.add(set2.get(k));
					}
				}
				
				for (int k = 0; k < set1.size(); k++) {
					for (int l = 0; l < set2.size(); l++) {
						if (set1.get(k) == set2.get(l)) {
							intersect.add(set1.get(k));
						}
					}
				}
				double comPercent = intersect.size()/union.size();
				
				if (comPercent >= commonPercent) {
					meetComPercent.add(closeWords.get(i));
				//	ComPercentages.add(commonPercent);
				}

			}
			set2.clear();
		}
		
		for (int i = 0; i < meetComPercent.size(); i++ ) {
			getSimilarity(word, meetComPercent.get(0));
			
		}
		
		
		
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
	



