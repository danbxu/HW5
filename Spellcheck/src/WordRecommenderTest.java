//Collaborators: Corey Parker, Daniel Xu

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




class WordRecommenderTest{
	
	ArrayList<String> wordsFromDictionary;
	ArrayList<String> wordsFromUserFile;

	@Test
	void testInstance() {
		//This will test if the object a is not null
		WordRecommender a = new WordRecommender();
		assertNotNull(a);
	}
	
	@Test
	void testFileCreation() {
		//This is to check if the obj a is created and the dictionary exists, including the file to check
		WordRecommender a = new WordRecommender();
		assertNotNull(a);
		wordsFromDictionary = a.createDFile("testdictionary");
		assertNotNull(wordsFromDictionary);
	    wordsFromUserFile = a.createFileToCheck("usertocorrect.txt");
	}

	@Test
	void testFileDCreation() {
		//Checks for obj creation and if the first word of the ArrayList from dictionary is "hello"
		WordRecommender a = new WordRecommender();
		wordsFromDictionary = a.createDFile("testdictionary");
		assertEquals("hello", wordsFromDictionary.get(0), "First word in dictionary");
		
	}

	
	@Test
	void testFileCCreation() {
		//Checks for obj creation and if the first word of the ArrayList from dictionary is "hellp"
		WordRecommender a = new WordRecommender();
		wordsFromUserFile = a.createFileToCheck("usertocorrect.txt");
		assertEquals("hellp", wordsFromUserFile.get(0), "First word in file");
	}
	
	@Test
	void getSim1() {
		//Checks if the getSimilarity method returns expected average of 3
		WordRecommender a = new WordRecommender();
		double Sim = a.getSimilarity("help", "hell");
		assertEquals(3, Sim, "First word in file");
	}
	
	@Test
	void getSim3() {
		//Checks if the getSimilarity method gives the actual average of 2
		WordRecommender a = new WordRecommender();
		double Sim = a.getSimilarity("help", "hello");
		assertEquals(Sim, 2, "Sim works");
	}
	
	
	
	

	@Test
	void print() {
		// This checks for obj creation and also if the prints and toPrint is not null
		WordRecommender a = new WordRecommender();
		ArrayList<String> list =  new ArrayList <String>();
		list.add("hi");
		list.add("hello");
		list.add("help");
		String toPrint = a.prettyPrint(list);
		assertNotNull(toPrint);
	}
	
	@Test
	void getWordS1() {
		//This checks for the words compiled for suggestions are not null 
		WordRecommender a = new WordRecommender();
		a.createFileToCheck("usertocorrect.txt");
		a.createDFile("testdictionary");
		ArrayList<String> words = a.getWordSuggestions("hellp", 2, 0.8, 5);
		assertNotNull(words);
	}
	
	@Test
	void getWordS2() {
		//This checks for the words are not null
		WordRecommender a = new WordRecommender();
		a.createFileToCheck("usertocorrect.txt");
		a.createDFile("testdictionary");
		ArrayList<String> words = a.getWordSuggestions("hellp", 1, 0.8, 2);
		assertNotNull(words);
	}
	
	@Test
	void getWordS3() {
		//This repeated checks for all the words and see if they return the given words
		WordRecommender a = new WordRecommender();
		a.createFileToCheck("usertocorrect.txt");
		a.createDFile("testdictionary");
		ArrayList<String> words = a.getWordSuggestions("hellp", 5, 0.8, 2);
		assertNotNull(words);
		ArrayList<String> words1 = a.getWordSuggestions("hellp", 3, 0.8, 2);
		assertNotNull(words1);
		ArrayList<String> words2 = a.getWordSuggestions("sleeepy", 3, 0.8, 2);
		assertNotNull(words2);
		ArrayList<String> words3 = a.getWordSuggestions("help", 3, 0.8, 2);
		assertNotNull(words3);
		ArrayList<String> words4 = a.getWordSuggestions("helpp", 3, 1, 2);
		assertNotNull(words4);
		ArrayList<String> words5 = a.getWordSuggestions("help", 3, 1, 2);
		assertNotNull(words5);
		ArrayList<String> words6 = a.getWordSuggestions("helpr", 4, 0, 2);
		assertNotNull(words6);
		ArrayList<String> words7 = a.getWordSuggestions("helpr", 1, 0, 2);
		assertNotNull(words7);
		ArrayList<String> words8 = a.getWordSuggestions("helpeeeeeeer", 1, 0, 2);
		assertNotNull(words8);
	}
	
	@Test
	void getWord4() {
		//This checks if for more words
		WordRecommender a = new WordRecommender();
		a.createFileToCheck("usertocorrect.txt");
		a.createDFile("testdictionary");
		ArrayList<String> words = a.getWordSuggestions("hellp", 1, 0.8, 2);
		assertNotNull(words);
	}
	
	
}
